package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.repository.AddressRepo;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Objects;
import java.util.Optional;

@Component
public class AddressDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressDAO.class);


    private final AddressRepo addressRepo;

    @Autowired
    public AddressDAO(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public AddressEntity save(AddressEntity addressEntity){
        return addressRepo.save(addressEntity);
    }

    public Optional<AddressEntity> findByID(Long id){
        return addressRepo.findById(id);
    }

    public void deleteById(Long id) {
             addressRepo.deleteById(id);
    }

    public boolean existsById(Long id){
        return addressRepo.existsById(id);
    }




}
