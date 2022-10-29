package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.model.Fermeture;

import java.sql.SQLDataException;

public interface FermetureService {
    Fermeture save(Fermeture fermeture) throws FermetureDatabaseException;
    Fermeture findByID(Long id) throws FermetureDatabaseException;
    Fermeture update(Fermeture fermeture) throws FermetureDatabaseException;
    void deleteById(Long id) throws FermetureDatabaseException;
}
