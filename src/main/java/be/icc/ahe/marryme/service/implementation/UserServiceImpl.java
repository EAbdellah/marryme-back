package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.PersonDAO;
import be.icc.ahe.marryme.dataaccess.dao.TokenAccesDAO;
import be.icc.ahe.marryme.dataaccess.dao.UserDAO;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.entity.VerificationTokenEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.sqlexception.UserDatabaseException;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.mapper.PersonMapper;
import be.icc.ahe.marryme.model.mapper.UserMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.security.domain.UserPrincipal;
import be.icc.ahe.marryme.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

import static be.icc.ahe.marryme.constant.UserImplConstant.NO_USER_FOUND_BY_EMAIL;
import static be.icc.ahe.marryme.constant.UserImplConstant.EMAIL_ALREADY_EXISTS;
import static be.icc.ahe.marryme.constant.UserImplConstant.FOUND_USER_BY_EMAIL;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    private LoginAttemptService loginAttemptService;
    private BCryptPasswordEncoder passwordEncoder;
    private final UserDAO userDAO;
    private final PersonDAO personDAO;
    private final TokenAccesDAO tokenAccesDAO;


    @Autowired
    public UserServiceImpl(UserDAO userDAO,PersonDAO personDAO, BCryptPasswordEncoder passwordEncoder, LoginAttemptService loginAttemptService,TokenAccesDAO tokenAccesDAO) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.loginAttemptService = loginAttemptService;
        this.tokenAccesDAO = tokenAccesDAO;
        this.personDAO = personDAO;

    }

    @Override
    public User save(UserEntity userEntity) throws Exception {
        return UserMapper.INSTANCE.entityToModel(userDAO.save(userEntity),new CycleAvoidingMappingContext());
    }

    public User findUserByEmail(String email){

        UserEntity userEntity =  userDAO.findUserByEmail(email);
        User user = UserMapper.INSTANCE.entityToModel(userEntity,new CycleAvoidingMappingContext());

        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_EMAIL + email);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_EMAIL + email);
        } else {
            return user;
        }

    }

    @Override
    public void createVerificationToken(User user, String token) {
        UserEntity userEntity = UserMapper.INSTANCE.modelToEntity(user,new CycleAvoidingMappingContext());
        VerificationTokenEntity myToken = new VerificationTokenEntity(token, userEntity);
        myToken.setExpiryDate(20);
        tokenAccesDAO.save(myToken);
    }

    @Override
    public VerificationTokenEntity getVerificationToken(String VerificationToken) {

        return tokenAccesDAO.findByToken(VerificationToken);

    }

    // TODO: 16/10/2022
    //  Verifier le nom et prenom non null
    // ecarter spé char
    //tester person si null
    //si change email alors revalidation
    // n'utiliser personDao que dans PersonService  -- REFRACTORING --

    @Override
    public User updateUser(String currentEmail, String newEmail, String newLastName, String newFirstName) throws UserNotFoundException, EmailExistException, IOException {

        User currentUser = validateNewEmail(currentEmail, newEmail);
        Optional<PersonEntity> personOpt = personDAO.findById(currentUser.getUserID());
        Person person = (Person) Optional.ofNullable(null).orElse(PersonMapper.INSTANCE.entityToModel(personOpt.get()));

        person.setFirstName(newFirstName);
        person.setLastName(newLastName);

        currentUser.setEmail(newEmail);


        person.setUser(currentUser);
        PersonEntity personEntity = PersonMapper.INSTANCE.modelToEntity(person);

        personDAO.save(personEntity);
        return currentUser;    }


    @Override
    public void deleteUser(String email) throws IOException {
        UserEntity userEntity = userDAO.findUserByEmail(email);

        System.out.println(personDAO.findPersonByUser(userEntity));


//        userDAO.deleteById(userEntity.getUserID());
    }

    @Override
    public UserEntity findByID(Long id) throws UserDatabaseException {
        return this.userDAO.findByID(id).orElseThrow(UserDatabaseException::new);
    }

//    @Override
//    public UserEntity update(Long id) throws UserDatabaseException {
//        return userDAO.update(id);
//    }

    @Override
    public void deleteById(Long id) throws UserDatabaseException {
        userDAO.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userDAO.findUserByEmail(email);
        User user = UserMapper.INSTANCE.entityToModel(userEntity,new CycleAvoidingMappingContext());

        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_EMAIL + email);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_EMAIL + email);
        } else {
            validateLoginAttempt(user);
            user.setLastLoginDateDisplay(user.getLastLoginDate());
            user.setLastLoginDate(new Date());
            userEntity = UserMapper.INSTANCE.modelToEntity(user,new CycleAvoidingMappingContext());
            userDAO.save(userEntity);

            UserPrincipal userPrincipal = new UserPrincipal(user);
            LOGGER.info(FOUND_USER_BY_EMAIL + email);
            return userPrincipal;
        }
    }

    private void validateLoginAttempt(User user) {
        if(user.isNotLocked()) {
            if(loginAttemptService.hasExceededMaxAttempts(user.getEmail())) {
                user.setNotLocked(false);
            } else {
                user.setNotLocked(true);
            }
        } else {
            loginAttemptService.evictUserFromLoginAttemptCache(user.getEmail());
        }
    }

    @Override
    public User validateNewEmail(String currentEmail, String newEmail) throws UserNotFoundException, EmailExistException {

        UserEntity newUserEntity = userDAO.findUserByEmail(newEmail);
        User userByNewEmail = UserMapper.INSTANCE.entityToModel(newUserEntity,new CycleAvoidingMappingContext());

        if(StringUtils.isNotBlank(currentEmail)) {

            UserEntity currentUserEntity = userDAO.findUserByEmail(currentEmail);
            User currentUser = UserMapper.INSTANCE.entityToModel(currentUserEntity,new CycleAvoidingMappingContext());

            if(currentUser == null) {
                throw new UserNotFoundException(NO_USER_FOUND_BY_EMAIL + currentEmail);
            }
            if(userByNewEmail != null && !currentUser.getUserID().equals(userByNewEmail.getUserID())) {
                throw new EmailExistException(EMAIL_ALREADY_EXISTS);
            }
            return currentUser;
        } else {

            if(userByNewEmail != null) {
                throw new EmailExistException(EMAIL_ALREADY_EXISTS);
            }
            return null;
        }
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

//    @Override
//    public String getTemporaryProfileImageUrl(String username) {
//        return ServletUriComponentsBuilder.fromCurrentContextPath().path(DEFAULT_USER_IMAGE_PATH + username).toUriString();
//    }



}
