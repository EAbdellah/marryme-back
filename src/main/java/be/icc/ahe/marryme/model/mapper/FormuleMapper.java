package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FormuleMapper {
    FormuleMapper INSTANCE = Mappers.getMapper( FormuleMapper.class );
    Formule entityToModel(FormuleEntity formuleEntity,
                          @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    FormuleEntity modelToEntity(Formule formule,
                                @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);


    @Mapping(source = "formule_id", target = "formuleID")
    @Mapping(source = "is_unique_prix", target = "isUniquePrix")
    @Mapping(source = "sup_dimanche", target = "supDimanche")
    @Mapping(source = "sup_ferrier", target = "supFerrier")
    @Mapping(source = "sup_samedi", target = "supSamedi")
    @Mapping(source = "sup_veille_ferier", target = "supVeilleFerier")
    Formule dtoToModel(GetShortFormuleDTO form);



}
