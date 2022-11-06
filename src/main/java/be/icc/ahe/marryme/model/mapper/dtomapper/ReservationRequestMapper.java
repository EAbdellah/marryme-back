package be.icc.ahe.marryme.model.mapper.dtomapper;

import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.dto.ReservationRequestDTO;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationRequestMapper {
    ReservationRequestMapper INSTANCE = Mappers.getMapper(ReservationRequestMapper.class);


    Reservation dtotomodel(ReservationRequestDTO reservationRequestDTO,
                           @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
