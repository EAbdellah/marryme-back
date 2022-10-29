package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.dataaccess.repository.ServiceTraiteurRepo;
import be.icc.ahe.marryme.exception.sqlexception.ServiceTraiteurDatabaseException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class ServiceTraiteurDAO {
    private final ServiceTraiteurRepo serviceTraiteurRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public ServiceTraiteurDAO(ServiceTraiteurRepo serviceTraiteurRepo) {
        this.serviceTraiteurRepo = serviceTraiteurRepo;
    }

    public ServiceTraiteurEntity save(ServiceTraiteurEntity serviceTraiteurEntity){
        return serviceTraiteurRepo.save(serviceTraiteurEntity);
    }

    public Optional<ServiceTraiteurEntity> findByID(Long id){
        return serviceTraiteurRepo.findById(id);
    }



    public void deleteById(Long id) throws ServiceTraiteurDatabaseException {
            serviceTraiteurRepo.deleteById(id);
    }

    public boolean existsById(Long id){
        return serviceTraiteurRepo.existsById(id);
    }



}
