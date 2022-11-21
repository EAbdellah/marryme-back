package be.icc.ahe.marryme.controller;

import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.event.OnProviderRegistration;
import be.icc.ahe.marryme.event.OnRegistrationCompleteEvent;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.FormuleDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.SocieteDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.UserDatabaseException;
import be.icc.ahe.marryme.model.*;
import be.icc.ahe.marryme.model.dto.*;
import be.icc.ahe.marryme.model.mapper.*;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.service.*;
import lombok.SneakyThrows;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import static be.icc.ahe.marryme.constant.ReservationStatus.*;

import javax.mail.MessagingException;
import java.sql.Date;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    private final UserService userService;
    private final SocieteService societeService;
    private final AddressService addressService;
    private final PersonService personService;
    private final FormuleService formuleService;
    private final ReservationService reservationService;
    private final FermetureService fermetureService;
    private final SalleService salleService;
    private final MediaService mediaService;
    private final MusiqueService musiqueService;
    private final MakeUpAndHairService makeUpAndHairService;
    private final TraiteurService traiteurService;
    private final ServiceTraiteurService serviceTraiteurService;
    private EmailService emailService;


    private ApplicationEventPublisher eventPublisher;


    @Autowired
    public ProviderController(FormuleService formuleService, FermetureService fermetureService,
                              ReservationService reservationService, UserService userService,
                              ApplicationEventPublisher eventPublisher, SocieteService societeService,
                              AddressService addressService, PersonService personService,
                              SalleService salleService, MediaService mediaService, MusiqueService musiqueService,
                              MakeUpAndHairService makeUpAndHairService, TraiteurService traiteurService,
                              ServiceTraiteurService serviceTraiteurService,EmailService emailService
    ) {
        this.userService = userService;
        this.societeService = societeService;
        this.addressService = addressService;
        this.personService = personService;
        this.eventPublisher = eventPublisher;
        this.formuleService = formuleService;
        this.reservationService = reservationService;
        this.fermetureService = fermetureService;
        this.salleService = salleService;
        this.mediaService = mediaService;
        this.musiqueService = musiqueService;
        this.makeUpAndHairService = makeUpAndHairService;
        this.traiteurService = traiteurService;
        this.serviceTraiteurService = serviceTraiteurService;
        this.emailService = emailService;

    }

    @PostMapping(value = "/register")
    public ResponseEntity<ProviderRegisterFormDTO> register(@RequestBody ProviderRegisterFormDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException {

        System.out.println(providerForm);
        Societe societe = societeService.Register(providerForm);
        eventPublisher.publishEvent(new OnProviderRegistration(societe, request.getLocale()));
        return ResponseEntity.ok(providerForm);
    }

    @GetMapping(value = "/getProviderOwnFormules")
    public ResponseEntity<List<GetShortFormuleDTO>> getInfoFormulesProvider(WebRequest request) {
        String email = request.getUserPrincipal().getName();
        List<GetShortFormuleDTO> list = formuleService.getAllFormuleByProvider(email);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/getProviderOwnReservation")
    public ResponseEntity<List<GetShortReservationDTO>> getInfoReservationProvider(WebRequest request) {
        String emailProvider = request.getUserPrincipal().getName();

        List<GetShortReservationDTO> list = reservationService.getAllReservationByProvider(emailProvider);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/getProviderOwnFermeture")
    public ResponseEntity<List<GetShortFermetureDTO>> getInfoFermeture(WebRequest request) {
        String emailProvider = request.getUserPrincipal().getName();
        List<GetShortFermetureDTO> list = fermetureService.getAllFermetureByProvider(emailProvider);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/getProviderOwnSalleInfo")
    public ResponseEntity<GetShortSalleServiceDTO> getOwnSalleInfo(WebRequest request) {
        String emailProvider = request.getUserPrincipal().getName();
        GetShortSalleServiceDTO salle = salleService.getSalleByProvider(emailProvider);
        return ResponseEntity.ok(salle);
    }

    @GetMapping(value = "/getProviderOwnMediaInfo")
    public ResponseEntity<GetShortMediaServiceDTO> getOwnMediaInfo(WebRequest request) {
        String emailProvider = request.getUserPrincipal().getName();
        GetShortMediaServiceDTO media = mediaService.getMediaByProvider(emailProvider);
        return ResponseEntity.ok(media);
    }

    @GetMapping(value = "/getProviderOwnMusiqueInfo")
    public ResponseEntity<GetShortMusiqueServiceDTO> getOwnMusiqueInfo(WebRequest request) {
        String emailProvider = request.getUserPrincipal().getName();
        GetShortMusiqueServiceDTO musique = musiqueService.getMusiqueByProvider(emailProvider);
        return ResponseEntity.ok(musique);
    }

    @GetMapping(value = "/getProviderOwnSMakeUpHairInfo")
    public ResponseEntity<GetShortMakeUpAndAirServiceDTO> getOwnMakeUpHairInfo(WebRequest request) {
        String emailProvider = request.getUserPrincipal().getName();
        GetShortMakeUpAndAirServiceDTO muah = makeUpAndHairService.getMakeUpAndAirByProvider(emailProvider);
        return ResponseEntity.ok(muah);
    }

    @GetMapping(value = "/getProviderOwnTraiteurInfo")
    public ResponseEntity<GetShortTraiteurServiceDTO> getOwnTraiteurInfo(WebRequest request) {
        String emailProvider = request.getUserPrincipal().getName();
        GetShortTraiteurServiceDTO traiteur = traiteurService.getTraiteurByProvider(emailProvider);
        return ResponseEntity.ok(traiteur);
    }

    @GetMapping(value = "/getProviderOwnServiceTraiteurInfo")
    public ResponseEntity<GetShortServiceTraiteurServiceDTO> getOwnServiceTraiteurInfo(WebRequest request) {
        String emailProvider = request.getUserPrincipal().getName();
        GetShortServiceTraiteurServiceDTO straiteur = serviceTraiteurService.getServiceTraiteurByProvider(emailProvider);
        return ResponseEntity.ok(straiteur);
    }

    @PostMapping(value = "/deleteFormule")
    public ResponseEntity<GetShortFormuleDTO> deleteFormule(@RequestBody GetShortFormuleDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException {

        Formule formule = formuleService.findByID(providerForm.getFormule_id());

        /**
         * Ce Serais nice si on recupere tout les wainting et on les met a not accepted puis on coupe la formule de la reservation et on la delete
         * DEBUT de logic
         *         List<Reservation> reservationsWaiting = formule.getReservation().stream().filter(x-> !x.getStatus().equals(STATUS_WAITING)).collect(Collectors.toList());
         *
         *         if (!formule.getReservation().isEmpty() || reservationsWaiting.isEmpty()){
         * */

        Optional<Reservation> reservation = formule.getReservation().stream().filter(x -> !x.getStatus().equals(STATUS_WAITING) && !x.getStatus().equals(STATUS_NOT_ACCEPTED)).findFirst();

        if (!formule.getReservation().isEmpty() || reservation.isPresent()) {
            formule.setActive(false);
            formuleService.save(formule);
        } else {

            formuleService.deleteById(providerForm.getFormule_id());
        }

        return ResponseEntity.ok(providerForm);
    }

    @PostMapping(value = "/updateFormule")
    public ResponseEntity<GetShortFormuleDTO> updateFormule(@RequestBody GetShortFormuleDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException {


        Societe societe = societeService.findUserByEmail(request.getUserPrincipal().getName());
        Formule formuletoPersist = FormuleMapper.INSTANCE.dtoToModel(providerForm);

        if (providerForm.getFormule_id() == null) {

            List<Formule> formules = societe.getService().getFormules();
            formuletoPersist.setActive(true);
            formules.add(formuletoPersist);
            societe.getService().setFormules(formules);
            societeService.save(societe);

        } else {
            Formule formule = formuleService.findByID(providerForm.getFormule_id());
            Optional<Reservation> reservation = formule.getReservation().stream().filter(x -> !x.getStatus().equals(STATUS_WAITING) && !x.getStatus().equals(STATUS_NOT_ACCEPTED)).findFirst();


            if (reservation.isPresent()) {
                formule.setActive(false);
                formuleService.save(formule);
                formuletoPersist.setActive(true);
                formuletoPersist.setFormuleID(null);
                formuleService.save(formuletoPersist);
            } else {
                formuletoPersist.setActive(true);
                formuleService.save(formuletoPersist);

            }
        }

        return ResponseEntity.ok(providerForm);
    }


    @PostMapping(value = "/updateServiceSalle")
    public ResponseEntity<GetShortSalleServiceDTO> updateServiceSalle(@RequestBody GetShortSalleServiceDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException {

        Societe societe = societeService.findUserByEmail(request.getUserPrincipal().getName());
        societe.setService(SalleMapper.INSTANCE.dtoToModel(providerForm));
        societeService.save(societe);
        return ResponseEntity.ok(providerForm);
    }

    @PostMapping(value = "/updateServiceMusique")
    public ResponseEntity<GetShortMusiqueServiceDTO> updateServiceMusique(@RequestBody GetShortMusiqueServiceDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException {

        Societe societe = societeService.findUserByEmail(request.getUserPrincipal().getName());
        societe.setService(MusiqueMapper.INSTANCE.dtoToModel(providerForm));
        societeService.save(societe);
        return ResponseEntity.ok(providerForm);
    }

    @PostMapping(value = "/updateServiceMedia")
    public ResponseEntity<GetShortMediaServiceDTO> updateServiceMedia(@RequestBody GetShortMediaServiceDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException {

        Societe societe = societeService.findUserByEmail(request.getUserPrincipal().getName());
        societe.setService(MediaMapper.INSTANCE.dtoToModel(providerForm));
        societeService.save(societe);
        return ResponseEntity.ok(providerForm);

    }

    @PostMapping(value = "/updateServiceMakeUpHair")
    public ResponseEntity<GetShortMakeUpAndAirServiceDTO> updateServiceMakeUpHair(@RequestBody GetShortMakeUpAndAirServiceDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException {


        Societe societe = societeService.findUserByEmail(request.getUserPrincipal().getName());
        societe.setService(MakeUpAndHairMapper.INSTANCE.dtoToModel(providerForm));
        societeService.save(societe);
        return ResponseEntity.ok(providerForm);    }

    @PostMapping(value = "/updateServiceTraiteur")
    public ResponseEntity<GetShortTraiteurServiceDTO> updateServiceTraiteur(@RequestBody GetShortTraiteurServiceDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException {

        Societe societe = societeService.findUserByEmail(request.getUserPrincipal().getName());
        societe.setService(TraiteurMapper.INSTANCE.dtoToModel(providerForm));
        societeService.save(societe);

        return ResponseEntity.ok(providerForm);    }

    @PostMapping(value = "/updateServiceTraiteurService")
    public ResponseEntity<GetShortServiceTraiteurServiceDTO> updateServiceTraiteurService(@RequestBody GetShortServiceTraiteurServiceDTO providerForm, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException {

        Societe societe = societeService.findUserByEmail(request.getUserPrincipal().getName());
        societe.setService(ServiceTraiteurMapper.INSTANCE.dtoToModel(providerForm));
        societeService.save(societe);

        return ResponseEntity.ok(providerForm);
    }

    @SneakyThrows
    @PostMapping(value = "/decision")
    public ResponseEntity<DecisionRequestRegistrationUser> decision(@RequestBody DecisionRequestRegistrationUser drrp) throws MessagingException {

        ReservationEntity reservation = reservationService.findByTicket(drrp.getTicket());
        UserEntity user = reservation.getUser();
        if (user instanceof HibernateProxy) {
            user = (UserEntity) ((HibernateProxy) user).getHibernateLazyInitializer()
                    .getImplementation();
        }
        PersonEntity personEntity= personService.findPersonByUser(user);

        emailService.sendDecisionUserRegistration(
                drrp.isAccepted(),
                user.getEmail(),
                personEntity.getFirstName(),
                reservation.getFormule().getNom());

//        Societe societe= societeService.findUserByEmail(drrp.getEmail());
        if (drrp.isAccepted()){
            reservation.setStatus(STATUS_ACCEPTED);
        }else {
            reservation.setStatus(STATUS_NOT_ACCEPTED);
        }
//
        reservationService.update(ReservationMapper.INSTANCE.entityToModel(reservation,new CycleAvoidingMappingContext()));

        return new ResponseEntity<>(drrp, HttpStatus.OK);
    }

    @PostMapping(value = "/addFermeture")
    public ResponseEntity<String> addFermeture(@RequestBody String date, WebRequest request) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException, FormuleDatabaseException, ParseException {

        Societe societe = societeService.findUserByEmail(request.getUserPrincipal().getName());
        Fermeture f = new Fermeture();

//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date parsed = format.parse(date);

        java.util.Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date); // This throws a ParseException
//        java.sql.Date sql = new java.sql.Date(parsed.getTime());

// Rest everything stays pretty much the same
        java.sql.Date d1 = new java.sql.Date(d.getTime());


        f.setDate(d1);

        societe.getService().getFermetures().add(f);
        societeService.save(societe);

        return ResponseEntity.ok(date);
    }
}
