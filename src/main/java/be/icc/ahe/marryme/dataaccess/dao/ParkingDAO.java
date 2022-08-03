package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.dataaccess.repository.ParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingDAO {
    private final ParkingRepo parkingRepo;

    @Autowired
    public ParkingDAO(ParkingRepo parkingRepo) {
        this.parkingRepo = parkingRepo;
    }

    public ParkingEntity save(ParkingEntity parkingEntity){

        return parkingRepo.save(parkingEntity);
    }
    public void deleteByID(Long id){
        parkingRepo.deleteById(id);
    }


}
