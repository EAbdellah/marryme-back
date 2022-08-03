package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {
    void save(ImageEntity imageEntity) throws Exception;
    void deleteByID(Long id) throws Exception;
}
