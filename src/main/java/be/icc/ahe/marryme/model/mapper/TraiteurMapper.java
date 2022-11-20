package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.model.Salle;
import be.icc.ahe.marryme.model.ServiceTraiteur;
import be.icc.ahe.marryme.model.Traiteur;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TraiteurMapper {
    TraiteurMapper INSTANCE = Mappers.getMapper( TraiteurMapper.class );

    Traiteur entityToModel(TraiteurEntity traiteurEntity,
                           @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    TraiteurEntity modelToEntity(Traiteur traiteur,
                                 @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(source = "service_id", target = "serviceID")
    @Mapping(source = "do_meat", target = "doMeat")
    @Mapping(source = "do_fish", target = "doFish")
    @Mapping(source = "do_vegan", target = "doVegan")
    @Mapping(source = "do_vegetarian", target = "doVegetarian")
    Traiteur dtoToModel(GetShortTraiteurServiceDTO form);
}
