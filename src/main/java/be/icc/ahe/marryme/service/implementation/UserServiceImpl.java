package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.UserDAO;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(UserEntity userEntity) throws Exception {
        userDAO.save(userEntity);

    }
}
