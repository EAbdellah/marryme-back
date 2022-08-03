package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.exception.FermetureDatabaseException;
import be.icc.ahe.marryme.exception.SalleDatabaseException;

public interface FermetureService {
    void save(FermetureEntity fermetureEntity) throws FermetureDatabaseException;
    void deleteByID(Long id) throws SalleDatabaseException;

}
