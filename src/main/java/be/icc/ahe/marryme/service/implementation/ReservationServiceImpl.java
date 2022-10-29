package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ReservationDAO;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.PersonDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.mapper.PersonMapper;
import be.icc.ahe.marryme.model.mapper.ReservationMapper;
import be.icc.ahe.marryme.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

        private final ReservationDAO reservationDAO;

    @Autowired
    public ReservationServiceImpl(ReservationDAO reservationDAO) {
            this.reservationDAO = reservationDAO;
        }


    @Override
    public Reservation save(Reservation reservation) throws ReservationDatabaseException {

        Optional.ofNullable(reservation)
                .orElseThrow(() -> new ReservationDatabaseException("Can not save null reservation: " + reservation));

        ReservationEntity persistedReservationEntity = reservationDAO.save(ReservationMapper.INSTANCE.modelToEntity(reservation));

        Optional.ofNullable(persistedReservationEntity)
                .orElseThrow(() -> new ReservationDatabaseException("Persisted reservation is null: " + persistedReservationEntity));

        return ReservationMapper.INSTANCE.entityToModel(persistedReservationEntity);

    }

    @Override
    public Reservation findByID(Long id) throws ReservationDatabaseException {

        ReservationEntity reservationEntity= this.reservationDAO.findByID(id)
                .orElseThrow(() -> new ReservationDatabaseException("None reservation found at id:" + id));

        return ReservationMapper.INSTANCE.entityToModel(reservationEntity);

    }

    @Override
    public Reservation update(Reservation reservation) throws ReservationDatabaseException {

        Optional.ofNullable(reservation)
                .orElseThrow(() -> new ReservationDatabaseException("Can not persist null reservation: " + reservation));

        if (reservationDAO.existsById(reservation.getReservationID())) {
            throw new ReservationDatabaseException("Try to update into data base a reservation that does not exist: " + reservation);
        }

        ReservationEntity reservationEntity = reservationDAO.save(ReservationMapper.INSTANCE.modelToEntity(reservation));


        Optional.ofNullable(reservationEntity)
                .orElseThrow(() -> new ReservationDatabaseException("Persisted reservation is null: " + reservationEntity));

        return ReservationMapper.INSTANCE.entityToModel(reservationEntity);
    }

    @Override
    public void deleteById(Long id) throws ReservationDatabaseException {
        if (reservationDAO.existsById(id)) {
            reservationDAO.deleteById(id);
        } else {
            throw new ReservationDatabaseException("None reservation found at id: " + id);
        }
        if (reservationDAO.existsById(id)) {
            throw new ReservationDatabaseException("Failed to delete reservation into database at id: " + id);
        }
    }

}
