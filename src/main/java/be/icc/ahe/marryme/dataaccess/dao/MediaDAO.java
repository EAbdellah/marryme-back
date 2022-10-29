package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.dataaccess.repository.MediaRepo;
import be.icc.ahe.marryme.exception.sqlexception.MediaDatabaseException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class MediaDAO {
    private final MediaRepo mediaRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public MediaDAO(MediaRepo mediaRepo) {
        this.mediaRepo = mediaRepo;
    }


    public MediaEntity save(MediaEntity mediaEntity){
    return mediaRepo.save(mediaEntity);
}

    public Optional<MediaEntity> findByID(Long id){
        return mediaRepo.findById(id);
    }



    public void deleteById(Long id) {
            mediaRepo.deleteById(id);

    }
    public boolean existsById(Long id){
        return mediaRepo.existsById(id);
    }


}
