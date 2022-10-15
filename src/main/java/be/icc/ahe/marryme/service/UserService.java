package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.entity.VerificationTokenEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserEntity userEntity) throws Exception;
    User validateNewEmail(String currentEmail, String newEmail) throws UserNotFoundException, EmailExistException;

    String encodePassword(String password);

    User findUserByEmail(String email);

    void createVerificationToken(User user, String token);

    VerificationTokenEntity getVerificationToken(String VerificationToken);

//    String getTemporaryProfileImageUrl(String username)
}
