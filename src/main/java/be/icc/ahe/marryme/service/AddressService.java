package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.model.Address;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

@Service
public interface AddressService {

    Address save(Address address) throws AddressDatabaseException;

    Address findByID(Long id) throws AddressDatabaseException;

    Address update(Address address) throws AddressDatabaseException;

     void deleteById(Long id) throws AddressDatabaseException;

}
