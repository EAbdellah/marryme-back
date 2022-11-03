package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.model.Parking;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T05:16:17+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class ParkingMapperImpl implements ParkingMapper {

    @Override
    public Parking entityToModel(ParkingEntity parkingEntity) {
        if ( parkingEntity == null ) {
            return null;
        }

        Parking parking = new Parking();

        parking.setParkingID( parkingEntity.getParkingID() );
        parking.setCapacity( parkingEntity.getCapacity() );
        parking.setVoiturier( parkingEntity.getVoiturier() );

        return parking;
    }

    @Override
    public ParkingEntity modelToEntity(Parking parking) {
        if ( parking == null ) {
            return null;
        }

        ParkingEntity parkingEntity = new ParkingEntity();

        parkingEntity.setParkingID( parking.getParkingID() );
        parkingEntity.setCapacity( parking.getCapacity() );
        parkingEntity.setVoiturier( parking.getVoiturier() );

        return parkingEntity;
    }
}
