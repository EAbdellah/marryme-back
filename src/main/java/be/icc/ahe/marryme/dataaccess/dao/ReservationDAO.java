package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationDAO {
    private final ReservationRepo reservationRepo;

    @Autowired
    public ReservationDAO(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public ReservationEntity save(ReservationEntity reservationEntity){

        return reservationRepo.save(reservationEntity);
    }
}
