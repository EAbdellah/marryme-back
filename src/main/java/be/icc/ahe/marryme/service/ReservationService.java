package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.sqlexception.FormuleDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.UserDatabaseException;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.dto.ReservationClientDTO;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.ReservationRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    Reservation save(Reservation reservation) throws ReservationDatabaseException;
    Reservation findByID(Long id) throws ReservationDatabaseException;
    Reservation update(Reservation reservation) throws ReservationDatabaseException;
    void deleteById(Long id) throws ReservationDatabaseException;
    Reservation saveReservationRequest(ReservationRequestDTO rrdto, User user) throws FormuleDatabaseException, ReservationDatabaseException;
    List<Reservation> findReservationByUser(User user) throws UserNotFoundException, UserDatabaseException;
    List<ReservationClientDTO> findReservationsByUser(User user) throws UserNotFoundException, UserDatabaseException;
    boolean isTicketExist(String ticket);
}
