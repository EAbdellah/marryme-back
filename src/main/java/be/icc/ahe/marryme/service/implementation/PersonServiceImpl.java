package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.PersonDAO;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import be.icc.ahe.marryme.model.mapper.PersonMapper;
import be.icc.ahe.marryme.model.mapper.UserMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.RegistrationUserMapper;
import be.icc.ahe.marryme.service.EmailService;
import be.icc.ahe.marryme.service.PersonService;
import be.icc.ahe.marryme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;

import static be.icc.ahe.marryme.dataaccess.entity.enumeration.Role.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDAO personDAO;
    private final UserService userService;
    private final EmailService emailService;


    @Autowired
    public PersonServiceImpl(PersonDAO personDAO, UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
        this.personDAO = personDAO;
    }

    @Override
    public void save(PersonEntity personEntity) throws Exception{
        personDAO.save(personEntity);

    }

    @Override
    public Person register(UserRegistrationFormDTO userForm) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException {
        userService.validateNewEmail(EMPTY, userForm.getEmail());

        System.out.println(userForm);
        Person person = RegistrationUserMapper.INSTANCE.dtotomodel(userForm);
        User user = person.getUser();
        user.setJoinDate(new Date());
        user.setPassword(userService.encodePassword(userForm.getPassword()));

//        user.setActive(true);
        user.setActive(false);

        user.setNotLocked(true);
        user.setRole(ROLE_USER);
        user.setAuthorities(ROLE_USER.getAuthorities());
        person.setUser(user);
//        person.getUser().setProfileImageUrl(userService.getTemporaryProfileImageUrl(username));

        PersonEntity personEntity =  PersonMapper.INSTANCE.modelToEntity(person);
        personDAO.save(personEntity);

//        emailService.sendLinkToActivateAccount(person.getFirstName(), person.getUser().getEmail());

        return PersonMapper.INSTANCE.entityToModel(personEntity);

    }




//    @Override
//    public void deleteByID(Long id) throws Exception {
//        personDAO.
//    }
}
