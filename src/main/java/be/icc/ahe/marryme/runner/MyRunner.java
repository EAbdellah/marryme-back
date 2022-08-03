package be.icc.ahe.marryme.runner;


import be.icc.ahe.marryme.exception.FermetureDatabaseException;
import be.icc.ahe.marryme.dataaccess.entity.*;
import be.icc.ahe.marryme.model.Societe;
import be.icc.ahe.marryme.service.*;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    private final AddressService addressService;
    private final SalleService salleService;
    private  final SocieteService societeService;
    private  final FermetureService fermetureService;
    private  final ParkingService parkingService;
    private final PersonService personService;
    private  final FormuleService formuleService;
    private  final ImageService imageService;
    private final UserService userService;
    private final MusiqueService musiqueService;
    private final MediaService mediaService;
    private final MakeUpAndHairService makeUpAndHairService;
    private  final ServiceTraiteurService serviceTraiteurService;
    private final TraiteurService traiteurService;
    private final ReservationService reservationService;

    @Autowired
    public MyRunner(AddressService addressService, SalleService salleService,
                    SocieteService societeService, FermetureService fermetureService,
                    ParkingService parkingService,PersonService personService,
                    FormuleService formuleService,ImageService imageService,
                    UserService userService,MusiqueService musiqueService,
                    MediaService mediaService,MakeUpAndHairService makeUpAndHairService,
                    ServiceTraiteurService serviceTraiteurService,TraiteurService traiteurService,
                    ReservationService reservationService
    ) {

        this.parkingService=parkingService;
        this.fermetureService=fermetureService;
        this.addressService = addressService;
        this.salleService = salleService;
        this.societeService =societeService;
        this.personService = personService;
        this.formuleService = formuleService;
        this.imageService =imageService;
        this.userService = userService;
        this.mediaService=mediaService;
        this.musiqueService=musiqueService;
        this.makeUpAndHairService=makeUpAndHairService;
        this.serviceTraiteurService=serviceTraiteurService;
        this.traiteurService=traiteurService;
        this.reservationService=reservationService;
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker((new Locale("fr_BE")));

        AddressEntity addressEntity = createAddress(faker);
        PersonEntity personEntity = createPerson(faker,Role.CLIENT);

        SocieteEntity societeEntity = createSociete(faker);
        societeEntity.setOwner(personEntity);
        societeService.save(societeEntity);


        SalleEntity salleEntity = createSalle(faker);
        salleEntity.setServiceAdress(addressEntity);
        salleEntity.setSociete(societeEntity);
        salleEntity.setServiceAdress(addressEntity);


       FormuleEntity formuleEntity =  createFormule(faker);
        ImageEntity image = createImage(faker);
        image.setFormule(formuleEntity);
        formuleEntity.setImages(Arrays.asList(image));
        salleEntity.setFormuleEntities(Arrays.asList(formuleEntity));
        formuleEntity.setServiceEntity(salleEntity);

        salleService.save(salleEntity);


    }

        private AddressEntity createAddress(Faker faker) throws Exception{

            /**ADRESSE**/
            AddressEntity adress = new AddressEntity();
//        addressEntity.setAdressID(1L);

            adress.setBox(faker.address().streetAddressNumber());
            adress.setCodePostal(faker.number().numberBetween(1000, 2000));
            adress.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
            adress.setPays("Belgique");
            adress.setRue(faker.address().streetName());
            adress.setVille(faker.address().cityName());

            return adress;
        }

        private PersonEntity createPerson(Faker faker, Role role) throws Exception{
            /**Person1**/
            UserEntity client = new UserEntity();
            client.setNom(faker.name().lastName());
            client.setPrenom(faker.name().firstName());
            client.setEmail(faker.internet().emailAddress());
            client.setnTel(Long.parseLong((0 + "" + faker.number().numberBetween(470000000, 490000000))));
            client.setLogin(faker.name().username());
            client.setMdp(faker.internet().password());
            client.setRole(role);

            return client;
        }

        private SocieteEntity createSociete(Faker faker) throws Exception {
            SocieteEntity societe = new SocieteEntity();
            Long tel = Long.parseLong(0 + "" + faker.number().numberBetween(470000000, 490000000));
            societe.setnTVA(Long.parseLong(faker.number().numberBetween(0, 1) + "" + faker.number().numberBetween(1000000000, 999999999)));
            societe.setEmail(faker.internet().safeEmailAddress());
            societe.setnEntreprise(faker.number().numberBetween(30000L, 5000L));
            societe.setNom(faker.company().name());
            societe.setnTel(tel);
            return societe;
        }

        private ParkingEntity createParking(Faker faker) throws Exception {

        ParkingEntity parkingEntity = new ParkingEntity();
        parkingEntity.setCapacity(faker.number().numberBetween(3, 50));
        parkingEntity.setVoiturier(faker.bool().bool());
//        parkingService.save(parkingEntity);
//            parkingEntity.setSalleEntity(salleEntity);
//            parkingService.save(parkingEntity);

        return parkingEntity;

    }

        private SalleEntity createSalle(Faker faker ) throws Exception {
            /**Salle**/

            int capacity = faker.number().numberBetween(50, 200);
            SalleEntity salleEntity = new SalleEntity();
            salleEntity.setNom(faker.company().name());
            salleEntity.setCapaciteTotal(capacity);
            salleEntity.setCuisine(faker.bool().bool());
            salleEntity.setDecoration(faker.bool().bool());
            salleEntity.setMaterielMusique(faker.bool().bool());
            salleEntity.setPisteDance(faker.bool().bool());
            salleEntity.setPlaceAssise(capacity - 20 < 0 ? 13 : capacity - 20);
            salleEntity.setTraiteur(faker.bool().bool());
            salleEntity.setHaveParking(faker.bool().bool());
                salleEntity.setHallTypeEntity(HallTypeEntity.RandomHallType());
                salleEntity.setExternal(faker.bool().bool());

            return salleEntity;
        }

        private ImageEntity createImage(Faker faker) throws Exception {

            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setPhoto(faker.internet().image().getBytes());

            return imageEntity;
        }

    private FormuleEntity createFormule(Faker faker) throws Exception{
        /**Formule**/

        FormuleEntity formuleEntity = new FormuleEntity();
        formuleEntity.setNom(faker.book().title());
        formuleEntity.setPrix(faker.number().numberBetween(50, 150));
//        formuleEntity.setImages(imageEntities);

        formuleEntity.setDescription(faker.lorem().sentence());
        Boolean isUnique = faker.bool().bool();
        formuleEntity.setUniquePrix(isUnique);

        if (!isUnique) {
            formuleEntity.setSupDimanche(faker.number().numberBetween(10, 50));
            formuleEntity.setSupVeilleFerier(faker.number().numberBetween(10, 50));
            formuleEntity.setCodePostal(faker.number().numberBetween(10, 50));
            formuleEntity.setSupFerrier(faker.number().numberBetween(10, 50));
            formuleEntity.setSupvendredi(faker.number().numberBetween(10, 50));
        } else {
            formuleEntity.setSupDimanche(0);
            formuleEntity.setSupVeilleFerier(0);
            formuleEntity.setCodePostal(0);
            formuleEntity.setSupFerrier(0);
            formuleEntity.setSupvendredi(0);
        }

//        formuleService.save(formuleEntity);
//
//        for (ImageEntity ie: imageEntities) {
//            ie.setFormule(formuleEntity);
//            imageService.save(ie);
//
//        }


        return formuleEntity;
    }

    private FermetureEntity createFermeture (Faker faker) throws FermetureDatabaseException {
            /**Fermeture**/
            FermetureEntity fermetureEntity = new FermetureEntity();
            fermetureEntity.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
            fermetureService.save(fermetureEntity);

            return fermetureEntity;
        }

        private ReservationEntity createreservation(Faker faker)throws Exception{

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setTicket(String.valueOf(reservationEntity.hashCode()));
        reservationEntity.setReservationDate(new Date(java.util.Date.from(Instant.now()).getTime()));
        return reservationEntity;
    }
//    /**************************Salle******************************/
//    private void insertSalle (Faker faker) throws Exception {
//
////        for(int i = 0; i < 20; i++) {
//
//
//            /**ADRESSE**/
//        AddressEntity addressEntity = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//        addressEntity.setBox(faker.address().streetAddressNumber());
//        addressEntity.setCodePostal(faker.number().numberBetween(1000, 2000));
//        addressEntity.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
//        addressEntity.setPays("Belgique");
//        addressEntity.setRue(faker.address().streetName());
//        addressEntity.setVille(faker.address().cityName());
//        addressService.save(addressEntity);
//
//        /**Societe**/
//
//        SocieteEntity societeEntity = new SocieteEntity();
//        Long tel = Long.parseLong(0 + "" + faker.number().numberBetween(470000000, 490000000));
//        societeEntity.setnTVA(Long.parseLong(faker.number().numberBetween(0, 1) + "" + faker.number().numberBetween(1000000000, 999999999)));
//        societeEntity.setEmail(faker.internet().safeEmailAddress());
//        societeEntity.setLocalisation(addressEntity);
//        societeEntity.setnEntreprise(faker.number().numberBetween(30000L, 5000L));
//        societeEntity.setNom(faker.company().name());
//        societeEntity.setnTel(tel);
//        societeService.save(societeEntity);
//
//
//        /**Person**/
//
//        UserEntity personEntity = new UserEntity();
//        personEntity.setNom(faker.name().lastName());
//        personEntity.setPrenom(faker.name().firstName());
//        personEntity.setEmail(faker.internet().safeEmailAddress());
//        personEntity.setLocalisation(addressEntity);
//        personEntity.setnTel(tel);
//        personEntity.setSocieteEntity(societeEntity);
//        personEntity.setLogin(faker.name().username());
//        personEntity.setMdp(faker.internet().password());
//        personEntity.setRole(Role.PRESTATAIRE);
//        userService.save(personEntity);
//
//        /**Parking**/
//
//        ParkingEntity parkingEntity = new ParkingEntity();
//        parkingEntity.setCapacity(faker.number().numberBetween(3, 50));
//        parkingEntity.setVoiturier(faker.bool().bool());
//        parkingService.save(parkingEntity);
//
//
//        /**Image**/
//
//        ImageEntity imageEntity = new ImageEntity();
//        imageEntity.setPhoto(faker.internet().image().getBytes());
//        imageService.save(imageEntity);
//
//
//        /**Salle**/
//
//        int capacity = faker.number().numberBetween(50, 200);
//        SalleEntity salleEntity = new SalleEntity();
//        salleEntity.setServiceAdress(addressEntity);
//        salleEntity.setNom(faker.company().name());
//        salleEntity.setCapaciteTotal(capacity);
//        salleEntity.setCuisine(faker.bool().bool());
//        salleEntity.setSociete(societeEntity);
//        salleEntity.setDecoration(faker.bool().bool());
//        salleEntity.setMaterielMusique(faker.bool().bool());
//        salleEntity.setPisteDance(faker.bool().bool());
//        salleEntity.setPlaceAssise(capacity - 20 < 0 ? 13 : capacity - 20);
//        salleEntity.setTraiteur(faker.bool().bool());
//
////        salleEntity.setParkingEntity(parkingEntity);
//        salleEntity.setServiceAdress(addressEntity);
//        salleEntity.setHallTypeEntity(HallTypeEntity.RandomHallType());
//        salleEntity.setExternal(faker.bool().bool());
////                salleEntity.setFermetures(fermetureSet);
////        List<ServiceEntity> salleEntities = new ArrayList<>();
////        salleEntities.add(salleEntity);
//        salleService.save(salleEntity);


//        /**Fermeture**/
//        FermetureEntity fermetureEntity = new FermetureEntity();
//        fermetureEntity.setDate(new java.sql.Date(faker.date().future(5, TimeUnit.DAYS).getTime()));
//        fermetureService.save(fermetureEntity);
//
//        fermetureEntity.setServiceEntity(salleEntities);
//        fermetureService.save(fermetureEntity);
//
//
//        FermetureEntity fermetureEntity2 = new FermetureEntity();
//        fermetureEntity2.setDate(new java.sql.Date(faker.date().future(5, TimeUnit.DAYS).getTime()));
//        fermetureService.save(fermetureEntity2);
//
//        fermetureEntity2.setServiceEntity(salleEntities);
//        fermetureService.save(fermetureEntity2);

//
//                FermetureEntity fermetureEntity3 = new FermetureEntity();
//                fermetureEntity3.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//                fermetureEntity3.setServiceEntity(salleEntities);
//                fermetureService.save(fermetureEntity3);

//                Set<FermetureEntity> fermetureSet = new HashSet<>();
//                fermetureSet.add(fermetureEntity);
//                fermetureSet.add(fermetureEntity2);
//                fermetureSet.add(fermetureEntity3);


//        /**Formule**/
//
//        FormuleEntity formuleEntity = new FormuleEntity();
//        formuleEntity.setNom(faker.book().title());
//        formuleEntity.setPrix(faker.number().numberBetween(50, 150));
////            formuleEntity.setImages(imageEntities);
//
//        formuleEntity.setDescription(faker.lorem().sentence());
//        Boolean isUnique = faker.bool().bool();
//        formuleEntity.setUniquePrix(isUnique);
//        formuleEntity.setServiceEntity(salleEntity);
//
//        if (!isUnique) {
//            formuleEntity.setSupDimanche(faker.number().numberBetween(10, 50));
//            formuleEntity.setSupVeilleFerier(faker.number().numberBetween(10, 50));
//            formuleEntity.setCodePostal(faker.number().numberBetween(10, 50));
//            formuleEntity.setSupFerrier(faker.number().numberBetween(10, 50));
//            formuleEntity.setSupvendredi(faker.number().numberBetween(10, 50));
//        } else {
//            formuleEntity.setSupDimanche(0);
//            formuleEntity.setSupVeilleFerier(0);
//            formuleEntity.setCodePostal(0);
//            formuleEntity.setSupFerrier(0);
//            formuleEntity.setSupvendredi(0);
//        }
//        formuleService.save(formuleEntity);
//
//
//        FormuleEntity formuleEntity2 = new FormuleEntity();
//        formuleEntity2.setNom(faker.food().dish());
//        formuleEntity2.setPrix(faker.number().numberBetween(50, 150));
////            formuleEntity2.setImages(imageEntities);
//
//        formuleEntity2.setDescription(faker.lorem().sentence());
//        Boolean isUnique2 = faker.bool().bool();
//        formuleEntity2.setUniquePrix(isUnique2);
//        formuleEntity2.setServiceEntity(salleEntity);
//
//
//        if (!isUnique2) {
//            formuleEntity2.setSupDimanche(faker.number().numberBetween(10, 50));
//            formuleEntity2.setSupVeilleFerier(faker.number().numberBetween(10, 50));
//            formuleEntity2.setCodePostal(faker.number().numberBetween(10, 50));
//            formuleEntity2.setSupFerrier(faker.number().numberBetween(10, 50));
//            formuleEntity2.setSupvendredi(faker.number().numberBetween(10, 50));
//        } else {
//            formuleEntity2.setSupDimanche(0);
//            formuleEntity2.setSupVeilleFerier(0);
//            formuleEntity2.setCodePostal(0);
//            formuleEntity2.setSupFerrier(0);
//            formuleEntity2.setSupvendredi(0);
//        }
//        formuleService.save(formuleEntity2);
//
//        List<FormuleEntity> formuleSet = new ArrayList<>();
//        formuleSet.add(formuleEntity);
//        formuleSet.add(formuleEntity2);
//
//
//        ImageEntity imageEntity2 = new ImageEntity();
//        imageEntity2.setPhoto(faker.internet().image().getBytes());
//        imageEntity2.setFormule(formuleEntity);
//        imageService.save(imageEntity2);
//
//        ImageEntity imageEntity3 = new ImageEntity();
//        imageEntity3.setPhoto(faker.internet().image().getBytes());
//        imageEntity3.setFormule(formuleEntity2);
//
//        imageService.save(imageEntity3);
//
//        List<ImageEntity> imageEntities = new ArrayList<>();
//        imageEntities.add(imageEntity2);
//        imageEntities.add(imageEntity3);
//
//        /**ADRESSE**/
//        AddressEntity addressEntity1 = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//        addressEntity1.setBox(faker.address().streetAddressNumber());
//        addressEntity1.setCodePostal(faker.number().numberBetween(1000, 2000));
//        addressEntity1.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
//        addressEntity1.setPays("Belgique");
//        addressEntity1.setRue(faker.address().streetName());
//        addressEntity1.setVille(faker.address().cityName());
//        addressService.save(addressEntity1);
//
//
//        /**Person1**/
//        UserEntity personEntity1 = new UserEntity();
//        personEntity1.setNom(faker.name().lastName());
//        personEntity1.setPrenom(faker.name().firstName());
//        personEntity1.setEmail(faker.internet().emailAddress());
//        personEntity1.setLocalisation(addressEntity1);
//        personEntity1.setnTel(Long.parseLong((0 + "" + faker.number().numberBetween(470000000, 490000000))));
//        personEntity1.setSocieteEntity(null);
//        personEntity1.setLogin(faker.name().username());
//        personEntity1.setMdp(faker.internet().password());
//        personEntity1.setRole(Role.CLIENT);
//        userService.save(personEntity1);
//

//        /**Reservation**/
//
//        ReservationEntity reservationEntity = new ReservationEntity();
//        reservationEntity.setReservationDate(new java.sql.Date(faker.date().future(100, TimeUnit.DAYS).getTime()));
//        reservationEntity.setServiceEntity(salleEntity);
//        reservationEntity.setTicket(faker.random().hex());
//        reservationEntity.setUserEntity(personEntity1);
//        reservationService.save(reservationEntity);
//    }
            }




//    /**************************Musique******************************/
//
//    private void insertMusique (Faker faker) throws Exception {
//
//        for(int i = 0; i < 20; i++) {
//
//
//            /**ADRESSE**/
//            AddressEntity addressEntity = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity.setBox(faker.address().streetAddressNumber());
//            addressEntity.setCodePostal(faker.number().numberBetween(1000,2000));
//            addressEntity.setNumero(String.valueOf(faker.number().numberBetween(1,200)));
//            addressEntity.setPays("Belgique");
//            addressEntity.setRue(faker.address().streetName());
//            addressEntity.setVille(faker.address().cityName());
//            addressService.save(addressEntity);
//
//            /**Societe**/
//
//            SocieteEntity societeEntity =new SocieteEntity();
//            Long tel =Long.parseLong( 0+""+faker.number().numberBetween(470000000,490000000));
//            societeEntity.setnTVA(Long.parseLong(faker.number().numberBetween(0,1)+""+faker.number().numberBetween(1000000000,999999999)));
//            societeEntity.setEmail(faker.internet().safeEmailAddress());
//            societeEntity.setLocalisation(addressEntity);
//            societeEntity.setnEntreprise(faker.number().numberBetween(30000L,5000L));
//            societeEntity.setNom(faker.company().name());
//            societeEntity.setnTel(tel);
//            societeService.save(societeEntity);
//
//
//            /**Person**/
//
//            UserEntity personEntity = new UserEntity();
//            personEntity.setNom(faker.name().lastName());
//            personEntity.setPrenom(faker.name().firstName());
//            personEntity.setEmail(faker.internet().safeEmailAddress());
//            personEntity.setLocalisation(addressEntity);
//            personEntity.setnTel(tel);
//            personEntity.setSocieteEntity(societeEntity);
//            personEntity.setLogin(faker.name().username());
//            personEntity.setMdp(faker.internet().password());
//            personEntity.setRole(Role.PRESTATAIRE);
//            userService.save(personEntity);
//
//
//            /**Fermeture**/
//            FermetureEntity fermetureEntity = new FermetureEntity();
//            fermetureEntity.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureEntity.setId((long) i);
//            fermetureService.save(fermetureEntity);
//
//            FermetureEntity fermetureEntity2 = new FermetureEntity();
//            fermetureEntity2.setId((long) (50 + i));
//            fermetureEntity2.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity2);
//
//            FermetureEntity fermetureEntity3 = new FermetureEntity();
//            fermetureEntity.setId((long) 100+i);
//            fermetureEntity3.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity3);
//
//            Set<FermetureEntity> fermetureSet = new HashSet<>();
//            fermetureSet.add(fermetureEntity);
//            fermetureSet.add(fermetureEntity2);
//            fermetureSet.add(fermetureEntity3);
//
//            /**Image**/
//
//            ImageEntity imageEntity = new ImageEntity();
//            imageEntity.setPhoto(faker.internet().image().getBytes());
//            imageService.save(imageEntity);
//
//
//
//            /**Musique**/
//
//            MusiqueEntity musiqueEntity = new MusiqueEntity();
//            musiqueEntity.setMusiqueType(MusiqueType.musiqueType());
//            musiqueEntity.setFermetures(fermetureSet);
////            musiqueEntity.setFormuleEntities();
//            musiqueEntity.setImage(imageEntity);
//            musiqueEntity.setNom(faker.company().name());
//            musiqueEntity.setServiceAdress(addressEntity);
//            musiqueEntity.setSociete(societeEntity);
//            musiqueService.save(musiqueEntity);
//
//
//
//
//            /**Formule**/
//
//            FormuleEntity formuleEntity = new FormuleEntity();
//            formuleEntity.setNom(faker.food().dish());
//            formuleEntity.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity.setImages(imageEntities);
//
//            formuleEntity.setDescription(faker.lorem().sentence());
//            Boolean isUnique = faker.bool().bool();
//            formuleEntity.setUniquePrix(isUnique);
//            formuleEntity.setServiceEntity(musiqueEntity);
//
//            if (!isUnique) {
//                formuleEntity.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity.setSupvendredi(faker.number().numberBetween(10,50));
//            }else
//            {   formuleEntity.setSupDimanche(0);
//                formuleEntity.setSupVeilleFerier(0);
//                formuleEntity.setCodePostal(0);
//                formuleEntity.setSupFerrier(0);
//                formuleEntity.setSupvendredi(0);}
//            formuleService.save(formuleEntity);
//
//
//            FormuleEntity formuleEntity2 = new FormuleEntity();
//            formuleEntity2.setNom(faker.food().dish());
//            formuleEntity2.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity2.setImages(imageEntities);
//
//            formuleEntity2.setDescription(faker.lorem().sentence());
//            Boolean isUnique2 = faker.bool().bool();
//            formuleEntity2.setUniquePrix(isUnique2);
//            formuleEntity2.setServiceEntity(musiqueEntity);
//
//
//            if (!isUnique2) {
//                formuleEntity2.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity2.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupvendredi(faker.number().numberBetween(10,50));
//            }
//            else
//            {   formuleEntity2.setSupDimanche(0);
//                formuleEntity2.setSupVeilleFerier(0);
//                formuleEntity2.setCodePostal(0);
//                formuleEntity2.setSupFerrier(0);
//                formuleEntity2.setSupvendredi(0);}
//            formuleService.save(formuleEntity2);
//
//            List<FormuleEntity> formuleSet = new ArrayList<>();
//            formuleSet.add(formuleEntity);
//            formuleSet.add(formuleEntity2);
//
//
//
//            ImageEntity imageEntity2 = new ImageEntity();
//            imageEntity2.setPhoto(faker.internet().image().getBytes());
//            imageEntity2.setFormule(formuleEntity);
//            imageService.save(imageEntity2);
//
//            ImageEntity imageEntity3 = new ImageEntity();
//            imageEntity3.setPhoto(faker.internet().image().getBytes());
//            imageEntity3.setFormule(formuleEntity2);
//
//            imageService.save(imageEntity3);
//
//            List<ImageEntity> imageEntities = new ArrayList<>();
//            imageEntities.add(imageEntity2);
//            imageEntities.add(imageEntity3);
//
//            /**ADRESSE**/
//            AddressEntity addressEntity1 = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity1.setBox(faker.address().streetAddressNumber());
//            addressEntity1.setCodePostal(faker.number().numberBetween(1000, 2000));
//            addressEntity1.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
//            addressEntity1.setPays("Belgique");
//            addressEntity1.setRue(faker.address().streetName());
//            addressEntity1.setVille(faker.address().cityName());
//            addressService.save(addressEntity1);
//
//
//            /**Person1**/
//            UserEntity personEntity1 = new UserEntity();
//            personEntity1.setNom(faker.name().lastName());
//            personEntity1.setPrenom(faker.name().firstName());
//            personEntity1.setEmail(faker.internet().emailAddress());
//            personEntity1.setLocalisation(addressEntity1);
//            personEntity1.setnTel(Long.parseLong((0 + "" + faker.number().numberBetween(470000000, 490000000))));
//            personEntity1.setSocieteEntity(null);
//            personEntity1.setLogin(faker.name().username());
//            personEntity1.setMdp(faker.internet().password());
//            personEntity1.setRole(Role.CLIENT);
//            userService.save(personEntity1);
//
//
//            /**Reservation**/
//
//            ReservationEntity reservationEntity = new ReservationEntity();
//            reservationEntity.setReservationDate(new java.sql.Date (faker.date().future(100,TimeUnit.DAYS).getTime()));
//            reservationEntity.setServiceEntity(musiqueEntity);
//            reservationEntity.setTicket(faker.random().hex());
//            reservationEntity.setUserEntity(personEntity1);
//            reservationService.save(reservationEntity);
//
//        }
//    }
//    /**************************Media******************************/
//
//    private void insertMedia(Faker faker) throws Exception {
//
//        for(int i = 0; i < 20; i++) {
//
//
//            /**ADRESSE**/
//            AddressEntity addressEntity = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity.setBox(faker.address().streetAddressNumber());
//            addressEntity.setCodePostal(faker.number().numberBetween(1000,2000));
//            addressEntity.setNumero(String.valueOf(faker.number().numberBetween(1,200)));
//            addressEntity.setPays("Belgique");
//            addressEntity.setRue(faker.address().streetName());
//            addressEntity.setVille(faker.address().cityName());
//            addressService.save(addressEntity);
//
//            /**Societe**/
//
//            SocieteEntity societeEntity =new SocieteEntity();
//            Long tel =Long.parseLong( 0+""+faker.number().numberBetween(470000000,490000000));
//            societeEntity.setnTVA(Long.parseLong(faker.number().numberBetween(0,1)+""+faker.number().numberBetween(1000000000,999999999)));
//            societeEntity.setEmail(faker.internet().safeEmailAddress());
//            societeEntity.setLocalisation(addressEntity);
//            societeEntity.setnEntreprise(faker.number().numberBetween(30000L,5000L));
//            societeEntity.setNom(faker.company().name());
//            societeEntity.setnTel(tel);
//            societeService.save(societeEntity);
//
//
//            /**Person**/
//
//            UserEntity personEntity = new UserEntity();
//            personEntity.setNom(faker.name().lastName());
//            personEntity.setPrenom(faker.name().firstName());
//            personEntity.setEmail(faker.internet().safeEmailAddress());
//            personEntity.setLocalisation(addressEntity);
//            personEntity.setnTel(tel);
//            personEntity.setSocieteEntity(societeEntity);
//            personEntity.setLogin(faker.name().username());
//            personEntity.setMdp(faker.internet().password());
//            personEntity.setRole(Role.PRESTATAIRE);
//            userService.save(personEntity);
//
//
//            /**Fermeture**/
//            FermetureEntity fermetureEntity = new FermetureEntity();
//            fermetureEntity.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureEntity.setId((long) i);
//            fermetureService.save(fermetureEntity);
//
//            FermetureEntity fermetureEntity2 = new FermetureEntity();
//            fermetureEntity2.setId((long) (50 + i));
//            fermetureEntity2.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity2);
//
//            FermetureEntity fermetureEntity3 = new FermetureEntity();
//            fermetureEntity.setId((long) 100+i);
//            fermetureEntity3.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity3);
//
//            Set<FermetureEntity> fermetureSet = new HashSet<>();
//            fermetureSet.add(fermetureEntity);
//            fermetureSet.add(fermetureEntity2);
//            fermetureSet.add(fermetureEntity3);
//
//            /**Image**/
//
//            ImageEntity imageEntity = new ImageEntity();
//            imageEntity.setPhoto(faker.internet().image().getBytes());
//            imageService.save(imageEntity);
//
//
//
//            /**Media**/
//
//            MediaEntity mediaEntity = new MediaEntity();
//            mediaEntity.setDoAlbum(faker.bool().bool());
//            mediaEntity.setDoSouvenir(faker.bool().bool());
//            mediaEntity.setPhoto(faker.bool().bool());
//            mediaEntity.setVideo(faker.bool().bool());
//            mediaEntity.setFermetures(fermetureSet);
////            mediaEntity.setFormuleEntities();
//            mediaEntity.setImage(imageEntity);
//            mediaEntity.setNom(faker.company().name());
//            mediaEntity.setServiceAdress(addressEntity);
//            mediaEntity.setSociete(societeEntity);
//            mediaService.save(mediaEntity);
//
//
//            /**Formule**/
//
//            FormuleEntity formuleEntity = new FormuleEntity();
//            formuleEntity.setNom(faker.food().dish());
//            formuleEntity.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity.setImages(imageEntities);
//
//            formuleEntity.setDescription(faker.lorem().sentence());
//            Boolean isUnique = faker.bool().bool();
//            formuleEntity.setUniquePrix(isUnique);
//            formuleEntity.setServiceEntity(mediaEntity);
//
//            if (!isUnique) {
//                formuleEntity.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity.setSupvendredi(faker.number().numberBetween(10,50));
//            }else
//            {   formuleEntity.setSupDimanche(0);
//                formuleEntity.setSupVeilleFerier(0);
//                formuleEntity.setCodePostal(0);
//                formuleEntity.setSupFerrier(0);
//                formuleEntity.setSupvendredi(0);}
//            formuleService.save(formuleEntity);
//
//
//            FormuleEntity formuleEntity2 = new FormuleEntity();
//            formuleEntity2.setNom(faker.food().dish());
//            formuleEntity2.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity2.setImages(imageEntities);
//
//            formuleEntity2.setDescription(faker.lorem().sentence());
//            Boolean isUnique2 = faker.bool().bool();
//            formuleEntity2.setUniquePrix(isUnique2);
//            formuleEntity2.setServiceEntity(mediaEntity);
//
//
//            if (!isUnique2) {
//                formuleEntity2.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity2.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupvendredi(faker.number().numberBetween(10,50));
//            }
//            else
//            {   formuleEntity2.setSupDimanche(0);
//                formuleEntity2.setSupVeilleFerier(0);
//                formuleEntity2.setCodePostal(0);
//                formuleEntity2.setSupFerrier(0);
//                formuleEntity2.setSupvendredi(0);}
//            formuleService.save(formuleEntity2);
//
//            List<FormuleEntity> formuleSet = new ArrayList<>();
//            formuleSet.add(formuleEntity);
//            formuleSet.add(formuleEntity2);
//
//
//
//            ImageEntity imageEntity2 = new ImageEntity();
//            imageEntity2.setPhoto(faker.internet().image().getBytes());
//            imageEntity2.setFormule(formuleEntity);
//            imageService.save(imageEntity2);
//
//            ImageEntity imageEntity3 = new ImageEntity();
//            imageEntity3.setPhoto(faker.internet().image().getBytes());
//            imageEntity3.setFormule(formuleEntity2);
//
//            imageService.save(imageEntity3);
//
//            List<ImageEntity> imageEntities = new ArrayList<>();
//            imageEntities.add(imageEntity2);
//            imageEntities.add(imageEntity3);
//
//            /**ADRESSE**/
//            AddressEntity addressEntity1 = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity1.setBox(faker.address().streetAddressNumber());
//            addressEntity1.setCodePostal(faker.number().numberBetween(1000, 2000));
//            addressEntity1.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
//            addressEntity1.setPays("Belgique");
//            addressEntity1.setRue(faker.address().streetName());
//            addressEntity1.setVille(faker.address().cityName());
//            addressService.save(addressEntity1);
//
//
//            /**Person1**/
//            UserEntity personEntity1 = new UserEntity();
//            personEntity1.setNom(faker.name().lastName());
//            personEntity1.setPrenom(faker.name().firstName());
//            personEntity1.setEmail(faker.internet().emailAddress());
//            personEntity1.setLocalisation(addressEntity1);
//            personEntity1.setnTel(Long.parseLong((0 + "" + faker.number().numberBetween(470000000, 490000000))));
//            personEntity1.setSocieteEntity(null);
//            personEntity1.setLogin(faker.name().username());
//            personEntity1.setMdp(faker.internet().password());
//            personEntity1.setRole(Role.CLIENT);
//            userService.save(personEntity1);
//
//
//            /**Reservation**/
//
//            ReservationEntity reservationEntity = new ReservationEntity();
//            reservationEntity.setReservationDate(new java.sql.Date (faker.date().future(100,TimeUnit.DAYS).getTime()));
//            reservationEntity.setServiceEntity(mediaEntity);
//            reservationEntity.setTicket(faker.random().hex());
//            reservationEntity.setUserEntity(personEntity1);
//            reservationService.save(reservationEntity);
//
//
//        }
//    }
//
//    /**************************MAKEUP******************************/
//
//    private void insertMakeUp (Faker faker) throws Exception {
//
//
//        for(int i = 0; i < 20; i++) {
//
//
//            /**ADRESSE**/
//            AddressEntity addressEntity = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity.setBox(faker.address().streetAddressNumber());
//            addressEntity.setCodePostal(faker.number().numberBetween(1000,2000));
//            addressEntity.setNumero(String.valueOf(faker.number().numberBetween(1,200)));
//            addressEntity.setPays("Belgique");
//            addressEntity.setRue(faker.address().streetName());
//            addressEntity.setVille(faker.address().cityName());
//            addressService.save(addressEntity);
//
//            /**Societe**/
//
//            SocieteEntity societeEntity =new SocieteEntity();
//            Long tel =Long.parseLong( 0+""+faker.number().numberBetween(470000000,490000000));
//            societeEntity.setnTVA(Long.parseLong(faker.number().numberBetween(0,1)+""+faker.number().numberBetween(1000000000,999999999)));
//            societeEntity.setEmail(faker.internet().safeEmailAddress());
//            societeEntity.setLocalisation(addressEntity);
//            societeEntity.setnEntreprise(faker.number().numberBetween(30000L,5000L));
//            societeEntity.setNom(faker.company().name());
//            societeEntity.setnTel(tel);
//            societeService.save(societeEntity);
//
//
//            /**Person**/
//
//            UserEntity personEntity = new UserEntity();
//            personEntity.setNom(faker.name().lastName());
//            personEntity.setPrenom(faker.name().firstName());
//            personEntity.setEmail(faker.internet().safeEmailAddress());
//            personEntity.setLocalisation(addressEntity);
//            personEntity.setnTel(tel);
//            personEntity.setSocieteEntity(societeEntity);
//            personEntity.setLogin(faker.name().username());
//            personEntity.setMdp(faker.internet().password());
//            personEntity.setRole(Role.PRESTATAIRE);
//            userService.save(personEntity);
//
//
//            /**Fermeture**/
//            FermetureEntity fermetureEntity = new FermetureEntity();
//            fermetureEntity.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureEntity.setId((long) i);
//            fermetureService.save(fermetureEntity);
//
//            FermetureEntity fermetureEntity2 = new FermetureEntity();
//            fermetureEntity2.setId((long) (50 + i));
//            fermetureEntity2.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity2);
//
//            FermetureEntity fermetureEntity3 = new FermetureEntity();
//            fermetureEntity.setId((long) 100+i);
//            fermetureEntity3.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity3);
//
//            Set<FermetureEntity> fermetureSet = new HashSet<>();
//            fermetureSet.add(fermetureEntity);
//            fermetureSet.add(fermetureEntity2);
//            fermetureSet.add(fermetureEntity3);
//
//            /**Image**/
//
//            ImageEntity imageEntity = new ImageEntity();
//            imageEntity.setPhoto(faker.internet().image().getBytes());
//            imageService.save(imageEntity);
//
//
//
//            /**Media**/
//
//            MakeUpAndHairEntity makeUpAndHairEntity = new MakeUpAndHairEntity();
//            makeUpAndHairEntity.setDoHair(faker.bool().bool());
//            makeUpAndHairEntity.setDoMakeUp(faker.bool().bool());
//            makeUpAndHairEntity.setDoMan(faker.bool().bool());
//            makeUpAndHairEntity.setDoWoman(faker.bool().bool());
//            makeUpAndHairEntity.setFermetures(fermetureSet);
////            mediaEntity.setFormuleEntities();
//            makeUpAndHairEntity.setImage(imageEntity);
//            makeUpAndHairEntity.setNom(faker.company().name());
//            makeUpAndHairEntity.setServiceAdress(addressEntity);
//            makeUpAndHairEntity.setSociete(societeEntity);
//            makeUpAndHairService.save(makeUpAndHairEntity);
//
//
//            /**Formule**/
//
//            FormuleEntity formuleEntity = new FormuleEntity();
//            formuleEntity.setNom(faker.food().dish());
//            formuleEntity.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity.setImages(imageEntities);
//
//            formuleEntity.setDescription(faker.lorem().sentence());
//            Boolean isUnique = faker.bool().bool();
//            formuleEntity.setUniquePrix(isUnique);
//            formuleEntity.setServiceEntity(makeUpAndHairEntity);
//
//            if (!isUnique) {
//                formuleEntity.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity.setSupvendredi(faker.number().numberBetween(10,50));
//            }else
//            {   formuleEntity.setSupDimanche(0);
//                formuleEntity.setSupVeilleFerier(0);
//                formuleEntity.setCodePostal(0);
//                formuleEntity.setSupFerrier(0);
//                formuleEntity.setSupvendredi(0);}
//            formuleService.save(formuleEntity);
//
//
//            FormuleEntity formuleEntity2 = new FormuleEntity();
//            formuleEntity2.setNom(faker.food().dish());
//            formuleEntity2.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity2.setImages(imageEntities);
//
//            formuleEntity2.setDescription(faker.lorem().sentence());
//            Boolean isUnique2 = faker.bool().bool();
//            formuleEntity2.setUniquePrix(isUnique2);
//            formuleEntity2.setServiceEntity(makeUpAndHairEntity);
//
//
//            if (!isUnique2) {
//                formuleEntity2.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity2.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupvendredi(faker.number().numberBetween(10,50));
//            }
//            else
//            {   formuleEntity2.setSupDimanche(0);
//                formuleEntity2.setSupVeilleFerier(0);
//                formuleEntity2.setCodePostal(0);
//                formuleEntity2.setSupFerrier(0);
//                formuleEntity2.setSupvendredi(0);}
//            formuleService.save(formuleEntity2);
//
//            List<FormuleEntity> formuleSet = new ArrayList<>();
//            formuleSet.add(formuleEntity);
//            formuleSet.add(formuleEntity2);
//
//
//
//            ImageEntity imageEntity2 = new ImageEntity();
//            imageEntity2.setPhoto(faker.internet().image().getBytes());
//            imageEntity2.setFormule(formuleEntity);
//            imageService.save(imageEntity2);
//
//            ImageEntity imageEntity3 = new ImageEntity();
//            imageEntity3.setPhoto(faker.internet().image().getBytes());
//            imageEntity3.setFormule(formuleEntity2);
//
//            imageService.save(imageEntity3);
//
//            List<ImageEntity> imageEntities = new ArrayList<>();
//            imageEntities.add(imageEntity2);
//            imageEntities.add(imageEntity3);
//
//            /**ADRESSE**/
//            AddressEntity addressEntity1 = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity1.setBox(faker.address().streetAddressNumber());
//            addressEntity1.setCodePostal(faker.number().numberBetween(1000, 2000));
//            addressEntity1.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
//            addressEntity1.setPays("Belgique");
//            addressEntity1.setRue(faker.address().streetName());
//            addressEntity1.setVille(faker.address().cityName());
//            addressService.save(addressEntity1);
//
//
//            /**Person1**/
//            UserEntity personEntity1 = new UserEntity();
//            personEntity1.setNom(faker.name().lastName());
//            personEntity1.setPrenom(faker.name().firstName());
//            personEntity1.setEmail(faker.internet().emailAddress());
//            personEntity1.setLocalisation(addressEntity1);
//            personEntity1.setnTel(Long.parseLong((0 + "" + faker.number().numberBetween(470000000, 490000000))));
//            personEntity1.setSocieteEntity(null);
//            personEntity1.setLogin(faker.name().username());
//            personEntity1.setMdp(faker.internet().password());
//            personEntity1.setRole(Role.CLIENT);
//            userService.save(personEntity1);
//
//
//            /**Reservation**/
//
//            ReservationEntity reservationEntity = new ReservationEntity();
//            reservationEntity.setReservationDate(new java.sql.Date (faker.date().future(100,TimeUnit.DAYS).getTime()));
//            reservationEntity.setServiceEntity(makeUpAndHairEntity);
//            reservationEntity.setTicket(faker.random().hex());
//            reservationEntity.setUserEntity(personEntity1);
//            reservationService.save(reservationEntity);
//
//        }
//
//    }
//
//    /**************************Traiteur******************************/
//
//    private void insertTraiteur(Faker faker) throws Exception {
//
//        for(int i = 0; i < 20; i++) {
//
//            /**ADRESSE**/
//            AddressEntity addressEntity = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity.setBox(faker.address().streetAddressNumber());
//            addressEntity.setCodePostal(faker.number().numberBetween(1000,2000));
//            addressEntity.setNumero(String.valueOf(faker.number().numberBetween(1,200)));
//            addressEntity.setPays("Belgique");
//            addressEntity.setRue(faker.address().streetName());
//            addressEntity.setVille(faker.address().cityName());
//            addressService.save(addressEntity);
//
//            /**Societe**/
//
//            SocieteEntity societeEntity =new SocieteEntity();
//            Long tel =Long.parseLong( 0+""+faker.number().numberBetween(470000000,490000000));
//            societeEntity.setnTVA(Long.parseLong(faker.number().numberBetween(0,1)+""+faker.number().numberBetween(1000000000,999999999)));
//            societeEntity.setEmail(faker.internet().safeEmailAddress());
//            societeEntity.setLocalisation(addressEntity);
//            societeEntity.setnEntreprise(faker.number().numberBetween(30000L,5000L));
//            societeEntity.setNom(faker.company().name());
//            societeEntity.setnTel(tel);
//            societeService.save(societeEntity);
//
//
//            /**Person**/
//
//            UserEntity personEntity = new UserEntity();
//            personEntity.setNom(faker.name().lastName());
//            personEntity.setPrenom(faker.name().firstName());
//            personEntity.setEmail(faker.internet().safeEmailAddress());
//            personEntity.setLocalisation(addressEntity);
//            personEntity.setnTel(tel);
//            personEntity.setSocieteEntity(societeEntity);
//            personEntity.setLogin(faker.name().username());
//            personEntity.setMdp(faker.internet().password());
//            personEntity.setRole(Role.PRESTATAIRE);
//            userService.save(personEntity);
//
//
//            /**Fermeture**/
//            FermetureEntity fermetureEntity = new FermetureEntity();
//            fermetureEntity.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureEntity.setId((long) i);
//            fermetureService.save(fermetureEntity);
//
//            FermetureEntity fermetureEntity2 = new FermetureEntity();
//            fermetureEntity2.setId((long) (50 + i));
//            fermetureEntity2.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity2);
//
//            FermetureEntity fermetureEntity3 = new FermetureEntity();
//            fermetureEntity.setId((long) 100+i);
//            fermetureEntity3.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity3);
//
//            Set<FermetureEntity> fermetureSet = new HashSet<>();
//            fermetureSet.add(fermetureEntity);
//            fermetureSet.add(fermetureEntity2);
//            fermetureSet.add(fermetureEntity3);
//
//            /**Image**/
//
//            ImageEntity imageEntity = new ImageEntity();
//            imageEntity.setPhoto(faker.internet().image().getBytes());
//            imageService.save(imageEntity);
//
//
//
//            /**Traiteur**/
//
//            TraiteurEntity traiteurEntity = new TraiteurEntity();
//            traiteurEntity.setDoFish(faker.bool().bool());
//            traiteurEntity.setDoMeat(faker.bool().bool());
//            traiteurEntity.setDoVegan(faker.bool().bool());
//            traiteurEntity.setDoVegetarian(faker.bool().bool());
//            traiteurEntity.setFermetures(fermetureSet);
////            mediaEntity.setFormuleEntities();
//            traiteurEntity.setImage(imageEntity);
//            traiteurEntity.setNom(faker.food().dish());
//            traiteurEntity.setServiceAdress(addressEntity);
//            traiteurEntity.setSociete(societeEntity);
//            traiteurService.save(traiteurEntity);
//
//
//            /**Formule**/
//
//            FormuleEntity formuleEntity = new FormuleEntity();
//            formuleEntity.setNom(faker.food().dish());
//            formuleEntity.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity.setImages(imageEntities);
//
//            formuleEntity.setDescription(faker.lorem().sentence());
//            Boolean isUnique = faker.bool().bool();
//            formuleEntity.setUniquePrix(isUnique);
//            formuleEntity.setServiceEntity(traiteurEntity);
//
//            if (!isUnique) {
//                formuleEntity.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity.setSupvendredi(faker.number().numberBetween(10,50));
//            }else
//            {   formuleEntity.setSupDimanche(0);
//                formuleEntity.setSupVeilleFerier(0);
//                formuleEntity.setCodePostal(0);
//                formuleEntity.setSupFerrier(0);
//                formuleEntity.setSupvendredi(0);}
//            formuleService.save(formuleEntity);
//
//
//            FormuleEntity formuleEntity2 = new FormuleEntity();
//            formuleEntity2.setNom(faker.food().dish());
//            formuleEntity2.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity2.setImages(imageEntities);
//
//            formuleEntity2.setDescription(faker.lorem().sentence());
//            Boolean isUnique2 = faker.bool().bool();
//            formuleEntity2.setUniquePrix(isUnique2);
//            formuleEntity2.setServiceEntity(traiteurEntity);
//
//
//            if (!isUnique2) {
//                formuleEntity2.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity2.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupvendredi(faker.number().numberBetween(10,50));
//            }
//            else
//            {   formuleEntity2.setSupDimanche(0);
//                formuleEntity2.setSupVeilleFerier(0);
//                formuleEntity2.setCodePostal(0);
//                formuleEntity2.setSupFerrier(0);
//                formuleEntity2.setSupvendredi(0);}
//            formuleService.save(formuleEntity2);
//
//            List<FormuleEntity> formuleSet = new ArrayList<>();
//            formuleSet.add(formuleEntity);
//            formuleSet.add(formuleEntity2);
//
//
//
//            ImageEntity imageEntity2 = new ImageEntity();
//            imageEntity2.setPhoto(faker.internet().image().getBytes());
//            imageEntity2.setFormule(formuleEntity);
//            imageService.save(imageEntity2);
//
//            ImageEntity imageEntity3 = new ImageEntity();
//            imageEntity3.setPhoto(faker.internet().image().getBytes());
//            imageEntity3.setFormule(formuleEntity2);
//
//            imageService.save(imageEntity3);
//
//            List<ImageEntity> imageEntities = new ArrayList<>();
//            imageEntities.add(imageEntity2);
//            imageEntities.add(imageEntity3);
//
//            /**ADRESSE**/
//            AddressEntity addressEntity1 = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity1.setBox(faker.address().streetAddressNumber());
//            addressEntity1.setCodePostal(faker.number().numberBetween(1000, 2000));
//            addressEntity1.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
//            addressEntity1.setPays("Belgique");
//            addressEntity1.setRue(faker.address().streetName());
//            addressEntity1.setVille(faker.address().cityName());
//            addressService.save(addressEntity1);
//
//
//            /**Person1**/
//            UserEntity personEntity1 = new UserEntity();
//            personEntity1.setNom(faker.name().lastName());
//            personEntity1.setPrenom(faker.name().firstName());
//            personEntity1.setEmail(faker.internet().emailAddress());
//            personEntity1.setLocalisation(addressEntity1);
//            personEntity1.setnTel(Long.parseLong((0 + "" + faker.number().numberBetween(470000000, 490000000))));
//            personEntity1.setSocieteEntity(null);
//            personEntity1.setLogin(faker.name().username());
//            personEntity1.setMdp(faker.internet().password());
//            personEntity1.setRole(Role.CLIENT);
//            userService.save(personEntity1);
//
//
//            /**Reservation**/
//
//            ReservationEntity reservationEntity = new ReservationEntity();
//            reservationEntity.setReservationDate(new java.sql.Date (faker.date().future(100,TimeUnit.DAYS).getTime()));
//            reservationEntity.setServiceEntity(traiteurEntity);
//            reservationEntity.setTicket(faker.random().hex());
//            reservationEntity.setUserEntity(personEntity1);
//            reservationService.save(reservationEntity);
//
//
//        }
//    }
//
//    /**************************ServiceTraiteur******************************/
//    private void insertTraiteurService(Faker faker) throws Exception {
//
//        for(int i = 0; i < 20; i++) {
//
//            /**ADRESSE**/
//            AddressEntity addressEntity = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity.setBox(faker.address().streetAddressNumber());
//            addressEntity.setCodePostal(faker.number().numberBetween(1000,2000));
//            addressEntity.setNumero(String.valueOf(faker.number().numberBetween(1,200)));
//            addressEntity.setPays("Belgique");
//            addressEntity.setRue(faker.address().streetName());
//            addressEntity.setVille(faker.address().cityName());
//            addressService.save(addressEntity);
//
//            /**Societe**/
//
//            SocieteEntity societeEntity =new SocieteEntity();
//            Long tel =Long.parseLong( 0+""+faker.number().numberBetween(470000000,490000000));
//            societeEntity.setnTVA(Long.parseLong(faker.number().numberBetween(0,1)+""+faker.number().numberBetween(1000000000,999999999)));
//            societeEntity.setEmail(faker.internet().safeEmailAddress());
//            societeEntity.setLocalisation(addressEntity);
//            societeEntity.setnEntreprise(faker.number().numberBetween(30000L,5000L));
//            societeEntity.setNom(faker.company().name());
//            societeEntity.setnTel(tel);
//            societeService.save(societeEntity);
//
//
//            /**Person**/
//
//            UserEntity personEntity = new UserEntity();
//            personEntity.setNom(faker.name().lastName());
//            personEntity.setPrenom(faker.name().firstName());
//            personEntity.setEmail(faker.internet().safeEmailAddress());
//            personEntity.setLocalisation(addressEntity);
//            personEntity.setnTel(tel);
//            personEntity.setSocieteEntity(societeEntity);
//            personEntity.setLogin(faker.name().username());
//            personEntity.setMdp(faker.internet().password());
//            personEntity.setRole(Role.PRESTATAIRE);
//            userService.save(personEntity);
//
//
//            /**Fermeture**/
//            FermetureEntity fermetureEntity = new FermetureEntity();
//            fermetureEntity.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureEntity.setId((long) i);
//            fermetureService.save(fermetureEntity);
//
//            FermetureEntity fermetureEntity2 = new FermetureEntity();
//            fermetureEntity2.setId((long) (50 + i));
//            fermetureEntity2.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity2);
//
//            FermetureEntity fermetureEntity3 = new FermetureEntity();
//            fermetureEntity.setId((long) 100+i);
//            fermetureEntity3.setDate(new java.sql.Date (faker.date().future(5,TimeUnit.DAYS).getTime()));
//            fermetureService.save(fermetureEntity3);
//
//            Set<FermetureEntity> fermetureSet = new HashSet<>();
//            fermetureSet.add(fermetureEntity);
//            fermetureSet.add(fermetureEntity2);
//            fermetureSet.add(fermetureEntity3);
//
//            /**Image**/
//
//            ImageEntity imageEntity = new ImageEntity();
//            imageEntity.setPhoto(faker.internet().image().getBytes());
//            imageService.save(imageEntity);
//
//
//
//            /**ServiceTraiteur**/
//
//            ServiceTraiteurEntity traiteurEntity = new ServiceTraiteurEntity();
//            traiteurEntity.setWomanOnly(faker.bool().bool());
//            traiteurEntity.setManOnly(faker.bool().bool());
//
//            traiteurEntity.setFermetures(fermetureSet);
////            mediaEntity.setFormuleEntities();
//            traiteurEntity.setImage(imageEntity);
//            traiteurEntity.setNom(faker.food().dish());
//            traiteurEntity.setServiceAdress(addressEntity);
//            traiteurEntity.setSociete(societeEntity);
//            serviceTraiteurService.save(traiteurEntity);
//
//
//            /**Formule**/
//
//            FormuleEntity formuleEntity = new FormuleEntity();
//            formuleEntity.setNom(faker.food().dish());
//            formuleEntity.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity.setImages(imageEntities);
//
//            formuleEntity.setDescription(faker.lorem().sentence());
//            Boolean isUnique = faker.bool().bool();
//            formuleEntity.setUniquePrix(isUnique);
//            formuleEntity.setServiceEntity(traiteurEntity);
//
//            if (!isUnique) {
//                formuleEntity.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity.setSupvendredi(faker.number().numberBetween(10,50));
//            }else
//            {   formuleEntity.setSupDimanche(0);
//                formuleEntity.setSupVeilleFerier(0);
//                formuleEntity.setCodePostal(0);
//                formuleEntity.setSupFerrier(0);
//                formuleEntity.setSupvendredi(0);}
//            formuleService.save(formuleEntity);
//
//
//            FormuleEntity formuleEntity2 = new FormuleEntity();
//            formuleEntity2.setNom(faker.food().dish());
//            formuleEntity2.setPrix(faker.number().numberBetween(50,150));
////            formuleEntity2.setImages(imageEntities);
//
//            formuleEntity2.setDescription(faker.lorem().sentence());
//            Boolean isUnique2 = faker.bool().bool();
//            formuleEntity2.setUniquePrix(isUnique2);
//            formuleEntity2.setServiceEntity(traiteurEntity);
//
//
//            if (!isUnique2) {
//                formuleEntity2.setSupDimanche(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupVeilleFerier(faker.number().numberBetween(10,50));
//                formuleEntity2.setCodePostal(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupFerrier(faker.number().numberBetween(10,50));
//                formuleEntity2.setSupvendredi(faker.number().numberBetween(10,50));
//            }
//            else
//            {   formuleEntity2.setSupDimanche(0);
//                formuleEntity2.setSupVeilleFerier(0);
//                formuleEntity2.setCodePostal(0);
//                formuleEntity2.setSupFerrier(0);
//                formuleEntity2.setSupvendredi(0);}
//            formuleService.save(formuleEntity2);
//
//            List<FormuleEntity> formuleSet = new ArrayList<>();
//            formuleSet.add(formuleEntity);
//            formuleSet.add(formuleEntity2);
//
//
//
//            ImageEntity imageEntity2 = new ImageEntity();
//            imageEntity2.setPhoto(faker.internet().image().getBytes());
//            imageEntity2.setFormule(formuleEntity);
//            imageService.save(imageEntity2);
//
//            ImageEntity imageEntity3 = new ImageEntity();
//            imageEntity3.setPhoto(faker.internet().image().getBytes());
//            imageEntity3.setFormule(formuleEntity2);
//
//            imageService.save(imageEntity3);
//
//            List<ImageEntity> imageEntities = new ArrayList<>();
//            imageEntities.add(imageEntity2);
//            imageEntities.add(imageEntity3);
//
//
//
//            /**ADRESSE**/
//            AddressEntity addressEntity1 = new AddressEntity();
////        addressEntity.setAdressID(1L);
//
//            addressEntity1.setBox(faker.address().streetAddressNumber());
//            addressEntity1.setCodePostal(faker.number().numberBetween(1000, 2000));
//            addressEntity1.setNumero(String.valueOf(faker.number().numberBetween(1, 200)));
//            addressEntity1.setPays("Belgique");
//            addressEntity1.setRue(faker.address().streetName());
//            addressEntity1.setVille(faker.address().cityName());
//            addressService.save(addressEntity1);
//
//
//            /**Person1**/
//            UserEntity personEntity1 = new UserEntity();
//            personEntity1.setNom(faker.name().lastName());
//            personEntity1.setPrenom(faker.name().firstName());
//            personEntity1.setEmail(faker.internet().emailAddress());
//            personEntity1.setLocalisation(addressEntity1);
//            personEntity1.setnTel(Long.parseLong((0 + "" + faker.number().numberBetween(470000000, 490000000))));
//            personEntity1.setSocieteEntity(null);
//            personEntity1.setLogin(faker.name().username());
//            personEntity1.setMdp(faker.internet().password());
//            personEntity1.setRole(Role.CLIENT);
//            userService.save(personEntity1);
//
//
//            /**Reservation**/
//
//            ReservationEntity reservationEntity = new ReservationEntity();
//            reservationEntity.setReservationDate(new java.sql.Date (faker.date().future(100,TimeUnit.DAYS).getTime()));
//            reservationEntity.setServiceEntity(traiteurEntity);
//            reservationEntity.setTicket(faker.random().hex());
//            reservationEntity.setUserEntity(personEntity1);
//            reservationService.save(reservationEntity);
//        }
//    }
//

//}
