package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Image;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-23T14:26:08+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity modelToEntity(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setUserEntity( userToUserEntity( person.getUser() ) );
        personEntity.setPersonID( person.getPersonID() );
        personEntity.setFirstName( person.getFirstName() );
        personEntity.setLastName( person.getLastName() );
        personEntity.setPhoneNbr( person.getPhoneNbr() );
        personEntity.setLocalisation( addressToAddressEntity( person.getLocalisation() ) );

        return personEntity;
    }

    @Override
    public Person entityToModel(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        Person person = new Person();

        person.setUser( userEntityToUser( personEntity.getUserEntity() ) );
        person.setPersonID( personEntity.getPersonID() );
        person.setFirstName( personEntity.getFirstName() );
        person.setLastName( personEntity.getLastName() );
        person.setPhoneNbr( personEntity.getPhoneNbr() );
        person.setLocalisation( addressEntityToAddress( personEntity.getLocalisation() ) );

        return person;
    }

    @Override
    public Person RegistrationProviderDtoToModel(ProviderRegisterFormDTO providerRegisterFormDTO) {
        if ( providerRegisterFormDTO == null ) {
            return null;
        }

        Person person = new Person();

        if ( providerRegisterFormDTO.getPhone() != null ) {
            person.setPhoneNbr( Long.parseLong( providerRegisterFormDTO.getPhone() ) );
        }
        person.setFirstName( providerRegisterFormDTO.getFirstName() );
        person.setLastName( providerRegisterFormDTO.getLastName() );

        return person;
    }

    protected ImageEntity imageToImageEntity(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageEntity imageEntity = new ImageEntity();

        imageEntity.setImageID( image.getImageID() );
        byte[] photo = image.getPhoto();
        if ( photo != null ) {
            imageEntity.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }
        imageEntity.setFormule( formuleToFormuleEntity( image.getFormule() ) );

        return imageEntity;
    }

    protected List<ImageEntity> imageListToImageEntityList(List<Image> list) {
        if ( list == null ) {
            return null;
        }

        List<ImageEntity> list1 = new ArrayList<ImageEntity>( list.size() );
        for ( Image image : list ) {
            list1.add( imageToImageEntity( image ) );
        }

        return list1;
    }

    protected List<ReservationEntity> reservationListToReservationEntityList(List<Reservation> list) {
        if ( list == null ) {
            return null;
        }

        List<ReservationEntity> list1 = new ArrayList<ReservationEntity>( list.size() );
        for ( Reservation reservation : list ) {
            list1.add( reservationToReservationEntity( reservation ) );
        }

        return list1;
    }

    protected FormuleEntity formuleToFormuleEntity(Formule formule) {
        if ( formule == null ) {
            return null;
        }

        FormuleEntity formuleEntity = new FormuleEntity();

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
        formuleEntity.setImages( imageListToImageEntityList( formule.getImages() ) );
        formuleEntity.setReservation( reservationListToReservationEntityList( formule.getReservation() ) );

        return formuleEntity;
    }

    protected ReservationEntity reservationToReservationEntity(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationEntity reservationEntity = new ReservationEntity();

        reservationEntity.setReservationID( reservation.getReservationID() );
        reservationEntity.setReservationDate( reservation.getReservationDate() );
        reservationEntity.setTicket( reservation.getTicket() );
        reservationEntity.setUser( userToUserEntity( reservation.getUser() ) );
        reservationEntity.setFormule( formuleToFormuleEntity( reservation.getFormule() ) );
        reservationEntity.setPrice( reservation.getPrice() );
        reservationEntity.setStatus( reservation.getStatus() );
        reservationEntity.setPayementId( reservation.getPayementId() );
        reservationEntity.setToken( reservation.getToken() );
        reservationEntity.setContract( reservation.getContract() );
        reservationEntity.setInceptionDate( reservation.getInceptionDate() );

        return reservationEntity;
    }

    protected UserEntity userToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

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
        userEntity.setReservations( reservationListToReservationEntityList( user.getReservations() ) );
        userEntity.setProfileImageUrl( user.getProfileImageUrl() );
        userEntity.setLastLoginDate( user.getLastLoginDate() );
        userEntity.setLastLoginDateDisplay( user.getLastLoginDateDisplay() );
        userEntity.setJoinDate( user.getJoinDate() );

        return userEntity;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setAdressID( address.getAdressID() );
        addressEntity.setPays( address.getPays() );
        addressEntity.setVille( address.getVille() );
        addressEntity.setCodePostal( address.getCodePostal() );
        addressEntity.setRue( address.getRue() );
        addressEntity.setNumero( address.getNumero() );
        addressEntity.setBox( address.getBox() );

        return addressEntity;
    }

    protected Image imageEntityToImage(ImageEntity imageEntity) {
        if ( imageEntity == null ) {
            return null;
        }

        Image image = new Image();

        image.setImageID( imageEntity.getImageID() );
        byte[] photo = imageEntity.getPhoto();
        if ( photo != null ) {
            image.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }
        image.setFormule( formuleEntityToFormule( imageEntity.getFormule() ) );

        return image;
    }

    protected List<Image> imageEntityListToImageList(List<ImageEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Image> list1 = new ArrayList<Image>( list.size() );
        for ( ImageEntity imageEntity : list ) {
            list1.add( imageEntityToImage( imageEntity ) );
        }

        return list1;
    }

    protected List<Reservation> reservationEntityListToReservationList(List<ReservationEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Reservation> list1 = new ArrayList<Reservation>( list.size() );
        for ( ReservationEntity reservationEntity : list ) {
            list1.add( reservationEntityToReservation( reservationEntity ) );
        }

        return list1;
    }

    protected Formule formuleEntityToFormule(FormuleEntity formuleEntity) {
        if ( formuleEntity == null ) {
            return null;
        }

        Formule formule = new Formule();

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
        formule.setImages( imageEntityListToImageList( formuleEntity.getImages() ) );
        formule.setReservation( reservationEntityListToReservationList( formuleEntity.getReservation() ) );
        formule.setActive( formuleEntity.isActive() );

        return formule;
    }

    protected Reservation reservationEntityToReservation(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setReservationID( reservationEntity.getReservationID() );
        reservation.setReservationDate( reservationEntity.getReservationDate() );
        reservation.setTicket( reservationEntity.getTicket() );
        reservation.setUser( userEntityToUser( reservationEntity.getUser() ) );
        reservation.setFormule( formuleEntityToFormule( reservationEntity.getFormule() ) );
        reservation.setPrice( reservationEntity.getPrice() );
        reservation.setStatus( reservationEntity.getStatus() );
        reservation.setPayementId( reservationEntity.getPayementId() );
        reservation.setToken( reservationEntity.getToken() );
        reservation.setContract( reservationEntity.getContract() );
        reservation.setInceptionDate( reservationEntity.getInceptionDate() );

        return reservation;
    }

    protected User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

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
        user.setReservations( reservationEntityListToReservationList( userEntity.getReservations() ) );
        user.setProfileImageUrl( userEntity.getProfileImageUrl() );
        user.setLastLoginDate( userEntity.getLastLoginDate() );
        user.setLastLoginDateDisplay( userEntity.getLastLoginDateDisplay() );
        user.setJoinDate( userEntity.getJoinDate() );

        return user;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setAdressID( addressEntity.getAdressID() );
        address.setPays( addressEntity.getPays() );
        address.setVille( addressEntity.getVille() );
        address.setCodePostal( addressEntity.getCodePostal() );
        address.setRue( addressEntity.getRue() );
        address.setNumero( addressEntity.getNumero() );
        address.setBox( addressEntity.getBox() );

        return address;
    }
}
