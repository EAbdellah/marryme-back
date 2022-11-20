package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.entity.VerificationTokenEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.UserDatabaseException;
import be.icc.ahe.marryme.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface UserService {
    User save(UserEntity userEntity) throws Exception;
    User validateNewEmail(String currentEmail, String newEmail) throws UserNotFoundException, EmailExistException;

    String encodePassword(String password);

    User findUserByEmail(String email);

    void createVerificationToken(User user, String token);

    VerificationTokenEntity getVerificationToken(String VerificationToken);

    User updateUser(String currentEmail, String newEmail, String newLastName, String newFirstName) throws UserNotFoundException, EmailExistException, IOException;

    void deleteUser(String email) throws IOException;


    UserEntity findByID(Long id) throws UserDatabaseException;

//    UserEntity update(Long id) throws UserDatabaseException;

    void deleteById(Long id) throws UserDatabaseException;

    String getTypeOfServiceByProvider(String providerEmail);
}
