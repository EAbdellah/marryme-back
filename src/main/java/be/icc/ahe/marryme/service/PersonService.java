package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    void save(PersonEntity personEntity) throws Exception;
//    void deleteByID(Long id) throws Exception;

}

