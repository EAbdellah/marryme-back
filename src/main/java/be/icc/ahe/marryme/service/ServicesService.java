package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ServiceDatabaseException;
import be.icc.ahe.marryme.model.dto.SingleServiceViewDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface ServicesService {
    Collection<ServiceEntity> findAll();
    ServiceEntity save(ServiceEntity service) throws ServiceDatabaseException;
    ServiceEntity findByID(Long id) throws ServiceDatabaseException;
    ServiceEntity update( ServiceEntity service) throws ServiceDatabaseException;
    void deleteById(Long id) throws ServiceDatabaseException;
    SingleServiceViewDTO mapServiceToSingleViewDTO ( ServiceEntity serviceEntity);
     Object getTypeOfService(String type);
    }
