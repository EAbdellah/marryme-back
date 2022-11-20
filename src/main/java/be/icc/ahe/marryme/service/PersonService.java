package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.PersonDatabaseException;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.sql.SQLDataException;

@Service
public interface PersonService {
    Person save(Person person) throws Exception;
    Person register(UserRegistrationFormDTO userForm) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;
    Person findByID(Long id) throws PersonDatabaseException;
    Person update(Person person) throws PersonDatabaseException;
    void deleteById(Long id) throws PersonDatabaseException;
    Person registerProvider(ProviderRegisterFormDTO userForm) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;
    PersonEntity findPersonByUser(UserEntity userEntity);
}

