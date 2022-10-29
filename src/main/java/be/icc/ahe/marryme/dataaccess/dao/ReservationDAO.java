package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.repository.ReservationRepo;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class ReservationDAO {
    private final ReservationRepo reservationRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public ReservationDAO(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }


    public ReservationEntity save(ReservationEntity reservationEntity){
        return reservationRepo.save(reservationEntity);
    }

    public Optional<ReservationEntity> findByID(Long id){
        return reservationRepo.findById(id);
    }



    public void deleteById(Long id) throws ReservationDatabaseException {
            reservationRepo.deleteById(id);
    }
    public boolean existsById(Long id){
        return reservationRepo.existsById(id);
    }




}
