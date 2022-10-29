package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ImageDatabaseException;
import be.icc.ahe.marryme.model.Image;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

@Service
public interface ImageService {
    Image save(Image image) throws ImageDatabaseException;
    Image findByID(Long id) throws ImageDatabaseException;
    Image update(Image image) throws ImageDatabaseException;
    void deleteById(Long id) throws ImageDatabaseException;}
