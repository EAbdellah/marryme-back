package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ParkingDAO;
import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import be.icc.ahe.marryme.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingDAO parkingDAO;

    @Autowired
    public ParkingServiceImpl(ParkingDAO parkingDAO) {
        this.parkingDAO = parkingDAO;
    }

    @Override
    public void save(ParkingEntity parkingEntity) throws Exception{
        parkingDAO.save(parkingEntity);

    }

    @Override
    public void deleteByID(Long id) throws Exception {
        parkingDAO.deleteByID(id);    }
}
