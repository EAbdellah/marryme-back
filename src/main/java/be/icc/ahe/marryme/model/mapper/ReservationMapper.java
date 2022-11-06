package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper( ReservationMapper.class );

    Reservation entityToModel(ReservationEntity reservationEntity,
                              @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    ReservationEntity modelToEntity(Reservation reservation,
                                    @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

}
