package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.MakeUpAndHairDatabaseException;
import be.icc.ahe.marryme.model.MakeUpAndHair;
import be.icc.ahe.marryme.model.dto.GetShortMakeUpAndAirServiceDTO;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

@Service
public interface MakeUpAndHairService {
    MakeUpAndHair save(MakeUpAndHair makeUpAndHair) throws MakeUpAndHairDatabaseException;
    MakeUpAndHair findByID(Long id) throws MakeUpAndHairDatabaseException;
    MakeUpAndHair update(MakeUpAndHair makeUpAndHair) throws MakeUpAndHairDatabaseException;
    void deleteById(Long id) throws MakeUpAndHairDatabaseException;
     GetShortMakeUpAndAirServiceDTO getMakeUpAndAirByProvider(String email);

    }
