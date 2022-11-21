package be.icc.ahe.marryme.model.mapper.dtomapper;

import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.dto.ReservationRequestDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-21T04:35:40+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class ReservationRequestMapperImpl implements ReservationRequestMapper {

    @Override
    public Reservation dtotomodel(ReservationRequestDTO reservationRequestDTO, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        Reservation target = cycleAvoidingMappingContext.getMappedInstance( reservationRequestDTO, Reservation.class );
        if ( target != null ) {
            return target;
        }

        if ( reservationRequestDTO == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        cycleAvoidingMappingContext.storeMappedInstance( reservationRequestDTO, reservation );

        reservation.setReservationDate( reservationRequestDTO.getReservationDate() );
        reservation.setPrice( reservationRequestDTO.getPrice() );
        reservation.setContract( reservationRequestDTO.getContract() );

        return reservation;
    }
}
