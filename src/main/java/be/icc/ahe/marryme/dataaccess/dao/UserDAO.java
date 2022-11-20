package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.repository.UserRepo;
import be.icc.ahe.marryme.exception.sqlexception.UserDatabaseException;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class UserDAO {
    private final UserRepo userRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public UserDAO(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity save(UserEntity userEntity){
        return userRepo.save(userEntity);
    }

    public UserEntity findUserByEmail(String email){
        return userRepo.findUserByEmail(email);
    }


    public Optional<UserEntity> findByID(Long id){
        return userRepo.findById(id);
    }

//    @SneakyThrows
//    public UserEntity update(Long id) throws UserDatabaseException {
//        UserEntity userEntity = userRepo.getById(id);
//        LOGGER.info(" Update userEntity :{}", userEntity);
//        return userEntity;
//    }

    public void deleteById(Long id) throws UserDatabaseException {
            userRepo.deleteById(id);
    }

    public boolean existsById(Long id){
        return userRepo.existsById(id);
    }

    public String getTypeOfServiceByProvider(String email){
        return userRepo.getTypeOfServiceByProvider(email);
    }

}
