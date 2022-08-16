package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.model.Parking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParkingMapper {
    ParkingMapper INSTANCE = Mappers.getMapper( ParkingMapper.class );

    ParkingEntity entityToModel(Parking parking);
    Parking modelToEntity(ParkingEntity parkingEntity);

}
