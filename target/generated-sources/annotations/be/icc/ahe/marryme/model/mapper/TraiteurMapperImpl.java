package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Image;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.Traiteur;
import be.icc.ahe.marryme.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-08T02:38:10+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class TraiteurMapperImpl implements TraiteurMapper {

    @Override
    public Traiteur entityToModel(TraiteurEntity traiteurEntity) {
        if ( traiteurEntity == null ) {
            return null;
        }

        Traiteur traiteur = new Traiteur();

        traiteur.setServiceID( traiteurEntity.getServiceID() );
        traiteur.setNom( traiteurEntity.getNom() );
        traiteur.setAddress( addressEntityToAddress( traiteurEntity.getAddress() ) );
        traiteur.setFormules( formuleEntityListToFormuleList( traiteurEntity.getFormules() ) );
        traiteur.setFermetures( fermetureEntityCollectionToFermetureCollection( traiteurEntity.getFermetures() ) );
        traiteur.setImage( imageEntityToImage( traiteurEntity.getImage() ) );
        traiteur.setDoMeat( traiteurEntity.getDoMeat() );
        traiteur.setDoFish( traiteurEntity.getDoFish() );
        traiteur.setDoVegan( traiteurEntity.getDoVegan() );
        traiteur.setDoVegetarian( traiteurEntity.getDoVegetarian() );

        return traiteur;
    }

    @Override
    public TraiteurEntity modelToEntity(Traiteur traiteur) {
        if ( traiteur == null ) {
            return null;
        }

        TraiteurEntity traiteurEntity = new TraiteurEntity();

        traiteurEntity.setServiceID( traiteur.getServiceID() );
        traiteurEntity.setNom( traiteur.getNom() );
        traiteurEntity.setAddress( addressToAddressEntity( traiteur.getAddress() ) );
        traiteurEntity.setFormules( formuleListToFormuleEntityList( traiteur.getFormules() ) );
        traiteurEntity.setFermetures( fermetureCollectionToFermetureEntityCollection( traiteur.getFermetures() ) );
        traiteurEntity.setImage( imageToImageEntity( traiteur.getImage() ) );
        traiteurEntity.setDoMeat( traiteur.getDoMeat() );
        traiteurEntity.setDoFish( traiteur.getDoFish() );
        traiteurEntity.setDoVegan( traiteur.getDoVegan() );
        traiteurEntity.setDoVegetarian( traiteur.getDoVegetarian() );

        return traiteurEntity;
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

        return formule;
    }

    protected List<Formule> formuleEntityListToFormuleList(List<FormuleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Formule> list1 = new ArrayList<Formule>( list.size() );
        for ( FormuleEntity formuleEntity : list ) {
            list1.add( formuleEntityToFormule( formuleEntity ) );
        }

        return list1;
    }

    protected Fermeture fermetureEntityToFermeture(FermetureEntity fermetureEntity) {
        if ( fermetureEntity == null ) {
            return null;
        }

        Fermeture fermeture = new Fermeture();

        fermeture.setId( fermetureEntity.getId() );
        fermeture.setDate( fermetureEntity.getDate() );

        return fermeture;
    }

    protected Collection<Fermeture> fermetureEntityCollectionToFermetureCollection(Collection<FermetureEntity> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<Fermeture> collection1 = new ArrayList<Fermeture>( collection.size() );
        for ( FermetureEntity fermetureEntity : collection ) {
            collection1.add( fermetureEntityToFermeture( fermetureEntity ) );
        }

        return collection1;
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
        formuleEntity.setImages( imageListToImageEntityList( formule.getImages() ) );
        formuleEntity.setReservation( reservationListToReservationEntityList( formule.getReservation() ) );

        return formuleEntity;
    }

    protected List<FormuleEntity> formuleListToFormuleEntityList(List<Formule> list) {
        if ( list == null ) {
            return null;
        }

        List<FormuleEntity> list1 = new ArrayList<FormuleEntity>( list.size() );
        for ( Formule formule : list ) {
            list1.add( formuleToFormuleEntity( formule ) );
        }

        return list1;
    }

    protected FermetureEntity fermetureToFermetureEntity(Fermeture fermeture) {
        if ( fermeture == null ) {
            return null;
        }

        FermetureEntity fermetureEntity = new FermetureEntity();

        fermetureEntity.setId( fermeture.getId() );
        fermetureEntity.setDate( fermeture.getDate() );

        return fermetureEntity;
    }

    protected Collection<FermetureEntity> fermetureCollectionToFermetureEntityCollection(Collection<Fermeture> collection) {
        if ( collection == null ) {
            return null;
        }

        Collection<FermetureEntity> collection1 = new ArrayList<FermetureEntity>( collection.size() );
        for ( Fermeture fermeture : collection ) {
            collection1.add( fermetureToFermetureEntity( fermeture ) );
        }

        return collection1;
    }
}
