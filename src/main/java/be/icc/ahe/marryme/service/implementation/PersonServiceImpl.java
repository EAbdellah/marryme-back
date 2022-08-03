package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.PersonDAO;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public void save(PersonEntity personEntity) throws Exception{
        personDAO.save(personEntity);

    }

//    @Override
//    public void deleteByID(Long id) throws Exception {
//        personDAO.
//    }
}
