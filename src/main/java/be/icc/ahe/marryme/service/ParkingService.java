package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ParkingDatabaseException;
import be.icc.ahe.marryme.model.Parking;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

@Service
public interface ParkingService {
    Parking save(Parking parking) throws ParkingDatabaseException;
    Parking findByID(Long id) throws ParkingDatabaseException;
    Parking update(Parking parking) throws ParkingDatabaseException;
    void deleteById(Long id) throws ParkingDatabaseException;}
