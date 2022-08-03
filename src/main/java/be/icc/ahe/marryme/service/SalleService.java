package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.exception.SalleDatabaseException;

import java.util.Optional;

public interface SalleService  {
    void save(SalleEntity salleEntity) throws SalleDatabaseException;
    void deleteByID(Long id) throws SalleDatabaseException;
    Optional<SalleEntity> findByID(Long id) throws SalleDatabaseException;

}
