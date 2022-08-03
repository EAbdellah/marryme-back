package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserEntity userEntity) throws Exception;

}
