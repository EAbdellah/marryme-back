package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.UserDAO;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.repository.UserRepo;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.mapper.UserMapper;
import be.icc.ahe.marryme.model.mapper.UserMapperImpl;
import be.icc.ahe.marryme.security.domain.UserPrincipal;
import be.icc.ahe.marryme.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;

import static be.icc.ahe.marryme.constant.UserImplConstant.NO_USER_FOUND_BY_EMAIL;
import static be.icc.ahe.marryme.constant.UserImplConstant.EMAIL_ALREADY_EXISTS;
import static be.icc.ahe.marryme.constant.UserImplConstant.FOUND_USER_BY_EMAIL;


import java.util.Date;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    private LoginAttemptService loginAttemptService;
    private BCryptPasswordEncoder passwordEncoder;
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder, LoginAttemptService loginAttemptService) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.loginAttemptService = loginAttemptService;

    }

    @Override
    public void save(UserEntity userEntity) throws Exception {
        userDAO.save(userEntity);
    }

    public User findUserByEmail(String email){

        UserEntity userEntity =  userDAO.findUserByEmail(email);
        User user = UserMapperImpl.INSTANCE.entityToModel(userEntity);

        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_EMAIL + email);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_EMAIL + email);
        } else {
            return user;
        }

    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userDAO.findUserByEmail(email);
        User user = UserMapper.INSTANCE.entityToModel(userEntity);

        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_EMAIL + email);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_EMAIL + email);
        } else {
            validateLoginAttempt(user);
            user.setLastLoginDateDisplay(user.getLastLoginDate());
            user.setLastLoginDate(new Date());
            userEntity = UserMapper.INSTANCE.modelToEntity(user);
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
        User userByNewEmail = UserMapper.INSTANCE.entityToModel(newUserEntity);

        if(StringUtils.isNotBlank(currentEmail)) {

            UserEntity currentUserEntity = userDAO.findUserByEmail(currentEmail);
            User currentUser = UserMapper.INSTANCE.entityToModel(currentUserEntity);

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
