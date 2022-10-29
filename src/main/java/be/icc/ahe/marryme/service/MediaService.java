package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.MediaDatabaseException;
import be.icc.ahe.marryme.model.Media;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

@Service
public interface MediaService {
    Media save(Media media) throws MediaDatabaseException;
    Media findByID(Long id) throws MediaDatabaseException;
    Media update(Media media) throws MediaDatabaseException;
    void deleteById(Long id) throws MediaDatabaseException;

}
