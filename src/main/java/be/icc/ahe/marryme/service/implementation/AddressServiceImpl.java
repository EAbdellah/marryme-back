package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.AddressDAO;
import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.repository.AddressRepo;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.mapper.AddressMapper;
import be.icc.ahe.marryme.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDAO addressDAO;

    @Autowired
    public AddressServiceImpl(AddressDAO addressDAO) {

        this.addressDAO = addressDAO;
    }

    @Override
    public Address save(Address address) throws AddressDatabaseException {

        Optional.ofNullable(address)
                .orElseThrow(() -> new AddressDatabaseException("Can not persist null address: " + address));

        AddressEntity persistedAddressEntity = addressDAO.save(AddressMapper.INSTANCE.modelToEntity(address));

        Optional.ofNullable(persistedAddressEntity)
                .orElseThrow(() -> new AddressDatabaseException("Persisted address is null: " + persistedAddressEntity));

        return AddressMapper.INSTANCE.entityToModel(persistedAddressEntity);

    }

    @Override
    public Address findByID(Long id) throws AddressDatabaseException {

        AddressEntity addressEntity = this.addressDAO.findByID(id)
                .orElseThrow(() -> new AddressDatabaseException("None address found at id:" + id));

        return  AddressMapper.INSTANCE.entityToModel(addressEntity);

    }

    @Override
    public Address update(Address address) throws AddressDatabaseException {

        Optional.ofNullable(address)
                .orElseThrow(() -> new AddressDatabaseException("Can not persist null address: " + address));

        if (addressDAO.existsById(address.getAdressID())){
            throw new AddressDatabaseException("Try to update into data base a address that does not exist: " + address);
        }

        AddressEntity persistedAddressEntity = addressDAO.save(AddressMapper.INSTANCE.modelToEntity(address));


        Optional.ofNullable(persistedAddressEntity)
                .orElseThrow(() -> new AddressDatabaseException("Persisted address is null: " + persistedAddressEntity));

        return AddressMapper.INSTANCE.entityToModel(persistedAddressEntity);
    }

    @Override
    public void deleteById(Long id) throws AddressDatabaseException {
        if (addressDAO.existsById(id)) {
            addressDAO.deleteById(id);
        } else {
            throw new AddressDatabaseException("None address found at id: " + id);
        }
        if (addressDAO.existsById(id)){
            throw new AddressDatabaseException("Failed to delete address into database at id: " + id);
        }
    }

}
