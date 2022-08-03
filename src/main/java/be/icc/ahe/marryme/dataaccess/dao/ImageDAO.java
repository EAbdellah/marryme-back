package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageDAO {
    private final ImageRepo imageRepo;

    @Autowired
    public ImageDAO(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public ImageEntity save(ImageEntity imageEntity){

        return imageRepo.save(imageEntity);
    }

    public void deleteById (Long id){
        imageRepo.deleteById(id);
    }
}
