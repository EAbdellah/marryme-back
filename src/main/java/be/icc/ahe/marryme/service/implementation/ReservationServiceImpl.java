package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ReservationDAO;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

        private final ReservationDAO reservationDAO;

    @Autowired
    public ReservationServiceImpl(ReservationDAO reservationDAO) {
            this.reservationDAO = reservationDAO;
        }

        @Override
        public void save(ReservationEntity reservationEntity) throws Exception {
            reservationDAO.save(reservationEntity);

        }
}
