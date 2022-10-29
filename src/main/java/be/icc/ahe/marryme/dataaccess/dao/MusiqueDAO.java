package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.dataaccess.repository.MusiqueRepo;
import be.icc.ahe.marryme.exception.sqlexception.MusiqueDatabaseException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class MusiqueDAO {
    private final MusiqueRepo musiqueRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public MusiqueDAO(MusiqueRepo musiqueRepo) {
        this.musiqueRepo = musiqueRepo;
    }


    public MusiqueEntity save(MusiqueEntity musiqueEntity){
        return musiqueRepo.save(musiqueEntity);
    }

    public Optional<MusiqueEntity> findByID(Long id){
        return musiqueRepo.findById(id);
    }


    public void deleteById(Long id) {
            musiqueRepo.deleteById(id);
    }

    public boolean existsById(Long id){
        return musiqueRepo.existsById(id);
    }

}
