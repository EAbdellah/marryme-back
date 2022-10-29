package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.*;
import be.icc.ahe.marryme.model.*;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocieteMapper {

    SocieteMapper INSTANCE = Mappers.getMapper( SocieteMapper.class );

    Societe entityToModel(SocieteEntity societeEntity);
    SocieteEntity modelToEntity(Societe societe);

    default Service map(ServiceEntity value) {
        if (value !=null) {
            if ((value).getClass().equals(SalleEntity.class)) {
                return  SalleMapper.INSTANCE.entityToModel((SalleEntity) value);
        }else if(value.getClass().equals(MusiqueEntity.class)){
                return  MusiqueMapper.INSTANCE.entityToModel((MusiqueEntity) value);
        }else if(value.getClass().equals(MediaEntity.class)){
                return MediaMapper.INSTANCE.entityToModel((MediaEntity) value);
        }else if(value.getClass().equals(MakeUpAndHairEntity.class)){
                return  MakeUpAndHairMapper.INSTANCE.entityToModel((MakeUpAndHairEntity)value);
        }else if(value.getClass().equals(ServiceTraiteurEntity.class)){
                return  ServiceTraiteurMapper.INSTANCE.entityToModel((ServiceTraiteurEntity)value);
        }else if(value.getClass().equals(TraiteurEntity.class)){
                return  TraiteurMapper.INSTANCE.entityToModel((TraiteurEntity) value);
        }
        else
            throw new IllegalArgumentException("Unknown service type.");
        }else
            return null;
    }

    default ServiceEntity map(Service value) {
        if (value !=null) {
            if (value.getClass().equals(Salle.class)) {
                return  SalleMapper.INSTANCE.modelToEntity((Salle) value);
            } else if (value.getClass().equals(Musique.class)) {
                return  MusiqueMapper.INSTANCE.modelToEntity((Musique) value);
            } else if (value.getClass().equals(Media.class)) {
                return MediaMapper.INSTANCE.modelToEntity((Media) value);
            } else if (value.getClass().equals(MakeUpAndHair.class)) {
                return  MakeUpAndHairMapper.INSTANCE.modelToEntity((MakeUpAndHair)value);
            } else if (value.getClass().equals(ServiceTraiteur.class)) {
                return  ServiceTraiteurMapper.INSTANCE.modelToEntity((ServiceTraiteur)value);
            } else if (value.getClass().equals(Traiteur.class)) {
                return  TraiteurMapper.INSTANCE.modelToEntity((Traiteur) value);
            } else
                throw new IllegalArgumentException("Unknown service type.");
        }else
            return null;

    }


}
