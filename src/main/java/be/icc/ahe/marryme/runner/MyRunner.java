package be.icc.ahe.marryme.runner;


import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.HallType;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.model.*;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.ReservationRequestDTO;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import be.icc.ahe.marryme.model.mapper.PersonMapper;
import be.icc.ahe.marryme.model.mapper.SocieteMapper;
import be.icc.ahe.marryme.model.mapper.UserMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.model.mapper.dtomapper.RegistrationUserMapper;
import be.icc.ahe.marryme.service.*;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.io.File;
import java.sql.Date;
import java.text.Normalizer;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static be.icc.ahe.marryme.constant.ReservationStatus.*;

import static be.icc.ahe.marryme.dataaccess.entity.enumeration.Role.*;

//
@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MyRunner.class);

    private final AddressService addressService;
    private final SalleService salleService;
    private final SocieteService societeService;
    private final FermetureService fermetureService;
    private final ParkingService parkingService;
    private final PersonService personService;
    private final FormuleService formuleService;
    private final ImageService imageService;
    private final UserService userService;
    private final MusiqueService musiqueService;
    private final MediaService mediaService;
    private final MakeUpAndHairService makeUpAndHairService;
    private final ServiceTraiteurService serviceTraiteurService;
    private final TraiteurService traiteurService;
    private final ReservationService reservationService;
    private final ServicesService servicesService;
    private final Environment environment;


    @Autowired
    public MyRunner(AddressService addressService, SalleService salleService,
                    SocieteService societeService, FermetureService fermetureService,
                    ParkingService parkingService, PersonService personService,
                    FormuleService formuleService, ImageService imageService,
                    UserService userService, MusiqueService musiqueService,
                    MediaService mediaService, MakeUpAndHairService makeUpAndHairService,
                    ServiceTraiteurService serviceTraiteurService, TraiteurService traiteurService,
                    ReservationService reservationService, ServicesService servicesService, Environment environment
    ) {
        this.servicesService = servicesService;
        this.parkingService = parkingService;
        this.fermetureService = fermetureService;
        this.addressService = addressService;
        this.salleService = salleService;
        this.societeService = societeService;
        this.personService = personService;
        this.formuleService = formuleService;
        this.imageService = imageService;
        this.userService = userService;
        this.mediaService = mediaService;
        this.musiqueService = musiqueService;
        this.makeUpAndHairService = makeUpAndHairService;
        this.serviceTraiteurService = serviceTraiteurService;
        this.traiteurService = traiteurService;
        this.reservationService = reservationService;
        this.environment = environment;

    }

    //
//    @Override
    public void run(String... args) throws Exception {
//
//
//
        Faker faker = new Faker((new Locale("fr_BE")));





        /**
        *ADMIN CREATION
        * */
        User admin = new User();
        admin.setEmail(environment.getProperty("administationName"));
        admin.setPassword(userService.encodePassword(environment.getProperty("administationPass")));
        admin.setActive(true);
        admin.setNotLocked(true);
        admin.setRole(ROLE_ADMIN);
        admin.setAuthorities(ROLE_ADMIN.getAuthorities());
        userService.save(UserMapper.INSTANCE.modelToEntity(admin, new CycleAvoidingMappingContext()));

        /**
        * User CREATION
         **/


        User User = new User();
        admin.setEmail("user");
        admin.setPassword(userService.encodePassword("user"));
        admin.setActive(true);
        admin.setNotLocked(true);
        admin.setRole(ROLE_USER);
        admin.setAuthorities(ROLE_PRESTATAIRE_ADMIN.getAuthorities());
        userService.save(UserMapper.INSTANCE.modelToEntity(admin, new CycleAvoidingMappingContext()));




        /**
        *Salle CREATION
        **/


        User ProviderSalle = new User();
        ProviderSalle.setEmail("provider-salle");
        ProviderSalle.setPassword(userService.encodePassword("provider-salle"));
        ProviderSalle.setActive(true);
        ProviderSalle.setNotLocked(true);
        ProviderSalle.setRole(ROLE_PRESTATAIRE_ADMIN);
        ProviderSalle.setAuthorities(ROLE_PRESTATAIRE_ADMIN.getAuthorities());


        Address addressSocieteSalle = createAddress(faker);
        Address addressSalle = createAddress(faker);


        Person personSalle = createPerson(faker);
        personSalle.setLocalisation(addressSocieteSalle);
        personSalle.setUser(ProviderSalle);

        Societe societeSalle = createSociete(faker);

        societeSalle.setLocalisation(createAddress(faker));
        societeSalle.setOwner(personSalle);
        societeSalle.setEmail(ProviderSalle.getEmail());
        addressSalle = addressService.save(addressSalle);
        Salle salle = createSalle(faker);
        Parking parking = createParking(faker);
        salle.setParking(parking);
        salle.setAddress(addressSalle);
        salle.setFormules(Arrays.asList(createFormule(faker), createFormule(faker), createFormule(faker)));
        salle.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));

        societeSalle.setService(salle);
        societeService.save(societeSalle);




        /**
        * Musique CREATION
         **/


        User ProviderMusique = new User();
        ProviderMusique.setEmail("provider-musique");
        ProviderMusique.setPassword(userService.encodePassword("provider-musique"));
        ProviderMusique.setActive(true);
        ProviderMusique.setNotLocked(true);
        ProviderMusique.setRole(ROLE_PRESTATAIRE_ADMIN);
        ProviderMusique.setAuthorities(ROLE_PRESTATAIRE_ADMIN.getAuthorities());
//        userService.save(UserMapper.INSTANCE.modelToEntity(ProviderMusique, new CycleAvoidingMappingContext()));


        Address addressSocieteMusique = createAddress(faker);
        Address addressMusique = createAddress(faker);


        Person personMusique = createPerson(faker);
        personMusique.setLocalisation(addressSocieteMusique);
        personMusique.setUser(ProviderMusique);

        Societe societeMusique = createSociete(faker);

        societeMusique.setLocalisation(createAddress(faker));
        societeMusique.setOwner(personMusique);
        societeMusique.setEmail(ProviderMusique.getEmail());

        addressMusique = addressService.save(addressMusique);
        Musique musique = createMusique(faker);
        musique.setAddress(addressMusique);
        musique.setFormules(Arrays.asList(createFormule(faker), createFormule(faker), createFormule(faker)));
        musique.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));

        societeMusique.setService(musique);
        societeService.save(societeMusique);

        /**
        * Media CREATION
         **/

        User ProviderMedia = new User();
        ProviderMedia.setEmail("provider-media");
        ProviderMedia.setPassword(userService.encodePassword("provider-media"));
        ProviderMedia.setActive(true);
        ProviderMedia.setNotLocked(true);
        ProviderMedia.setRole(ROLE_PRESTATAIRE_ADMIN);
        ProviderMedia.setAuthorities(ROLE_PRESTATAIRE_ADMIN.getAuthorities());
//        userService.save(UserMapper.INSTANCE.modelToEntity(ProviderMedia, new CycleAvoidingMappingContext()));


        Address addressSocieteMedia = createAddress(faker);
        Address addressMedia = createAddress(faker);


        Person personMedia = createPerson(faker);
        personMedia.setLocalisation(addressSocieteMedia);
        personMedia.setUser(ProviderMedia);

        Societe societeMedia = createSociete(faker);

        societeMedia.setLocalisation(createAddress(faker));
        societeMedia.setOwner(personMedia);
        societeMedia.setEmail(ProviderMedia.getEmail());

        addressMedia = addressService.save(addressMedia);
        Media media = createMedia(faker);
        media.setAddress(addressMedia);
        media.setFormules(Arrays.asList(createFormule(faker), createFormule(faker), createFormule(faker)));
        media.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));


        societeMedia.setService(media);
        societeService.save(societeMedia);


        /**
        * Traiteur CREATION
         **/

        User ProviderTraiteur = new User();
        ProviderTraiteur.setEmail("provider-traiteur");
        ProviderTraiteur.setPassword(userService.encodePassword("provider-traiteur"));
        ProviderTraiteur.setActive(true);
        ProviderTraiteur.setNotLocked(true);
        ProviderTraiteur.setRole(ROLE_PRESTATAIRE_ADMIN);
        ProviderTraiteur.setAuthorities(ROLE_PRESTATAIRE_ADMIN.getAuthorities());
//        userService.save(UserMapper.INSTANCE.modelToEntity(ProviderTraiteur, new CycleAvoidingMappingContext()));


        Address addressSocieteTraiteur = createAddress(faker);
        Address addressTraiteur = createAddress(faker);


        Person personTraiteur = createPerson(faker);
        personTraiteur.setLocalisation(addressSocieteTraiteur);
        personTraiteur.setUser(ProviderTraiteur);

        Societe societeTraiteur = createSociete(faker);

        societeTraiteur.setLocalisation(createAddress(faker));
        societeTraiteur.setOwner(personTraiteur);
        societeTraiteur.setEmail(ProviderTraiteur.getEmail());

        addressTraiteur = addressService.save(addressTraiteur);
        Traiteur traiteur = createTraiteur(faker);
        traiteur.setAddress(addressTraiteur);
        traiteur.setFormules(Arrays.asList(createFormule(faker), createFormule(faker), createFormule(faker)));
        traiteur.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));

        societeTraiteur.setService(traiteur);
        societeService.save(societeTraiteur);
        /**
        * Service Traiteur CREATION
         **/

        User ProviderServiceTraiteur = new User();
        ProviderServiceTraiteur.setEmail("provider-service-traiteur");
        ProviderServiceTraiteur.setPassword(userService.encodePassword("provider-service-traiteur"));
        ProviderServiceTraiteur.setActive(true);
        ProviderServiceTraiteur.setNotLocked(true);
        ProviderServiceTraiteur.setRole(ROLE_PRESTATAIRE_ADMIN);
        ProviderServiceTraiteur.setAuthorities(ROLE_PRESTATAIRE_ADMIN.getAuthorities());
//        userService.save(UserMapper.INSTANCE.modelToEntity(ProviderServiceTraiteur, new CycleAvoidingMappingContext()));


        Address addressSocieteServiceTraiteur = createAddress(faker);
        Address addressServiceTraiteur = createAddress(faker);


        Person personServiceTraiteur = createPerson(faker);
        personServiceTraiteur.setLocalisation(addressSocieteServiceTraiteur);
        personServiceTraiteur.setUser(ProviderServiceTraiteur);

        Societe societeServiceTraiteur = createSociete(faker);

        societeServiceTraiteur.setLocalisation(createAddress(faker));
        societeServiceTraiteur.setOwner(personServiceTraiteur);
        societeServiceTraiteur.setEmail(ProviderServiceTraiteur.getEmail());

        addressServiceTraiteur= addressService.save(addressServiceTraiteur);
        ServiceTraiteur serviceTraiteur = createServiceTraiteur(faker);
        serviceTraiteur.setAddress(addressServiceTraiteur);
        serviceTraiteur.setFormules(Arrays.asList(createFormule(faker), createFormule(faker), createFormule(faker)));
        serviceTraiteur.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));

        societeServiceTraiteur.setService(serviceTraiteur);
        societeService.save(societeServiceTraiteur);

        /**
        * Make up CREATION
         **/


        User ProviderMakeUp = new User();
        ProviderMakeUp.setEmail("provider-make-up");
        ProviderMakeUp.setPassword(userService.encodePassword("provider-make-up"));
        ProviderMakeUp.setActive(true);
        ProviderMakeUp.setNotLocked(true);
        ProviderMakeUp.setRole(ROLE_PRESTATAIRE_ADMIN);
        ProviderMakeUp.setAuthorities(ROLE_PRESTATAIRE_ADMIN.getAuthorities());
//        userService.save(UserMapper.INSTANCE.modelToEntity(admin, new CycleAvoidingMappingContext()));

        Address addressSocieteMakeUp = createAddress(faker);
        Address addressMakeUp = createAddress(faker);


        Person personProviderMakeUp = createPerson(faker);
        personProviderMakeUp.setLocalisation(addressSocieteMakeUp);
        personProviderMakeUp.setUser(ProviderMakeUp);

        Societe societeMakeUp = createSociete(faker);
        societeMakeUp.setEmail(ProviderMakeUp.getEmail());

        societeMakeUp.setLocalisation(createAddress(faker));
        societeMakeUp.setOwner(personProviderMakeUp);
        addressMakeUp= addressService.save(addressMakeUp);
        MakeUpAndHair makeUpAndHair = createServiceMakeUpAndHair(faker);
        makeUpAndHair.setAddress(addressMakeUp);
        makeUpAndHair.setFormules(Arrays.asList(createFormule(faker), createFormule(faker), createFormule(faker)));
        makeUpAndHair.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));

        societeMakeUp.setService(makeUpAndHair);
        societeService.save(societeMakeUp);









//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

//
//
//        UserRegistrationFormDTO urf = new UserRegistrationFormDTO(
//                "Abdellah", "Elachhab", "Belgique", "Bruxelles", "1070", "Boulevard Prince de Liege",
//                "44", "4", "0484732465", "tamere@tamer.tame", "SalutLesBronzé", "par eamil"
//        );
//
//        Person person2 = RegistrationUserMapper.INSTANCE.dtotomodel(urf);
//
//        System.out.println(person2);
//
////        PersonEntity personEntity =  PersonMapper.INSTANCE.modelToEntity(person);
////        System.out.println(personEntity);
//
//        personService.save(person2);
//
//
//
//
//        /**
//         * CREATION UTILISATEUR
//         * */
////        Address address = createAddress(faker);
////        User user = createUser(faker,Role.ROLE_ADMIN);
////        Person person = createPerson(faker);
////
////        person.setUser(user);
////        person.setLocalisation(address);
////
////        UserEntity u = UserMapper.INSTANCE.modelToEntity(user);
////
////        personService.save(person);
////
//
//        /**
//         * CREATION SOCIETE Musique
//         * */
////
//        Address address = createAddress(faker);
//
//        User user = createUser(faker, Role.ROLE_ADMIN);
//
//        Person person = createPerson(faker);
//        person.setLocalisation(address);
//        person.setUser(user);
//
//        Societe societe = createSociete(faker);
//        societe.setLocalisation(createAddress(faker));
//        societe.setOwner(person);
//        societeService.save(societe);
//
//        /**
//         * CREATION SERVICE --> SAVE VIA SOCIETE
//         * */
//
//        Societe societe1 = societeService.findByID(1L);
//        LOG.info(societe1.toString());
//
//        Musique musique = createMusique(faker);
//        musique.setAddress(societe1.getLocalisation());
//        LOG.info(societe1.getLocalisation().toString());
//
//        LOG.info(musique.toString());
//        societe1.setService(musique);
//        societeService.save(societe1);
////
//
//
//        /**
//         * AJOUT FERMETURE --> SAVE VIA SERVICE
//         * */
//        Musique musique1 = musiqueService.findByID(1L);
//        musique1.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));
//        musiqueService.save(musique1);
//
//
//        /**
//         * SUPRESSION FERMETURE (MANY TO MANY)--> SAVE VIA SERVICE
//         * ETAPE :
//         *          1    RECUPERER LE SERVICE
//         *          2    RETOUVER CELUI QU'ON VEUT SUPPRIMER DE LA LISTE
//         *          2bis RECUPERER L'ID DE LA FERMETURE
//         *          2bis SUPPRIMER DE LA LISTE
//         *          3    FAIRE UN SAVE DU SERVICE AVEC LA LISTE MODIFIER
//         *          4    FAIRE UN DELETE DE LA FERMETURE CIBLER GRACE A L'ID
//         * */
//
////       Musique musique1 =  musiqueService.findByID(1L);
////        List<Fermeture> list= (List<Fermeture>) musique1.getFermetures();
////        list.forEach(System.out::println);
////        list.remove(1);
////        list.forEach(System.out::println);
////        musique1.setFermetures(list);
////        musiqueService.save(musique1);
////        fermetureService.deleteById(1L);
////        fermetureService.deleteById(2L);
//
//
//        System.out.println(servicesService.findByID(1L));
//
//
//        /**
//         * CREATION SOCIETE SALLE
//         * SA MERE LA P*** IL FAUT SAVE D'BORD LE SERVICE AVANT DE SAVE LA FORMULES
//         * */
//
//        Address addressSalle = createAddress(faker);
//
//        User userSalle = createUser(faker, Role.ROLE_ADMIN);
//
//        Person personSalle = createPerson(faker);
//        personSalle.setLocalisation(addressSalle);
//        personSalle.setUser(userSalle);
//
//        Societe societeSalle = createSociete(faker);
//        societeSalle.setLocalisation(createAddress(faker));
//        societeSalle.setOwner(personSalle);
//
//
//        Salle salle = createSalle(faker);
//        salle.setAddress(addressService.findByID(1L));
//
//
//        salle.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));
////        salleService.save(salle);
//
//
////        salle.setFormules(Arrays.asList( createFormule(faker), createFormule(faker), createFormule(faker)));
//
//        societeSalle.setService(salle);
//
//
//        salle.getFormules().forEach(System.out::println);
//
//        societeService.save(societeSalle);
//
//
//        Salle salle3 = createSalle(faker);
//        salle3.setAddress(addressService.findByID(1L));
//        salle3.setFermetures(Arrays.asList(createFermeture(faker), createFermeture(faker), createFermeture(faker)));
//
//        salle3.setReservations(Collections.singletonList(createreservation(faker)));
//        salle3.getFormules().forEach(System.out::println);
//
//        salleService.save(salle3);
//
//        Salle s4 = salleService.findByID(3L);
//        Formule formule = createFormule(faker);
//
//        formule.setImages(Arrays.asList(createImage(faker), createImage(faker), createImage(faker)));
////
//        s4.setFormules(Arrays.asList(formule, createFormule(faker), createFormule(faker)));
//        salleService.save(s4);
//
//        Formule f = formuleService.findByID(3L);
//        f.setImages(Arrays.asList(createImage(faker), createImage(faker), createImage(faker)));
//
//        formuleService.save(f);
////
////        Image image = createImage(faker);
////        image.setFormule(f);
////        imageService.save(image);
//
//        System.out.println(fermetureService.findByID(1L));
//
//        UserEntity user1 = userService.findByID(1L);
//
//        Reservation reservation = createreservation(faker);
//        reservation.setFormule(f);
//        User user5 = UserMapper.INSTANCE.entityToModel(user1, new CycleAvoidingMappingContext());
//        reservation.setUser(user5);
//
//        reservationService.save(reservation);
//
//        Reservation reservation1 = createreservation(faker);
//        reservation1.setFormule(f);
//        reservation1.setUser(user5);
//
//        reservationService.save(reservation1);
//
//
//        Reservation reservation2 = createreservation(faker);
//        reservation2.setFormule(f);
//        reservation2.setUser(user5);
//
//        reservationService.save(reservation2);
//
//
//        Reservation reservation3 = createreservation(faker);
//        reservation3.setFormule(f);
//        reservation3.setUser(UserMapper.INSTANCE.entityToModel(user1, new CycleAvoidingMappingContext()));
//
//        reservationService.save(reservation3);
//
////
////        ReservationRequestDTO rrdto = new ReservationRequestDTO();
////                rrdto.setFormuleId("3");
////        rrdto.setPrice(3000);
////        rrdto.setReservationDate(new java.sql.Date(java.util.Date.from(Instant.now()).getTime()) );
////
////        reservationService.saveReservationRequest(rrdto,UserMapper.INSTANCE.entityToModel(user1));
//
//
////        Societe s = societeService.findByID(1L);
//
////        Salle salle = createSalle(faker);
////        salle.setFormules((Arrays.asList(createFormule(faker))));
////
////        Address address1 = createAddress(faker);
//////        addressService.save(address1);
////        LOG.info(address1.toString());
////        salle.setAddress(address1);
////
////        salle.setParking(createParking(faker));
////        salle.setImage(createImage(faker));
////
////        LOG.info(salle.toString());
////
////        salleService.save(salle);
//
////        musiqueService.save(createMusique(faker));
//
//
////        societeService.save(societeService.findByID(1L).setService(createMusique(faker)));
//
//
////        addressService.save(address);
//
//
////        Faker faker = new Faker((new Locale("fr_BE")));
////
////        Address addressEntity = createAddress(faker);
////        Address addressEntity2 = createAddress(faker);
////
//////        addressService.save(addressEntity);
//////
////        UserEntity userEntity = createUser(faker, Role.ROLE_USER);
////        Person ps = createPerson(faker);
//////
////        Societe societeEntity = createSociete(faker);
////        societeEntity.setOwner(ps);
////        societeEntity.setLocalisation(addressEntity);
////        societeService.save(societeEntity);
//////
//////
////        Salle salleEntity = createSalle(faker);
////        salleEntity.setAdress(addressEntity2);
////        salleEntity.setSociete(societeEntity);
//////
//////
////        Formule formuleEntity = createFormule(faker);
////        System.out.println(formuleEntity);
////        Image image = createImage(faker);
////        formuleEntity.setImages(Arrays.asList(image));
////        salleEntity.setFormules(Arrays.asList(formuleEntity));
//////        formuleEntity.setServiceEntity(salleEntity);
//////
////        salleService.save(salleEntity);
////
////
////        Address addressEntity3 = createAddress(faker);
////        Address addressEntity4 = createAddress(faker);
////
//////        addressService.save(addressEntity);
//////
////        Person ps1 = createPerson(faker);
////
////        Societe societeEntity1 = createSociete(faker);
////        societeEntity1.setOwner(ps1);
////        societeEntity1.setLocalisation(addressEntity3);
////        societeService.save(societeEntity1);
////
////
////        Musique musiqueEntity = createMusique(faker);
////        musiqueEntity.setAdress(addressEntity4);
////        musiqueEntity.setSociete(societeEntity1);
////        Image image3 = createImage(faker);
////        musiqueEntity.setImage(image3);
//////        musiqueEntity.setFormuleEntities(Arrays.asList(formuleEntity1));
//////        formuleEntity.setServiceEntity(musiqueEntity);
//////
////        musiqueService.save(musiqueEntity);
////
////
////        Formule formuleEntity1 = createFormule(faker);
////        Image image1 = createImage(faker);
//////        image.setFormule(formuleEntity);
////        formuleEntity1.setImages(Arrays.asList(image1));
////        formuleEntity1.setService(musiqueEntity);
////        formuleService.save(formuleEntity1);
////
//////        musiqueEntity.setFormuleEntities(Arrays.asList(formuleEntity1));
//////        musiqueService.save(musiqueEntity);
//
////
    }

    //
    private Address createAddress(Faker faker) throws Exception {

        Address adress = new Address();
        adress.setBox(faker.address().streetAddressNumber());
        adress.setCodePostal(faker.number().numberBetween(1000, 2000));
        adress.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
        adress.setPays("Belgique");
        adress.setRue(faker.address().streetName());
        adress.setVille(faker.address().cityName());
        return adress;
    }


    private Person createPerson(Faker faker) throws Exception {
        Person person = new Person();
        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());
        person.setPhoneNbr(Long.parseLong((0 + "" + faker.number().numberBetween(470000000, 490000000))));


        return person;
    }

    private Musique createMusique(Faker faker) throws Exception {
        Musique me = new Musique();
        me.setNom("DJ SNACK");
        me.setMusiqueType(MusiqueType.DJ);
        return me;
    }
    private Media createMedia(Faker faker) throws Exception {
        Media me = new Media();
        me.setNom("PHOTBON");
        me.setDoAlbum(faker.bool().bool());
        me.setDoSouvenir(faker.bool().bool());
        me.setIsPhoto(faker.bool().bool());
        me.setIsVideo(faker.bool().bool());

        return me;
    }

    private Traiteur createTraiteur(Faker faker) throws Exception {
        Traiteur tt = new Traiteur();
        tt.setNom("TRAITEUR CORP");
        tt.setDoFish(faker.bool().bool());
        tt.setDoMeat(faker.bool().bool());
        tt.setDoVegan(faker.bool().bool());
        tt.setDoVegetarian(faker.bool().bool());

        return tt;
    }

    private ServiceTraiteur createServiceTraiteur(Faker faker) throws Exception {
        ServiceTraiteur st = new ServiceTraiteur();
        st.setNom("Serveur CORP");
        st.setManOnly(faker.bool().bool());
        st.setWomanOnly(faker.bool().bool());
        return st;
    }

    private MakeUpAndHair createServiceMakeUpAndHair(Faker faker) throws Exception {
        MakeUpAndHair muah = new MakeUpAndHair();
        muah.setNom("COIFFEUR CORP");
        muah.setDoHair(faker.bool().bool());
        muah.setDoMakeUp(faker.bool().bool());
        muah.setDoMan(faker.bool().bool());
        muah.setDoWoman(faker.bool().bool());
        return muah;
    }

    private User createUser(Faker faker, Role role) throws Exception {
        User client = new User();
        client.setEmail(faker.internet().emailAddress());
        client.setPassword(faker.internet().password());
        client.setRole(role);

        return client;
    }

    private Societe createSociete(Faker faker) throws Exception {
        Societe societe = new Societe();
        Long tel = Long.parseLong(0 + "" + faker.number().numberBetween(470000000, 490000000));
        societe.setNTVA("BE468468498");
        societe.setEmail(faker.internet().safeEmailAddress());
        societe.setNEntreprise(faker.number().numberBetween(30000L, 5000L));
        societe.setNom(faker.company().name());
        societe.setNTel(tel);

        return societe;
    }

    private Parking createParking(Faker faker) throws Exception {

        Parking parking = new Parking();
        parking.setCapacity(faker.number().numberBetween(3, 50));
        parking.setVoiturier(faker.bool().bool());


        return parking;

    }

    private Salle createSalle(Faker faker) throws Exception {
        /**Salle**/

        int capacity = faker.number().numberBetween(50, 200);
        Salle salle = new Salle();
        salle.setNom(faker.company().name());
        salle.setCapaciteTotal(capacity);
        salle.setCuisine(faker.bool().bool());
        salle.setDecoration(faker.bool().bool());
        salle.setMaterielMusique(faker.bool().bool());
        salle.setPisteDance(faker.bool().bool());
        salle.setPlaceAssise(capacity - 20 < 0 ? 13 : capacity - 20);
        salle.setTraiteur(faker.bool().bool());
        salle.setHaveParking(faker.bool().bool());
        salle.setHallTypeEntity(HallType.RandomHallType());
        salle.setIsExternal(faker.bool().bool());

        return salle;
    }

    private Image createImage(Faker faker) throws Exception {

        Image image = new Image();
        image.setPhoto(faker.internet().image().getBytes());

        return image;
    }

    private Formule createFormule(Faker faker) throws Exception {
        /**Formule**/

        Formule formule = new Formule();
        formule.setNom(faker.book().title());
        formule.setPrix(faker.number().numberBetween(50, 150));
        formule.setDescription(faker.lorem().sentence());
        Boolean isUnique = faker.bool().bool();
        formule.setIsUniquePrix(isUnique);

        if (!isUnique) {
            formule.setSupDimanche(faker.number().numberBetween(10, 50));
            formule.setSupVeilleFerier(faker.number().numberBetween(10, 50));
            formule.setSupFerrier(faker.number().numberBetween(10, 50));
            formule.setSupvendredi(faker.number().numberBetween(10, 50));
        } else {
            formule.setSupDimanche(0);
            formule.setSupVeilleFerier(0);
            formule.setSupFerrier(0);
            formule.setSupvendredi(0);
        }

        return formule;
    }

    private Fermeture createFermeture(Faker faker) throws FermetureDatabaseException {
        /**Fermeture**/
        Fermeture fermeture = new Fermeture();
        fermeture.setDate(new java.sql.Date(faker.date().future(5, TimeUnit.DAYS).getTime()));

        return fermeture;
    }

    private Reservation createreservation(Faker faker) throws Exception {

        Reservation reservation = new Reservation();
        reservation.setTicket(String.valueOf(reservation.hashCode()));
        reservation.setReservationDate(new Date(java.util.Date.from(Instant.now()).getTime()));
        reservation.setContract(new File("C:\\Users\\abdellah.elachhab\\Desktop\\MarryMe Project\\marryme-back\\src\\main\\resources\\Contract"));
        reservation.setPayementId(faker.crypto().md5());
        reservation.setStatus(STATUS_WAITING);
        reservation.setToken(faker.crypto().sha1());
        reservation.setPrice(50);
        reservation.setInceptionDate(new Date(java.util.Date.from(Instant.now()).getTime()));
        return reservation;
    }







}
