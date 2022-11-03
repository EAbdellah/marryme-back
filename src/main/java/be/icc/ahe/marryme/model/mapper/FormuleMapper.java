package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FormuleMapper {
    FormuleMapper INSTANCE = Mappers.getMapper( FormuleMapper.class );
    Formule entityToModel(FormuleEntity formuleEntity,
                          @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    FormuleEntity modelToEntity(Formule formule,
                                @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
