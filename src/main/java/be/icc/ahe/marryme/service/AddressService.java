package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.exception.AddressDatabaseException;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    void save(AddressEntity addressEntity) throws AddressDatabaseException;

}
