package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ParkingEntity;
import org.springframework.stereotype.Service;

@Service
public interface ParkingService {
    void save(ParkingEntity parkingEntity) throws Exception;
    void deleteByID(Long id)throws Exception;
}
