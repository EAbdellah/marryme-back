package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    private final UserRepo userRepo;

    @Autowired
    public UserDAO(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity save(UserEntity userEntity){

        return userRepo.save(userEntity);
    }
}
