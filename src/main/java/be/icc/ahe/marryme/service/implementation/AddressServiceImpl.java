package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.AddressDAO;
import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.exception.AddressDatabaseException;
import be.icc.ahe.marryme.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDAO addressDAO;

    @Autowired
    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public void save(AddressEntity addressEntity) throws AddressDatabaseException {
        addressDAO.save(addressEntity);
    }
}
