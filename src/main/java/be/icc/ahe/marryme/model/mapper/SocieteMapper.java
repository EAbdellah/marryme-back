package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.*;
import be.icc.ahe.marryme.model.*;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocieteMapper {

    SocieteMapper INSTANCE = Mappers.getMapper( SocieteMapper.class );

    @Mapping(source = "owner.userEntity", target = "owner.user")
    Societe entityToModel(SocieteEntity societeEntity,
                          @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(source = "owner.user", target = "owner.userEntity")
    SocieteEntity modelToEntity(Societe societe,
                                @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(source = "name", target = "nom")
    @Mapping(source = "n_entreprise", target = "NEntreprise")
    @Mapping(source = "n_tva", target = "NTVA")
    @Mapping(source = "entreprise_phone", target = "NTel")
    @Mapping(source = "email_entreprise", target = "email")
    Societe RegistrationProviderDtoToModel(ProviderRegisterFormDTO providerRegisterFormDTO);


    default Service map(ServiceEntity value) {
        if (value !=null) {
            if (value instanceof HibernateProxy) {
                value = (ServiceEntity) ((HibernateProxy) value).getHibernateLazyInitializer()
                        .getImplementation();
            }

                if ((value).getClass().equals(SalleEntity.class)) {
                return  SalleMapper.INSTANCE.entityToModel((SalleEntity) value,new CycleAvoidingMappingContext());
        }else if(value.getClass().equals(MusiqueEntity.class)){
                return  MusiqueMapper.INSTANCE.entityToModel((MusiqueEntity) value,new CycleAvoidingMappingContext());
        }else if(value.getClass().equals(MediaEntity.class)){
                return MediaMapper.INSTANCE.entityToModel((MediaEntity) value,new CycleAvoidingMappingContext());
        }else if(value.getClass().equals(MakeUpAndHairEntity.class)){
                return  MakeUpAndHairMapper.INSTANCE.entityToModel((MakeUpAndHairEntity)value,new CycleAvoidingMappingContext());
        }else if(value.getClass().equals(ServiceTraiteurEntity.class)){
                return  ServiceTraiteurMapper.INSTANCE.entityToModel((ServiceTraiteurEntity)value,new CycleAvoidingMappingContext());
        }else if(value.getClass().equals(TraiteurEntity.class)){
                return  TraiteurMapper.INSTANCE.entityToModel((TraiteurEntity) value,new CycleAvoidingMappingContext());
        }
        else
            throw new IllegalArgumentException("Unknown service type.");
        }else
            return null;
    }

    default ServiceEntity map(Service value) {
        if (value !=null) {
            if (value.getClass().equals(Salle.class)) {
                return  SalleMapper.INSTANCE.modelToEntity((Salle) value,new CycleAvoidingMappingContext());
            } else if (value.getClass().equals(Musique.class)) {
                return  MusiqueMapper.INSTANCE.modelToEntity((Musique) value,new CycleAvoidingMappingContext());
            } else if (value.getClass().equals(Media.class)) {
                return MediaMapper.INSTANCE.modelToEntity((Media) value,new CycleAvoidingMappingContext());
            } else if (value.getClass().equals(MakeUpAndHair.class)) {
                return  MakeUpAndHairMapper.INSTANCE.modelToEntity((MakeUpAndHair)value,new CycleAvoidingMappingContext());
            } else if (value.getClass().equals(ServiceTraiteur.class)) {
                return  ServiceTraiteurMapper.INSTANCE.modelToEntity((ServiceTraiteur)value,new CycleAvoidingMappingContext());
            } else if (value.getClass().equals(Traiteur.class)) {
                return  TraiteurMapper.INSTANCE.modelToEntity((Traiteur) value,new CycleAvoidingMappingContext());
            } else
                throw new IllegalArgumentException("Unknown service type.");
        }else
            return null;

    }

}
