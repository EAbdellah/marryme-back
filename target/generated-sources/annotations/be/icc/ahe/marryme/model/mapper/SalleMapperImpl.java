package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.HallType;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Image;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.Salle;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T03:32:04+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class SalleMapperImpl implements SalleMapper {

    @Override
    public Salle entityToModel(SalleEntity salleEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Salle target = cycleAvoidingMappingContext.getMappedInstance( salleEntity, Salle.class );
        if ( target != null ) {
            return target;
        }

        if ( salleEntity == null ) {
            return null;
        }

        Salle salle = new Salle();

        cycleAvoidingMappingContext.storeMappedInstance( salleEntity, salle );

        salle.setServiceID( salleEntity.getServiceID() );
        salle.setNom( salleEntity.getNom() );
        salle.setAddress( addressEntityToAddress( salleEntity.getAddress(), cycleAvoidingMappingContext ) );
        salle.setFormules( formuleEntityListToFormuleList( salleEntity.getFormules(), cycleAvoidingMappingContext ) );
        salle.setFermetures( fermetureEntityCollectionToFermetureCollection( salleEntity.getFermetures(), cycleAvoidingMappingContext ) );
        salle.setImage( imageEntityToImage( salleEntity.getImage(), cycleAvoidingMappingContext ) );
        salle.setCapaciteTotal( salleEntity.getCapaciteTotal() );
        salle.setPlaceAssise( salleEntity.getPlaceAssise() );
        salle.setPisteDance( salleEntity.getPisteDance() );
        salle.setDecoration( salleEntity.getDecoration() );
        salle.setMaterielMusique( salleEntity.getMaterielMusique() );
        salle.setTraiteur( salleEntity.getTraiteur() );
        salle.setCuisine( salleEntity.getCuisine() );
        salle.setIsExternal( salleEntity.getIsExternal() );
        salle.setHallTypeEntity( salleEntity.getHallTypeEntity() );
        salle.setHaveParking( salleEntity.getHaveParking() );

        return salle;
    }

    @Override
    public SalleEntity modelToEntity(Salle salle, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        SalleEntity target = cycleAvoidingMappingContext.getMappedInstance( salle, SalleEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( salle == null ) {
            return null;
        }

        SalleEntity salleEntity = new SalleEntity();

        cycleAvoidingMappingContext.storeMappedInstance( salle, salleEntity );

        salleEntity.setServiceID( salle.getServiceID() );
        salleEntity.setNom( salle.getNom() );
        salleEntity.setAddress( addressToAddressEntity( salle.getAddress(), cycleAvoidingMappingContext ) );
        salleEntity.setFormules( formuleListToFormuleEntityList( salle.getFormules(), cycleAvoidingMappingContext ) );
        salleEntity.setFermetures( fermetureCollectionToFermetureEntityCollection( salle.getFermetures(), cycleAvoidingMappingContext ) );
        salleEntity.setImage( imageToImageEntity( salle.getImage(), cycleAvoidingMappingContext ) );
        salleEntity.setCapaciteTotal( salle.getCapaciteTotal() );
        salleEntity.setPlaceAssise( salle.getPlaceAssise() );
        salleEntity.setPisteDance( salle.getPisteDance() );
        salleEntity.setDecoration( salle.getDecoration() );
        salleEntity.setMaterielMusique( salle.getMaterielMusique() );
        salleEntity.setTraiteur( salle.getTraiteur() );
        salleEntity.setCuisine( salle.getCuisine() );
        salleEntity.setIsExternal( salle.getIsExternal() );
        salleEntity.setHallTypeEntity( salle.getHallTypeEntity() );
        salleEntity.setHaveParking( salle.getHaveParking() );

        return salleEntity;
    }

    @Override
    public Salle dtoToModel(GetShortSalleServiceDTO form) {
        if ( form == null ) {
            return null;
        }

        Salle salle = new Salle();

        salle.setServiceID( form.getService_id() );
        salle.setCapaciteTotal( form.getCapacite_total() );
        if ( form.getHall_type() != null ) {
            salle.setHallTypeEntity( Enum.valueOf( HallType.class, form.getHall_type() ) );
        }
        salle.setIsExternal( form.getIs_external() );
        salle.setPisteDance( form.getPiste_dance() );
        salle.setPlaceAssise( form.getPlace_assise() );
        salle.setHaveParking( form.getHave_parking() );
        salle.setMaterielMusique( form.getMateriel_musique() );
        salle.setNom( form.getNom() );
        salle.setDecoration( form.getDecoration() );
        salle.setTraiteur( form.getTraiteur() );
        salle.setCuisine( form.getCuisine() );

        return salle;
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

    protected List<Formule> formuleEntityListToFormuleList(List<FormuleEntity> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<Formule> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<Formule> list1 = new ArrayList<Formule>( list.size() );
        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );

        for ( FormuleEntity formuleEntity : list ) {
            list1.add( formuleEntityToFormule( formuleEntity, cycleAvoidingMappingContext ) );
        }

        return list1;
    }

    protected Fermeture fermetureEntityToFermeture(FermetureEntity fermetureEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Fermeture target = cycleAvoidingMappingContext.getMappedInstance( fermetureEntity, Fermeture.class );
        if ( target != null ) {
            return target;
        }

        if ( fermetureEntity == null ) {
            return null;
        }

        Fermeture fermeture = new Fermeture();

        cycleAvoidingMappingContext.storeMappedInstance( fermetureEntity, fermeture );

        fermeture.setId( fermetureEntity.getId() );
        fermeture.setDate( fermetureEntity.getDate() );

        return fermeture;
    }

    protected Collection<Fermeture> fermetureEntityCollectionToFermetureCollection(Collection<FermetureEntity> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<Fermeture> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<Fermeture> collection1 = new ArrayList<Fermeture>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( FermetureEntity fermetureEntity : collection ) {
            collection1.add( fermetureEntityToFermeture( fermetureEntity, cycleAvoidingMappingContext ) );
        }

        return collection1;
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

    protected List<FormuleEntity> formuleListToFormuleEntityList(List<Formule> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<FormuleEntity> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<FormuleEntity> list1 = new ArrayList<FormuleEntity>( list.size() );
        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );

        for ( Formule formule : list ) {
            list1.add( formuleToFormuleEntity( formule, cycleAvoidingMappingContext ) );
        }

        return list1;
    }

    protected FermetureEntity fermetureToFermetureEntity(Fermeture fermeture, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        FermetureEntity target = cycleAvoidingMappingContext.getMappedInstance( fermeture, FermetureEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( fermeture == null ) {
            return null;
        }

        FermetureEntity fermetureEntity = new FermetureEntity();

        cycleAvoidingMappingContext.storeMappedInstance( fermeture, fermetureEntity );

        fermetureEntity.setId( fermeture.getId() );
        fermetureEntity.setDate( fermeture.getDate() );

        return fermetureEntity;
    }

    protected Collection<FermetureEntity> fermetureCollectionToFermetureEntityCollection(Collection<Fermeture> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Collection<FermetureEntity> target = cycleAvoidingMappingContext.getMappedInstance( collection, Collection.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        Collection<FermetureEntity> collection1 = new ArrayList<FermetureEntity>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, collection1 );

        for ( Fermeture fermeture : collection ) {
            collection1.add( fermetureToFermetureEntity( fermeture, cycleAvoidingMappingContext ) );
        }

        return collection1;
    }
}
