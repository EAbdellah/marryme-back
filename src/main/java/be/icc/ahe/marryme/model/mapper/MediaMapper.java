package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.model.MakeUpAndHair;
import be.icc.ahe.marryme.model.Media;
import be.icc.ahe.marryme.model.dto.GetShortMakeUpAndAirServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MediaMapper {
    MediaMapper INSTANCE = Mappers.getMapper( MediaMapper.class );

    Media entityToModel(MediaEntity mediaEntity,
                        @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    MediaEntity modelToEntity(Media media,
                              @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);



    @Mapping(source = "service_id", target = "serviceID")
    @Mapping(source = "is_photo", target = "isPhoto")
    @Mapping(source = "is_video", target = "isVideo")
    @Mapping(source = "do_album", target = "doAlbum")
    @Mapping(source = "do_souvenir", target = "doSouvenir")
    Media dtoToModel(GetShortMediaServiceDTO form);

}
