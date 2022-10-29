package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.PersonDAO;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.exception.sqlexception.PersonDatabaseException;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import be.icc.ahe.marryme.model.mapper.PersonMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.RegistrationUserMapper;
import be.icc.ahe.marryme.service.EmailService;
import be.icc.ahe.marryme.service.PersonService;
import be.icc.ahe.marryme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.Optional;

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
    public Person register(UserRegistrationFormDTO userForm) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException {
        userService.validateNewEmail(EMPTY, userForm.getEmail());

        Person person = RegistrationUserMapper.INSTANCE.dtotomodel(userForm);
        User user = person.getUser();
        user.setJoinDate(new Date());
        user.setPassword(userService.encodePassword(userForm.getPassword()));

        user.setActive(false);

        user.setNotLocked(true);
        user.setRole(ROLE_USER);
        user.setAuthorities(ROLE_USER.getAuthorities());
        person.setUser(user);

        PersonEntity personEntity =  PersonMapper.INSTANCE.modelToEntity(person);
        personDAO.save(personEntity);

        return PersonMapper.INSTANCE.entityToModel(personEntity);

    }

    @Override
    public Person save(Person person) throws PersonDatabaseException {

        Optional.ofNullable(person)
                .orElseThrow(() -> new PersonDatabaseException("Can not persist null person: " + person));

        PersonEntity persistedPersonEntity = personDAO.save(PersonMapper.INSTANCE.modelToEntity(person));

        Optional.ofNullable(persistedPersonEntity)
                .orElseThrow(() -> new PersonDatabaseException("Persisted person is null: " + persistedPersonEntity));

        return PersonMapper.INSTANCE.entityToModel(persistedPersonEntity);

    }

    @Override
    public Person findByID(Long id) throws PersonDatabaseException {

        PersonEntity personEntity = this.personDAO.findById(id)
                .orElseThrow(() -> new PersonDatabaseException("None person found at id:" + id));

        return PersonMapper.INSTANCE.entityToModel(personEntity);

    }

    @Override
    public Person update(Person person) throws PersonDatabaseException {

        Optional.ofNullable(person)
                .orElseThrow(() -> new PersonDatabaseException("Can not persist null person: " + person));

        if (personDAO.existsById(person.getPersonID())) {
            throw new PersonDatabaseException("Try to update into data base a person that does not exist: " + person);
        }

        PersonEntity persistedPersonEntity = personDAO.save(PersonMapper.INSTANCE.modelToEntity(person));


        Optional.ofNullable(persistedPersonEntity)
                .orElseThrow(() -> new PersonDatabaseException("Persisted person is null: " + persistedPersonEntity));

        return PersonMapper.INSTANCE.entityToModel(persistedPersonEntity);
    }

    @Override
    public void deleteById(Long id) throws PersonDatabaseException {
        if (personDAO.existsById(id)) {
            personDAO.deleteById(id);
        } else {
            throw new PersonDatabaseException("None person found at id: " + id);
        }
        if (personDAO.existsById(id)) {
            throw new PersonDatabaseException("Failed to delete person into database at id: " + id);
        }
    }


}
