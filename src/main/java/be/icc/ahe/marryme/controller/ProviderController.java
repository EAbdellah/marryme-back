package be.icc.ahe.marryme.controller;

import be.icc.ahe.marryme.dataaccess.dao.ServiceDAO;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.entity.VerificationTokenEntity;
import be.icc.ahe.marryme.dataaccess.repository.ServicesRepo;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.sqlexception.FormuleDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ServiceDatabaseException;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.AllServicesDTO;
import be.icc.ahe.marryme.model.dto.ReservationRequestDTO;
import be.icc.ahe.marryme.model.dto.SingleServiceViewDTO;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.service.ReservationService;
import be.icc.ahe.marryme.service.ServicesService;
import be.icc.ahe.marryme.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Objects;

import static be.icc.ahe.marryme.constant.SecurityConstant.TOKEN_PREFIX;
import static be.icc.ahe.marryme.constant.UserImplConstant.VERIFIACTION_TOKEN_EXPIRED;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@CrossOrigin(origins = "*", maxAge = 3600)
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

        System.out.println("je rentre");

        String email =  Objects.requireNonNull(request.getUserPrincipal()).getName();
        User user = userService.findUserByEmail(email);





//        String authorizationHeader = request.getHeader(AUTHORIZATION);
//        String token = authorizationHeader.substring(TOKEN_PREFIX.length());
//        String username = jwtTokenProvider.getSubject(token);
//
//        System.out.println(username);

        reservationService.saveReservationRequest(rrdto,user);

        return new ResponseEntity<>(rrdto, HttpStatus.OK);
    }


}
