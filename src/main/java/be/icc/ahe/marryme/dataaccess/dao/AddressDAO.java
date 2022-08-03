package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressDAO {

    private final AddressRepo addressRepo;

    @Autowired
    public AddressDAO(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public AddressEntity save(AddressEntity addressEntity){

        return addressRepo.save(addressEntity);
    }

}
