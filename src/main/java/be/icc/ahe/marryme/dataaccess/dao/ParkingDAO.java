package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.dataaccess.repository.ParkingRepo;
import be.icc.ahe.marryme.exception.sqlexception.ParkingDatabaseException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class ParkingDAO {
    private final ParkingRepo parkingRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public ParkingDAO(ParkingRepo parkingRepo) {
        this.parkingRepo = parkingRepo;
    }


    public ParkingEntity save(ParkingEntity parkingEntity){
        return parkingRepo.save(parkingEntity);
    }

    public Optional<ParkingEntity> findByID(Long id){
        return parkingRepo.findById(id);
    }



    public void deleteById(Long id) {
            parkingRepo.deleteById(id);

    }
    public boolean existsById(Long id){
        return parkingRepo.existsById(id);
    }



}
