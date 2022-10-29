package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.model.Reservation;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

@Service
public interface ReservationService {
    Reservation save(Reservation reservation) throws ReservationDatabaseException;
    Reservation findByID(Long id) throws ReservationDatabaseException;
    Reservation update(Reservation reservation) throws ReservationDatabaseException;
    void deleteById(Long id) throws ReservationDatabaseException;
}
