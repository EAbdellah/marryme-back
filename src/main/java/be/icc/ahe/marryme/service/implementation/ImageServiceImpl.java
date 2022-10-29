package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ImageDAO;
import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.FormuleDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ImageDatabaseException;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Image;
import be.icc.ahe.marryme.model.mapper.FormuleMapper;
import be.icc.ahe.marryme.model.mapper.ImageMapper;
import be.icc.ahe.marryme.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageDAO imageDAO;

    @Autowired
    public ImageServiceImpl(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }



    @Override
    public Image save(Image image) throws ImageDatabaseException {

        Optional.ofNullable(image)
                .orElseThrow(() -> new ImageDatabaseException("Can not persist null image: " + image));

        ImageEntity persistedImageEntity = imageDAO.save(ImageMapper.INSTANCE.modelToEntity(image));

        Optional.ofNullable(persistedImageEntity)
                .orElseThrow(() -> new ImageDatabaseException("Persisted image is null: " + persistedImageEntity));

        return ImageMapper.INSTANCE.entityToModel(persistedImageEntity);

    }


    @Override
    public Image findByID(Long id) throws ImageDatabaseException {

        ImageEntity imageEntity = this.imageDAO.findByID(id)
                .orElseThrow(() -> new ImageDatabaseException("None image found at id:" + id));

        return  ImageMapper.INSTANCE.entityToModel(imageEntity);

    }

    @Override
    public Image update(Image image) throws ImageDatabaseException {

        Optional.ofNullable(image)
                .orElseThrow(() -> new ImageDatabaseException("Can not persist null image: " + image));

        if (imageDAO.existsById(image.getImageID())){
            throw new ImageDatabaseException("Try to update into data base a image that does not exist: " + image);
        }

        ImageEntity persistedImageEntity  = imageDAO.save(ImageMapper.INSTANCE.modelToEntity(image));


        Optional.ofNullable(persistedImageEntity)
                .orElseThrow(() -> new ImageDatabaseException("Persisted image is null: " + persistedImageEntity));

        return ImageMapper.INSTANCE.entityToModel(persistedImageEntity);
    }

    @Override
    public void deleteById(Long id) throws ImageDatabaseException {
        if (imageDAO.existsById(id)) {
            imageDAO.deleteById(id);
        } else {
            throw new ImageDatabaseException("None image found at id: " + id);
        }
        if (imageDAO.existsById(id)){
            throw new ImageDatabaseException("Failed to delete image into database at id: " + id);
        }
    }


}
