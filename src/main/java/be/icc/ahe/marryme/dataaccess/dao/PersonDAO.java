package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDAO {
    private final PersonRepo personRepo;

    @Autowired
    public PersonDAO(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public PersonEntity save(PersonEntity personEntity){

        return personRepo.save(personEntity);
    }
}
