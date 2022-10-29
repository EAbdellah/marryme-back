package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.SocieteDatabaseException;
import be.icc.ahe.marryme.model.Societe;
import org.springframework.stereotype.Service;

@Service
public interface SocieteService {
    Societe save(Societe societe) throws SocieteDatabaseException;
    Societe findByID(Long id) throws SocieteDatabaseException;
    Societe update(Societe societe) throws SocieteDatabaseException;
    void deleteById(Long id) throws SocieteDatabaseException;
}
