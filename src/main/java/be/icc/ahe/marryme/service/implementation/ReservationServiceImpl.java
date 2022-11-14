package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ReservationDAO;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.sqlexception.*;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.dto.ReservationClientDTO;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.ReservationPaidDTO;
import be.icc.ahe.marryme.model.dto.ReservationRequestDTO;
import be.icc.ahe.marryme.model.mapper.ReservationMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.model.mapper.dtomapper.ReservationRequestMapper;
import be.icc.ahe.marryme.service.ReservationService;
import be.icc.ahe.marryme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        private final ReservationDAO reservationDAO;
        private final FormuleServiceImpl formuleService;
    private final UserService userService;


    @Autowired
    public ReservationServiceImpl(ReservationDAO reservationDAO,FormuleServiceImpl formuleService,UserService userService ) {
        this.formuleService = formuleService;
        this.userService = userService;
        this.reservationDAO = reservationDAO;

        }


    @Override
    public Reservation save(Reservation reservation) throws ReservationDatabaseException {

        Optional.ofNullable(reservation)
                .orElseThrow(() -> new ReservationDatabaseException("Can not save null reservation: " + reservation));



        ReservationEntity persistedReservationEntity = reservationDAO.save(ReservationMapper.INSTANCE.modelToEntity(reservation,new CycleAvoidingMappingContext()));


        Optional.ofNullable(persistedReservationEntity)
                .orElseThrow(() -> new ReservationDatabaseException("Persisted reservation is null: " + persistedReservationEntity));

        return ReservationMapper.INSTANCE.entityToModel(persistedReservationEntity,new CycleAvoidingMappingContext());

    }

    @Override
    public Reservation findByID(Long id) throws ReservationDatabaseException {

        ReservationEntity reservationEntity= this.reservationDAO.findByID(id)
                .orElseThrow(() -> new ReservationDatabaseException("None reservation found at id:" + id));

        return ReservationMapper.INSTANCE.entityToModel(reservationEntity,new CycleAvoidingMappingContext());

    }

    @Override
    public Reservation update(Reservation reservation) throws ReservationDatabaseException {

        Optional.ofNullable(reservation)
                .orElseThrow(() -> new ReservationDatabaseException("Can not persist null reservation: " + reservation));

        if (!reservationDAO.existsById(reservation.getReservationID())) {
            throw new ReservationDatabaseException("Try to update into data base a reservation that does not exist: " + reservation);
        }

        ReservationEntity reservationEntity = reservationDAO.save(ReservationMapper.INSTANCE.modelToEntity(reservation,new CycleAvoidingMappingContext()));


        Optional.ofNullable(reservationEntity)
                .orElseThrow(() -> new ReservationDatabaseException("Persisted reservation is null: " + reservationEntity));

        return ReservationMapper.INSTANCE.entityToModel(reservationEntity,new CycleAvoidingMappingContext());
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

    @Override
    public Reservation saveReservationRequest(ReservationRequestDTO rrdto, User user) throws  ReservationDatabaseException {

        /**
         *  TODO: 06/11/2022 Faire un controle
         * */

        Reservation reservation = ReservationRequestMapper.INSTANCE.dtotomodel(rrdto,new CycleAvoidingMappingContext());
        reservation.setInceptionDate( new java.sql.Date(java.util.Date.from(Instant.now()).getTime()));
//        reservation.setTicket( UUID.randomUUID().toString());

        String ticket = "";
        do {
           ticket=  generateString(11);
        }while (isTicketExist(ticket));

        reservation.setTicket( ticket);
        reservation.setStatus("Waiting");

        try{
            Formule f = formuleService.findByID(Long.valueOf(rrdto.getFormuleId()));
            reservation.setFormule(f);
        }catch (FormuleDatabaseException e){
            e.getMessage();
        }
        reservation.setUser(user);



        return this.save(reservation);

    }

    @Override
    public List<Reservation> findReservationByUser(User user) throws UserNotFoundException, UserDatabaseException {
        Optional.ofNullable(user)
                .orElseThrow(() -> new UserNotFoundException("user can be null: " + user));

        UserEntity userEntity = userService.findByID(user.getUserID());
        List<ReservationEntity> reservations =reservationDAO.findReservationByUser(userEntity);
        List<Reservation> reservationList = reservations.stream()
                                                        .map(x->ReservationMapper.INSTANCE.entityToModel(x,new CycleAvoidingMappingContext()))
                                                        .collect(Collectors.toList());
        return reservationList;
    }

    @Override
    public List<ReservationClientDTO> findReservationsByUser(User user) throws UserNotFoundException, UserDatabaseException {
        Optional.ofNullable(user)
                .orElseThrow(() -> new UserNotFoundException("user can be null: " + user));

        UserEntity userEntity = userService.findByID(user.getUserID());

        List<ReservationClientDTO> reservations =reservationDAO.getAllReservationsByUser(userEntity.getUserID());
//        List<Reservation> reservationList = reservations.stream()
//                .map(x->ReservationMapper.INSTANCE.entityToModel(x,new CycleAvoidingMappingContext()))
//                .collect(Collectors.toList());
        return reservations;
    }

    @Override
    public boolean isTicketExist(String ticket) {
        return reservationDAO.isTicketExist(ticket) > 0;
    }

    @Override
    public ReservationEntity findByTicket(String ticket) {
        return reservationDAO.findByTicket(ticket);
    }

    public void confimationPaid(ReservationPaidDTO reservationPaidDTO) throws Exception {
        if (reservationPaidDTO.getStatus().equalsIgnoreCase("COMPLETED")) {
            ReservationEntity reservation = findByTicket(reservationPaidDTO.getResTicket());
            reservation.setStatus("Payed");
            System.out.println(reservationPaidDTO.getPaymentId());
            reservation.setPayementId(reservationPaidDTO.getPaymentId());
            System.out.println(reservation);
            this.update(ReservationMapper.INSTANCE.entityToModel(reservation,new CycleAvoidingMappingContext()));

        }else {
            throw new Exception("Payment return wrong status: "+ reservationPaidDTO.getStatus());
        }
    }


    public String generateString(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return builder.toString();
    }




}
