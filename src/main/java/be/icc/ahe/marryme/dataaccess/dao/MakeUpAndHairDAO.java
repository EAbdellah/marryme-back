package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.dataaccess.repository.MakeUpAndHairRepo;
import be.icc.ahe.marryme.exception.sqlexception.MakeUpAndHairDatabaseException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class MakeUpAndHairDAO {
    private final MakeUpAndHairRepo makeUpAndHairRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public MakeUpAndHairDAO(MakeUpAndHairRepo makeUpAndHairRepo) {
        this.makeUpAndHairRepo = makeUpAndHairRepo;
    }


    public MakeUpAndHairEntity save(MakeUpAndHairEntity makeUpAndHairEntity){
        return makeUpAndHairRepo.save(makeUpAndHairEntity);
    }

    public Optional<MakeUpAndHairEntity> findByID(Long id){
        return makeUpAndHairRepo.findById(id);
    }


    public void deleteById(Long id)  {
            makeUpAndHairRepo.deleteById(id);

    }

    public boolean existsById(Long id){
        return makeUpAndHairRepo.existsById(id);
    }

}
