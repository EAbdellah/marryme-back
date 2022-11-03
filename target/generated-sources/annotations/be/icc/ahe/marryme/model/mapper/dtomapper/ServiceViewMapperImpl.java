package be.icc.ahe.marryme.model.mapper.dtomapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Image;
import be.icc.ahe.marryme.model.dto.SingleServiceViewDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-02T03:33:42+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class ServiceViewMapperImpl implements ServiceViewMapper {

    @Override
    public SingleServiceViewDTO entityToDTO(ServiceEntity serviceEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        SingleServiceViewDTO target = cycleAvoidingMappingContext.getMappedInstance( serviceEntity, SingleServiceViewDTO.class );
        if ( target != null ) {
            return target;
        }

        if ( serviceEntity == null ) {
            return null;
        }

        SingleServiceViewDTO singleServiceViewDTO = new SingleServiceViewDTO();

        cycleAvoidingMappingContext.storeMappedInstance( serviceEntity, singleServiceViewDTO );

        singleServiceViewDTO.setServiceID( serviceEntity.getServiceID() );
        singleServiceViewDTO.setType( serviceEntity.getType() );
        singleServiceViewDTO.setNom( serviceEntity.getNom() );
        singleServiceViewDTO.setAddress( addressEntityToAddress( serviceEntity.getAddress(), cycleAvoidingMappingContext ) );
        singleServiceViewDTO.setFormules( formuleEntityListToFormuleList( serviceEntity.getFormules(), cycleAvoidingMappingContext ) );
        singleServiceViewDTO.setFermetures( fermetureEntityCollectionToFermetureList( serviceEntity.getFermetures(), cycleAvoidingMappingContext ) );

        return singleServiceViewDTO;
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
        formule.setSupVeilleFerier( formuleEntity.getSupVeilleFerier() );
        formule.setImages( imageEntityListToImageList( formuleEntity.getImages(), cycleAvoidingMappingContext ) );

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

    protected List<Fermeture> fermetureEntityCollectionToFermetureList(Collection<FermetureEntity> collection, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<Fermeture> target = cycleAvoidingMappingContext.getMappedInstance( collection, List.class );
        if ( target != null ) {
            return target;
        }

        if ( collection == null ) {
            return null;
        }

        List<Fermeture> list = new ArrayList<Fermeture>( collection.size() );
        cycleAvoidingMappingContext.storeMappedInstance( collection, list );

        for ( FermetureEntity fermetureEntity : collection ) {
            list.add( fermetureEntityToFermeture( fermetureEntity, cycleAvoidingMappingContext ) );
        }

        return list;
    }
}
