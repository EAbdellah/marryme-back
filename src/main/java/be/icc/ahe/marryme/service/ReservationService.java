package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    void save(ReservationEntity reservationEntity) throws Exception;

}
