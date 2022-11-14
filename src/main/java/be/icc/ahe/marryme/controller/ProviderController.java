package be.icc.ahe.marryme.controller;

import be.icc.ahe.marryme.dataaccess.dao.ServiceDAO;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.sqlexception.FormuleDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ServiceDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.UserDatabaseException;
import be.icc.ahe.marryme.model.dto.*;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.service.ReservationService;
import be.icc.ahe.marryme.service.ServicesService;
import be.icc.ahe.marryme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    private final ServicesService servicesService ;
    private final ServiceDAO serviceDAO ;
    private final UserService userService;
    private final ReservationService reservationService;



    @Autowired
    public ProviderController(UserService userService,ServicesService servicesService,ServiceDAO serviceDAO, ReservationService reservationService ) {
        this.servicesService = servicesService;
        this.serviceDAO = serviceDAO;
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @GetMapping("/allServices")
    public ResponseEntity<AllServicesDTO> getAllProvider(){
        List<AllServicesDTO> list = serviceDAO.findAllServiceForListMenu();

//        List<ServiceEntity> services = (List<ServiceEntity>) servicesService.findAll();
//        for (ServiceEntity s: services) {
//            s.setAddress(null);
//            s.setFermetures(null);
//            s.setFormuleEntities(null);
//            s.setReservationEntities(null);
//
//        }
        return new ResponseEntity( list, HttpStatus.OK);
    }

    @GetMapping("/getService/{serviceId}") // TODO: patch mapping
    public ResponseEntity getService(@PathVariable Long serviceId) throws ServiceDatabaseException {
        ServiceEntity serviceEntity = servicesService.findByID(serviceId);
        SingleServiceViewDTO ssvdto = servicesService.mapServiceToSingleViewDTO(serviceEntity);
        return new ResponseEntity<>(ssvdto, HttpStatus.OK);
    }

    @PostMapping("/reservationRequest") // TODO: patch mapping
    public ResponseEntity reservationRequest(@RequestBody ReservationRequestDTO rrdto, WebRequest request) throws ServiceDatabaseException, EmailExistException, ReservationDatabaseException, FormuleDatabaseException {

        String email =  Objects.requireNonNull(request.getUserPrincipal()).getName();
        User user = userService.findUserByEmail(email);
        reservationService.saveReservationRequest(rrdto,user);

        return new ResponseEntity<>(rrdto, HttpStatus.OK);
    }

//    @GetMapping("/getAllReservation")
//    public ResponseEntity<List<Reservation>> getAllReservation(WebRequest request) throws UserDatabaseException, UserNotFoundException {
//        String email =  Objects.requireNonNull(request.getUserPrincipal()).getName();
//        User user = userService.findUserByEmail(email);
//        List<Reservation> reservations = reservationService.findReservationByUser(user);
//
//        reservations.forEach(System.out::println);
//
//        return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
//    }

    @GetMapping("/getAllReservation")
    public ResponseEntity<List<ReservationClientDTO>> getAllReservation(WebRequest request) throws UserDatabaseException, UserNotFoundException {
        String email =  Objects.requireNonNull(request.getUserPrincipal()).getName();
        User user = userService.findUserByEmail(email);
        List<ReservationClientDTO> reservations = reservationService.findReservationsByUser(user);

        reservations.forEach(System.out::println);

        return new ResponseEntity<List<ReservationClientDTO>>(reservations, HttpStatus.OK);
    }

    @PostMapping("/confimationPaid") // TODO: patch mapping
    public ResponseEntity confimationPaid(@RequestBody ReservationPaidDTO rpDTO, WebRequest request) throws Exception {

        String email =  Objects.requireNonNull(request.getUserPrincipal()).getName();
        User user = userService.findUserByEmail(email);
        System.out.println(rpDTO);
        reservationService.confimationPaid(rpDTO);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(URI.create("http://localhost:4200/marryme/reservations"));

        return  new ResponseEntity<>(Status.payed, HttpStatus.OK);
    }





}
