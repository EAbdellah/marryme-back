package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.model.Service;
import be.icc.ahe.marryme.model.ServiceTraiteur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceTraiteurMapper {
    ServiceTraiteurMapper INSTANCE = Mappers.getMapper( ServiceTraiteurMapper.class );

    ServiceTraiteur entityToModel(ServiceTraiteurEntity serviceTraiteurEntity);
    ServiceTraiteurEntity modelToEntity(ServiceTraiteur serviceTraiteur);
}
