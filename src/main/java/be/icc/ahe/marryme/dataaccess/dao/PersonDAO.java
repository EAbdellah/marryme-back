package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.repository.PersonRepo;
import be.icc.ahe.marryme.exception.sqlexception.PersonDatabaseException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class PersonDAO {
    private final PersonRepo personRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public PersonDAO(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public PersonEntity save(PersonEntity personEntity){
        return personRepo.save(personEntity);
    }

    public Optional<PersonEntity> findById(Long id){
        return personRepo.findById(id);
    }

    public PersonEntity findPersonByUser(UserEntity userEntity){
        return personRepo.findPersonByUserEntity(userEntity);
    }


    public void deleteById(Long id) {
            personRepo.deleteById(id);

    }

    public boolean existsById(Long id){
        return personRepo.existsById(id);
    }



}
