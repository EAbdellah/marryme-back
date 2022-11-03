package be.icc.ahe.marryme.runner;


import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.HallType;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.model.*;
import be.icc.ahe.marryme.model.mapper.SocieteMapper;
import be.icc.ahe.marryme.model.mapper.UserMapper;
import be.icc.ahe.marryme.service.*;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.Normalizer;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

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


    @Autowired
    public MyRunner(AddressService addressService, SalleService salleService,
                    SocieteService societeService, FermetureService fermetureService,
                    ParkingService parkingService, PersonService personService,
                    FormuleService formuleService, ImageService imageService,
                    UserService userService, MusiqueService musiqueService,
                    MediaService mediaService, MakeUpAndHairService makeUpAndHairService,
                    ServiceTraiteurService serviceTraiteurService, TraiteurService traiteurService,
                    ReservationService reservationService,ServicesService servicesService
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
    }

    @Override
    public void run(String... args) throws Exception {
























//        UserRegistrationFormDTO urf = new UserRegistrationFormDTO(
//                "Abdellah","Elachhab","Belgique","Bruxelles","1070","Boulevard Prince de Liege",
//                "44","4","0484732465","tamere@tamer.tame","SalutLesBronzé","par eamil"
//        );
//
//        Person person = RegistrationUserMapper.INSTANCE.dtotomodel(urf);
//
//        System.out.println(person);
//
//        PersonEntity personEntity =  PersonMapper.INSTANCE.modelToEntity(person);
//        System.out.println(personEntity);
//
//        personService.save(personEntity);
//
//

        Faker faker = new Faker((new Locale("fr_BE")));


        /**
         * CREATION UTILISATEUR
         * */
//        Address address = createAddress(faker);
//        User user = createUser(faker,Role.ROLE_ADMIN);
//        Person person = createPerson(faker);
//
//        person.setUser(user);
//        person.setLocalisation(address);
//
//        UserEntity u = UserMapper.INSTANCE.modelToEntity(user);
//
//        personService.save(person);
//

        /**
         * CREATION SOCIETE Musique
         * */
//
        Address address = createAddress(faker);

        User user = createUser(faker,Role.ROLE_ADMIN);

        Person person = createPerson(faker);
        person.setLocalisation(address);
        person.setUser(user);

        Societe societe = createSociete(faker);
        societe.setLocalisation(createAddress(faker));
        societe.setOwner(person);
        societeService.save(societe);

        /**
         * CREATION SERVICE --> SAVE VIA SOCIETE
         * */

        Societe societe1 = societeService.findByID(1L);
        LOG.info(societe1.toString());

        Musique musique = createMusique(faker);
        musique.setAddress(societe1.getLocalisation());
        LOG.info(societe1.getLocalisation().toString());

        LOG.info(musique.toString());
        societe1.setService(musique);
        societeService.save(societe1);
//


        /**
         * AJOUT FERMETURE --> SAVE VIA SERVICE
         * */
       Musique musique1 =  musiqueService.findByID(1L);
       musique1.setFermetures(Arrays.asList (createFermeture(faker),createFermeture(faker),createFermeture(faker)));
       musiqueService.save(musique1);


        /**
         * SUPRESSION FERMETURE (MANY TO MANY)--> SAVE VIA SERVICE
         * ETAPE :
         *          1    RECUPERER LE SERVICE
         *          2    RETOUVER CELUI QU'ON VEUT SUPPRIMER DE LA LISTE
         *          2bis RECUPERER L'ID DE LA FERMETURE
         *          2bis SUPPRIMER DE LA LISTE
         *          3    FAIRE UN SAVE DU SERVICE AVEC LA LISTE MODIFIER
         *          4    FAIRE UN DELETE DE LA FERMETURE CIBLER GRACE A L'ID
         * */

//       Musique musique1 =  musiqueService.findByID(1L);
//        List<Fermeture> list= (List<Fermeture>) musique1.getFermetures();
//        list.forEach(System.out::println);
//        list.remove(1);
//        list.forEach(System.out::println);
//        musique1.setFermetures(list);
//        musiqueService.save(musique1);
//        fermetureService.deleteById(1L);
//        fermetureService.deleteById(2L);


        System.out.println(servicesService.findByID(1L) );


        /**
         * CREATION SOCIETE SALLE
         * SA MERE LA P*** IL FAUT SAVE D'BORD LE SERVICE AVANT DE SAVE LA FORMULES
         * */

        Address addressSalle = createAddress(faker);

        User userSalle = createUser(faker,Role.ROLE_ADMIN);

        Person personSalle = createPerson(faker);
        personSalle.setLocalisation(addressSalle);
        personSalle.setUser(userSalle);

        Societe societeSalle = createSociete(faker);
        societeSalle.setLocalisation(createAddress(faker));
        societeSalle.setOwner(personSalle);




        Salle salle = createSalle(faker);
        salle.setAddress(addressService.findByID(1L));


        salle.setFermetures(Arrays.asList (createFermeture(faker),createFermeture(faker),createFermeture(faker)));
//        salleService.save(salle);


//        salle.setFormules(Arrays.asList( createFormule(faker), createFormule(faker), createFormule(faker)));

        societeSalle.setService(salle);


        salle.getFormules().forEach(System.out::println);

        societeService.save(societeSalle);



        Salle salle3 = createSalle(faker);
        salle3.setAddress(addressService.findByID(1L));
        salle3.setFermetures(Arrays.asList (createFermeture(faker),createFermeture(faker),createFermeture(faker)));

        salle3.setReservations(Collections.singletonList(createreservation(faker)));
        salle3.getFormules().forEach(System.out::println);

        salleService.save(salle3);

        Salle s4 = salleService.findByID(3L);
        Formule formule = createFormule(faker);

        formule.setImages(Arrays.asList(createImage(faker),createImage(faker),createImage(faker)));


        s4 .setFormules(Arrays.asList(formule,createFormule(faker),createFormule(faker)));
        salleService.save(s4);

        Formule f = formuleService.findByID(3L);
        f.setImages(Arrays.asList(createImage(faker),createImage(faker),createImage(faker)));
        formuleService.save(f);

        System.out.println(fermetureService.findByID(1L));



//        Societe s = societeService.findByID(1L);

//        Salle salle = createSalle(faker);
//        salle.setFormules((Arrays.asList(createFormule(faker))));
//
//        Address address1 = createAddress(faker);
////        addressService.save(address1);
//        LOG.info(address1.toString());
//        salle.setAddress(address1);
//
//        salle.setParking(createParking(faker));
//        salle.setImage(createImage(faker));
//
//        LOG.info(salle.toString());
//
//        salleService.save(salle);

//        musiqueService.save(createMusique(faker));




//        societeService.save(societeService.findByID(1L).setService(createMusique(faker)));



//        addressService.save(address);



//        Faker faker = new Faker((new Locale("fr_BE")));
//
//        Address addressEntity = createAddress(faker);
//        Address addressEntity2 = createAddress(faker);
//
////        addressService.save(addressEntity);
////
//        UserEntity userEntity = createUser(faker, Role.ROLE_USER);
//        Person ps = createPerson(faker);
////
//        Societe societeEntity = createSociete(faker);
//        societeEntity.setOwner(ps);
//        societeEntity.setLocalisation(addressEntity);
//        societeService.save(societeEntity);
////
////
//        Salle salleEntity = createSalle(faker);
//        salleEntity.setAdress(addressEntity2);
//        salleEntity.setSociete(societeEntity);
////
////
//        Formule formuleEntity = createFormule(faker);
//        System.out.println(formuleEntity);
//        Image image = createImage(faker);
//        formuleEntity.setImages(Arrays.asList(image));
//        salleEntity.setFormules(Arrays.asList(formuleEntity));
////        formuleEntity.setServiceEntity(salleEntity);
////
//        salleService.save(salleEntity);
//
//
//        Address addressEntity3 = createAddress(faker);
//        Address addressEntity4 = createAddress(faker);
//
////        addressService.save(addressEntity);
////
//        Person ps1 = createPerson(faker);
//
//        Societe societeEntity1 = createSociete(faker);
//        societeEntity1.setOwner(ps1);
//        societeEntity1.setLocalisation(addressEntity3);
//        societeService.save(societeEntity1);
//
//
//        Musique musiqueEntity = createMusique(faker);
//        musiqueEntity.setAdress(addressEntity4);
//        musiqueEntity.setSociete(societeEntity1);
//        Image image3 = createImage(faker);
//        musiqueEntity.setImage(image3);
////        musiqueEntity.setFormuleEntities(Arrays.asList(formuleEntity1));
////        formuleEntity.setServiceEntity(musiqueEntity);
////
//        musiqueService.save(musiqueEntity);
//
//
//        Formule formuleEntity1 = createFormule(faker);
//        Image image1 = createImage(faker);
////        image.setFormule(formuleEntity);
//        formuleEntity1.setImages(Arrays.asList(image1));
//        formuleEntity1.setService(musiqueEntity);
//        formuleService.save(formuleEntity1);
//
////        musiqueEntity.setFormuleEntities(Arrays.asList(formuleEntity1));
////        musiqueService.save(musiqueEntity);


    }

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
        societe.setNTVA(Long.parseLong(faker.number().numberBetween(0, 1) + "" + faker.number().numberBetween(1000000000, 999999999)));
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
        return reservation;
    }
}
