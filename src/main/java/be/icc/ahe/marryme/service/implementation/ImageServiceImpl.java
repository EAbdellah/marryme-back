package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ImageDAO;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageDAO imageDAO;

    @Autowired
    public ImageServiceImpl(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    @Override
    public void save(ImageEntity imageEntity) throws Exception {
        imageDAO.save(imageEntity);
    }

    @Override
    public void deleteByID(Long id) throws Exception {
        imageDAO.deleteById(id);
    }
}
