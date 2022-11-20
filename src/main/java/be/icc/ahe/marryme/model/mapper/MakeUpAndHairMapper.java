package be.icc.ahe.marryme.model.mapper;
import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.model.MakeUpAndHair;
import be.icc.ahe.marryme.model.Salle;
import be.icc.ahe.marryme.model.dto.GetShortMakeUpAndAirServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MakeUpAndHairMapper {
    MakeUpAndHairMapper INSTANCE = Mappers.getMapper( MakeUpAndHairMapper.class );

    MakeUpAndHair entityToModel(MakeUpAndHairEntity makeUpAndHairEntity,
                                @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    MakeUpAndHairEntity modelToEntity(MakeUpAndHair makeUpAndHair,
                                      @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(source = "service_id", target = "serviceID")
    @Mapping(source = "do_hair", target = "doHair")
    @Mapping(source = "do_make_up", target = "doMakeUp")
    @Mapping(source = "do_man", target = "doMan")
    @Mapping(source = "do_woman", target = "doWoman")
    MakeUpAndHair dtoToModel(GetShortMakeUpAndAirServiceDTO form);

}
