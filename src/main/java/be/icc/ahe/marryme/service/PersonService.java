package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface PersonService {
    void save(PersonEntity personEntity) throws Exception;
//    void deleteByID(Long id) throws Exception;

    Person register(UserRegistrationFormDTO userForm) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;


}

