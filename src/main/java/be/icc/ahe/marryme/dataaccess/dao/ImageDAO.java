package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.repository.ImageRepo;
import be.icc.ahe.marryme.exception.sqlexception.ImageDatabaseException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class ImageDAO {
    private final ImageRepo imageRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public ImageDAO(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public ImageEntity save(ImageEntity imageEntity){
        return imageRepo.save(imageEntity);
    }

    public Optional<ImageEntity> findByID(Long id){
        return imageRepo.findById(id);
    }



    public void deleteById(Long id)  {
            imageRepo.deleteById(id);
    }
    public boolean existsById(Long id){
        return imageRepo.existsById(id);
    }


}
