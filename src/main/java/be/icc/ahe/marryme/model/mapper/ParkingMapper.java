package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.model.Parking;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParkingMapper {
    ParkingMapper INSTANCE = Mappers.getMapper( ParkingMapper.class );

    Parking entityToModel(ParkingEntity parkingEntity,
                          @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    ParkingEntity modelToEntity(Parking parking,
                                @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

}
