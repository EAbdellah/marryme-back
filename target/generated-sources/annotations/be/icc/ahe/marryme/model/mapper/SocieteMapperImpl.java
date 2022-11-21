package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Image;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.Societe;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-21T04:35:39+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class SocieteMapperImpl implements SocieteMapper {

    @Override
    public Societe entityToModel(SocieteEntity societeEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Societe target = cycleAvoidingMappingContext.getMappedInstance( societeEntity, Societe.class );
        if ( target != null ) {
            return target;
        }

        if ( societeEntity == null ) {
            return null;
        }

        Societe societe = new Societe();

        cycleAvoidingMappingContext.storeMappedInstance( societeEntity, societe );

        societe.setOwner( personEntityToPerson( societeEntity.getOwner(), cycleAvoidingMappingContext ) );
        societe.setSocieteID( societeEntity.getSocieteID() );
        societe.setNTVA( societeEntity.getNTVA() );
        societe.setNEntreprise( societeEntity.getNEntreprise() );
        societe.setNom( societeEntity.getNom() );
        societe.setEmail( societeEntity.getEmail() );
        societe.setNTel( societeEntity.getNTel() );
        societe.setLocalisation( addressEntityToAddress( societeEntity.getLocalisation(), cycleAvoidingMappingContext ) );
        societe.setService( map( societeEntity.getService() ) );
        societe.setDecisionRegistration( societeEntity.getDecisionRegistration() );

        return societe;
    }

    @Override
    public SocieteEntity modelToEntity(Societe societe, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        SocieteEntity target = cycleAvoidingMappingContext.getMappedInstance( societe, SocieteEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( societe == null ) {
            return null;
        }

        SocieteEntity societeEntity = new SocieteEntity();

        cycleAvoidingMappingContext.storeMappedInstance( societe, societeEntity );

        societeEntity.setOwner( personToPersonEntity( societe.getOwner(), cycleAvoidingMappingContext ) );
        societeEntity.setSocieteID( societe.getSocieteID() );
        societeEntity.setNTVA( societe.getNTVA() );
        societeEntity.setNEntreprise( societe.getNEntreprise() );
        societeEntity.setNom( societe.getNom() );
        societeEntity.setEmail( societe.getEmail() );
        societeEntity.setNTel( societe.getNTel() );
        societeEntity.setLocalisation( addressToAddressEntity( societe.getLocalisation(), cycleAvoidingMappingContext ) );
        societeEntity.setService( map( societe.getService() ) );
        societeEntity.setDecisionRegistration( societe.getDecisionRegistration() );

        return societeEntity;
    }

    @Override
    public Societe RegistrationProviderDtoToModel(ProviderRegisterFormDTO providerRegisterFormDTO) {
        if ( providerRegisterFormDTO == null ) {
            return null;
        }

        Societe societe = new Societe();

        societe.setNom( providerRegisterFormDTO.getName() );
        if ( providerRegisterFormDTO.getN_entreprise() != null ) {
            societe.setNEntreprise( Long.parseLong( providerRegisterFormDTO.getN_entreprise() ) );
        }
        societe.setNTVA( providerRegisterFormDTO.getN_tva() );
        if ( providerRegisterFormDTO.getEntreprise_phone() != null ) {
            societe.setNTel( Long.parseLong( providerRegisterFormDTO.getEntreprise_phone() ) );
        }
        societe.setEmail( providerRegisterFormDTO.getEmail_entreprise() );

        return societe;
    }

    protected Image imageEntityToImage(ImageEntity imageEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Image target = cycleAvoidingMappingContext.getMappedInstance( imageEntity, Image.class );
        if ( target != null ) {
            return target;
        }

        if ( imageEntity == null ) {
            return null;
        }

        Image image = new Image();

        cycleAvoidingMappingContext.storeMappedInstance( imageEntity, image );

        image.setImageID( imageEntity.getImageID() );
        byte[] photo = imageEntity.getPhoto();
        if ( photo != null ) {
            image.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }
        image.setFormule( formuleEntityToFormule( imageEntity.getFormule(), cycleAvoidingMappingContext ) );

        return image;
    }

    protected List<Image> imageEntityListToImageList(List<ImageEntity> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<Image> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<Image> list1 = new ArrayList<Image>( list.size() );
        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );

        for ( ImageEntity imageEntity : list ) {
            list1.add( imageEntityToImage( imageEntity, cycleAvoidingMappingContext ) );
        }

        return list1;
    }

    protected List<Reservation> reservationEntityListToReservationList(List<ReservationEntity> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<Reservation> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<Reservation> list1 = new ArrayList<Reservation>( list.size() );
        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );

        for ( ReservationEntity reservationEntity : list ) {
            list1.add( reservationEntityToReservation( reservationEntity, cycleAvoidingMappingContext ) );
        }

        return list1;
    }

    protected Formule formuleEntityToFormule(FormuleEntity formuleEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Formule target = cycleAvoidingMappingContext.getMappedInstance( formuleEntity, Formule.class );
        if ( target != null ) {
            return target;
        }

        if ( formuleEntity == null ) {
            return null;
        }

        Formule formule = new Formule();

        cycleAvoidingMappingContext.storeMappedInstance( formuleEntity, formule );

        formule.setFormuleID( formuleEntity.getFormuleID() );
        formule.setNom( formuleEntity.getNom() );
        formule.setPrix( formuleEntity.getPrix() );
        formule.setDescription( formuleEntity.getDescription() );
        formule.setIsUniquePrix( formuleEntity.getIsUniquePrix() );
        formule.setSupFerrier( formuleEntity.getSupFerrier() );
        formule.setSupvendredi( formuleEntity.getSupvendredi() );
        formule.setSupDimanche( formuleEntity.getSupDimanche() );
        formule.setSupSamedi( formuleEntity.getSupSamedi() );
        formule.setSupVeilleFerier( formuleEntity.getSupVeilleFerier() );
        formule.setImages( imageEntityListToImageList( formuleEntity.getImages(), cycleAvoidingMappingContext ) );
        formule.setReservation( reservationEntityListToReservationList( formuleEntity.getReservation(), cycleAvoidingMappingContext ) );
        formule.setActive( formuleEntity.isActive() );

        return formule;
    }

    protected Reservation reservationEntityToReservation(ReservationEntity reservationEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Reservation target = cycleAvoidingMappingContext.getMappedInstance( reservationEntity, Reservation.class );
        if ( target != null ) {
            return target;
        }

        if ( reservationEntity == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        cycleAvoidingMappingContext.storeMappedInstance( reservationEntity, reservation );

        reservation.setReservationID( reservationEntity.getReservationID() );
        reservation.setReservationDate( reservationEntity.getReservationDate() );
        reservation.setTicket( reservationEntity.getTicket() );
        reservation.setUser( userEntityToUser( reservationEntity.getUser(), cycleAvoidingMappingContext ) );
        reservation.setFormule( formuleEntityToFormule( reservationEntity.getFormule(), cycleAvoidingMappingContext ) );
        reservation.setPrice( reservationEntity.getPrice() );
        reservation.setStatus( reservationEntity.getStatus() );
        reservation.setPayementId( reservationEntity.getPayementId() );
        reservation.setToken( reservationEntity.getToken() );
        reservation.setContract( reservationEntity.getContract() );
        reservation.setInceptionDate( reservationEntity.getInceptionDate() );

        return reservation;
    }

    protected User userEntityToUser(UserEntity userEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        User target = cycleAvoidingMappingContext.getMappedInstance( userEntity, User.class );
        if ( target != null ) {
            return target;
        }

        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        cycleAvoidingMappingContext.storeMappedInstance( userEntity, user );

        user.setUserID( userEntity.getUserID() );
        user.setPassword( userEntity.getPassword() );
        user.setEmail( userEntity.getEmail() );
        user.setRole( userEntity.getRole() );
        user.setActive( userEntity.isActive() );
        user.setNotLocked( userEntity.isNotLocked() );
        String[] authorities = userEntity.getAuthorities();
        if ( authorities != null ) {
            user.setAuthorities( Arrays.copyOf( authorities, authorities.length ) );
        }
        user.setReservations( reservationEntityListToReservationList( userEntity.getReservations(), cycleAvoidingMappingContext ) );
        user.setProfileImageUrl( userEntity.getProfileImageUrl() );
        user.setLastLoginDate( userEntity.getLastLoginDate() );
        user.setLastLoginDateDisplay( userEntity.getLastLoginDateDisplay() );
        user.setJoinDate( userEntity.getJoinDate() );

        return user;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Address target = cycleAvoidingMappingContext.getMappedInstance( addressEntity, Address.class );
        if ( target != null ) {
            return target;
        }

        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        cycleAvoidingMappingContext.storeMappedInstance( addressEntity, address );

        address.setAdressID( addressEntity.getAdressID() );
        address.setPays( addressEntity.getPays() );
        address.setVille( addressEntity.getVille() );
        address.setCodePostal( addressEntity.getCodePostal() );
        address.setRue( addressEntity.getRue() );
        address.setNumero( addressEntity.getNumero() );
        address.setBox( addressEntity.getBox() );

        return address;
    }

    protected Person personEntityToPerson(PersonEntity personEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Person target = cycleAvoidingMappingContext.getMappedInstance( personEntity, Person.class );
        if ( target != null ) {
            return target;
        }

        if ( personEntity == null ) {
            return null;
        }

        Person person = new Person();

        cycleAvoidingMappingContext.storeMappedInstance( personEntity, person );

        person.setUser( userEntityToUser( personEntity.getUserEntity(), cycleAvoidingMappingContext ) );
        person.setPersonID( personEntity.getPersonID() );
        person.setFirstName( personEntity.getFirstName() );
        person.setLastName( personEntity.getLastName() );
        person.setPhoneNbr( personEntity.getPhoneNbr() );
        person.setLocalisation( addressEntityToAddress( personEntity.getLocalisation(), cycleAvoidingMappingContext ) );

        return person;
    }

    protected ImageEntity imageToImageEntity(Image image, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        ImageEntity target = cycleAvoidingMappingContext.getMappedInstance( image, ImageEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( image == null ) {
            return null;
        }

        ImageEntity imageEntity = new ImageEntity();

        cycleAvoidingMappingContext.storeMappedInstance( image, imageEntity );

        imageEntity.setImageID( image.getImageID() );
        byte[] photo = image.getPhoto();
        if ( photo != null ) {
            imageEntity.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }
        imageEntity.setFormule( formuleToFormuleEntity( image.getFormule(), cycleAvoidingMappingContext ) );

        return imageEntity;
    }

    protected List<ImageEntity> imageListToImageEntityList(List<Image> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<ImageEntity> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<ImageEntity> list1 = new ArrayList<ImageEntity>( list.size() );
        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );

        for ( Image image : list ) {
            list1.add( imageToImageEntity( image, cycleAvoidingMappingContext ) );
        }

        return list1;
    }

    protected List<ReservationEntity> reservationListToReservationEntityList(List<Reservation> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<ReservationEntity> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<ReservationEntity> list1 = new ArrayList<ReservationEntity>( list.size() );
        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );

        for ( Reservation reservation : list ) {
            list1.add( reservationToReservationEntity( reservation, cycleAvoidingMappingContext ) );
        }

        return list1;
    }

    protected FormuleEntity formuleToFormuleEntity(Formule formule, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        FormuleEntity target = cycleAvoidingMappingContext.getMappedInstance( formule, FormuleEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( formule == null ) {
            return null;
        }

        FormuleEntity formuleEntity = new FormuleEntity();

        cycleAvoidingMappingContext.storeMappedInstance( formule, formuleEntity );

        formuleEntity.setFormuleID( formule.getFormuleID() );
        formuleEntity.setNom( formule.getNom() );
        formuleEntity.setPrix( formule.getPrix() );
        formuleEntity.setDescription( formule.getDescription() );
        formuleEntity.setIsUniquePrix( formule.getIsUniquePrix() );
        formuleEntity.setSupFerrier( formule.getSupFerrier() );
        formuleEntity.setSupvendredi( formule.getSupvendredi() );
        formuleEntity.setSupSamedi( formule.getSupSamedi() );
        formuleEntity.setSupDimanche( formule.getSupDimanche() );
        formuleEntity.setSupVeilleFerier( formule.getSupVeilleFerier() );
        formuleEntity.setActive( formule.isActive() );
        formuleEntity.setImages( imageListToImageEntityList( formule.getImages(), cycleAvoidingMappingContext ) );
        formuleEntity.setReservation( reservationListToReservationEntityList( formule.getReservation(), cycleAvoidingMappingContext ) );

        return formuleEntity;
    }

    protected ReservationEntity reservationToReservationEntity(Reservation reservation, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        ReservationEntity target = cycleAvoidingMappingContext.getMappedInstance( reservation, ReservationEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( reservation == null ) {
            return null;
        }

        ReservationEntity reservationEntity = new ReservationEntity();

        cycleAvoidingMappingContext.storeMappedInstance( reservation, reservationEntity );

        reservationEntity.setReservationID( reservation.getReservationID() );
        reservationEntity.setReservationDate( reservation.getReservationDate() );
        reservationEntity.setTicket( reservation.getTicket() );
        reservationEntity.setUser( userToUserEntity( reservation.getUser(), cycleAvoidingMappingContext ) );
        reservationEntity.setFormule( formuleToFormuleEntity( reservation.getFormule(), cycleAvoidingMappingContext ) );
        reservationEntity.setPrice( reservation.getPrice() );
        reservationEntity.setStatus( reservation.getStatus() );
        reservationEntity.setPayementId( reservation.getPayementId() );
        reservationEntity.setToken( reservation.getToken() );
        reservationEntity.setContract( reservation.getContract() );
        reservationEntity.setInceptionDate( reservation.getInceptionDate() );

        return reservationEntity;
    }

    protected UserEntity userToUserEntity(User user, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        UserEntity target = cycleAvoidingMappingContext.getMappedInstance( user, UserEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        cycleAvoidingMappingContext.storeMappedInstance( user, userEntity );

        userEntity.setUserID( user.getUserID() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setRole( user.getRole() );
        String[] authorities = user.getAuthorities();
        if ( authorities != null ) {
            userEntity.setAuthorities( Arrays.copyOf( authorities, authorities.length ) );
        }
        userEntity.setActive( user.isActive() );
        userEntity.setNotLocked( user.isNotLocked() );
        userEntity.setReservations( reservationListToReservationEntityList( user.getReservations(), cycleAvoidingMappingContext ) );
        userEntity.setProfileImageUrl( user.getProfileImageUrl() );
        userEntity.setLastLoginDate( user.getLastLoginDate() );
        userEntity.setLastLoginDateDisplay( user.getLastLoginDateDisplay() );
        userEntity.setJoinDate( user.getJoinDate() );

        return userEntity;
    }

    protected AddressEntity addressToAddressEntity(Address address, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        AddressEntity target = cycleAvoidingMappingContext.getMappedInstance( address, AddressEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        cycleAvoidingMappingContext.storeMappedInstance( address, addressEntity );

        addressEntity.setAdressID( address.getAdressID() );
        addressEntity.setPays( address.getPays() );
        addressEntity.setVille( address.getVille() );
        addressEntity.setCodePostal( address.getCodePostal() );
        addressEntity.setRue( address.getRue() );
        addressEntity.setNumero( address.getNumero() );
        addressEntity.setBox( address.getBox() );

        return addressEntity;
    }

    protected PersonEntity personToPersonEntity(Person person, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        PersonEntity target = cycleAvoidingMappingContext.getMappedInstance( person, PersonEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( person == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        cycleAvoidingMappingContext.storeMappedInstance( person, personEntity );

        personEntity.setUserEntity( userToUserEntity( person.getUser(), cycleAvoidingMappingContext ) );
        personEntity.setPersonID( person.getPersonID() );
        personEntity.setFirstName( person.getFirstName() );
        personEntity.setLastName( person.getLastName() );
        personEntity.setPhoneNbr( person.getPhoneNbr() );
        personEntity.setLocalisation( addressToAddressEntity( person.getLocalisation(), cycleAvoidingMappingContext ) );

        return personEntity;
    }
}
