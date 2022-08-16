package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.model.Reservation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-16T01:51:58+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationEntity entityToModel(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationEntity reservationEntity = new ReservationEntity();

        reservationEntity.setReservationID( reservation.getReservationID() );
        reservationEntity.setReservationDate( reservation.getReservationDate() );
        reservationEntity.setTicket( reservation.getTicket() );

        return reservationEntity;
    }

    @Override
    public Reservation modelToEntity(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setReservationID( reservationEntity.getReservationID() );
        reservation.setReservationDate( reservationEntity.getReservationDate() );
        reservation.setTicket( reservationEntity.getTicket() );

        return reservation;
    }
}
