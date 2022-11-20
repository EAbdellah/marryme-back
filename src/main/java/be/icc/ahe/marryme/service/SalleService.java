package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.SalleDatabaseException;
import be.icc.ahe.marryme.model.Salle;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.Optional;

@Service
public interface SalleService  {
    Salle save(Salle salle) throws SalleDatabaseException;
    Salle findByID(Long id) throws SalleDatabaseException;
    Salle update(Salle salle) throws SalleDatabaseException;
    void deleteById(Long id) throws SalleDatabaseException;
    GetShortSalleServiceDTO getSalleByProvider(String providerEmail);

}
