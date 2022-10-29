package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ParkingDAO;
import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.exception.sqlexception.ParkingDatabaseException;
import be.icc.ahe.marryme.model.Parking;
import be.icc.ahe.marryme.model.mapper.ParkingMapper;
import be.icc.ahe.marryme.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingDAO parkingDAO;

    @Autowired
    public ParkingServiceImpl(ParkingDAO parkingDAO) {
        this.parkingDAO = parkingDAO;
    }



    @Override
    public Parking save(Parking parking) throws ParkingDatabaseException {

        Optional.ofNullable(parking)
                .orElseThrow(() -> new ParkingDatabaseException("Can not persist null parking: " + parking));

        ParkingEntity persistedParkingEntity = parkingDAO.save(ParkingMapper.INSTANCE.modelToEntity(parking));

        Optional.ofNullable(persistedParkingEntity)
                .orElseThrow(() -> new ParkingDatabaseException("Persisted parking is null: " + persistedParkingEntity));

        return ParkingMapper.INSTANCE.entityToModel(persistedParkingEntity);

    }

    @Override
    public Parking findByID(Long id) throws ParkingDatabaseException {

        ParkingEntity parkingEntity = this.parkingDAO.findByID(id)
                .orElseThrow(() -> new ParkingDatabaseException("None parking found at id:" + id));

        return ParkingMapper.INSTANCE.entityToModel(parkingEntity);

    }

    @Override
    public Parking update(Parking parking) throws ParkingDatabaseException {

        Optional.ofNullable(parking)
                .orElseThrow(() -> new ParkingDatabaseException("Can not persist null parking: " + parking));

        if (parkingDAO.existsById(parking.getParkingID())) {
            throw new ParkingDatabaseException("Try to update into data base a parking that does not exist: " + parking);
        }

        ParkingEntity persistedParkingEntity = parkingDAO.save(ParkingMapper.INSTANCE.modelToEntity(parking));


        Optional.ofNullable(persistedParkingEntity)
                .orElseThrow(() -> new ParkingDatabaseException("Persisted parking is null: " + persistedParkingEntity));

        return ParkingMapper.INSTANCE.entityToModel(persistedParkingEntity);
    }

    @Override
    public void deleteById(Long id) throws ParkingDatabaseException {
        if (parkingDAO.existsById(id)) {
            parkingDAO.deleteById(id);
        } else {
            throw new ParkingDatabaseException("None parking found at id: " + id);
        }
        if (parkingDAO.existsById(id)) {
            throw new ParkingDatabaseException("Failed to delete parking into database at id: " + id);
        }
    }
}
