package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.MusiqueDatabaseException;
import be.icc.ahe.marryme.model.Musique;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

@Service
public interface MusiqueService {
    Musique save(Musique musique) throws MusiqueDatabaseException;
    Musique findByID(Long id) throws MusiqueDatabaseException;
    Musique update(Musique musique) throws MusiqueDatabaseException;
    void deleteById(Long id) throws MusiqueDatabaseException;
}
