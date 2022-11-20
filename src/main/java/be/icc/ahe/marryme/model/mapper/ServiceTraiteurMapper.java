package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.model.Service;
import be.icc.ahe.marryme.model.ServiceTraiteur;
import be.icc.ahe.marryme.model.Traiteur;
import be.icc.ahe.marryme.model.dto.GetShortServiceTraiteurServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceTraiteurMapper {
    ServiceTraiteurMapper INSTANCE = Mappers.getMapper( ServiceTraiteurMapper.class );

    ServiceTraiteur entityToModel(ServiceTraiteurEntity serviceTraiteurEntity,
                                  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    ServiceTraiteurEntity modelToEntity(ServiceTraiteur serviceTraiteur,
                                        @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(source = "serviceId", target = "serviceID")
    @Mapping(source = "man_only", target = "manOnly")
    @Mapping(source = "woman_only", target = "womanOnly")
    ServiceTraiteur dtoToModel(GetShortServiceTraiteurServiceDTO form);

}
