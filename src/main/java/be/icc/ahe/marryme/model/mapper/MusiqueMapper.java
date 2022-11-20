package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.model.Media;
import be.icc.ahe.marryme.model.Musique;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortMusiqueServiceDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MusiqueMapper {
    MusiqueMapper INSTANCE = Mappers.getMapper( MusiqueMapper.class );

    Musique entityToModel(MusiqueEntity musiqueEntity,
                          @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    MusiqueEntity modelToEntity(Musique musique,
                                @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);



    @Mapping(source = "service_id", target = "serviceID")
    @Mapping(source = "musique_type", target = "musiqueType")
    Musique dtoToModel(GetShortMusiqueServiceDTO form);

}
