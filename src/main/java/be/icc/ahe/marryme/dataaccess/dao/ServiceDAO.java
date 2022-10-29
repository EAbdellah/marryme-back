package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.dataaccess.repository.SalleRepo;
import be.icc.ahe.marryme.dataaccess.repository.ServicesRepo;
import be.icc.ahe.marryme.exception.sqlexception.ServiceDatabaseException;
import be.icc.ahe.marryme.model.Service;
import be.icc.ahe.marryme.model.dto.AllServicesDTO;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.sql.SQLDataException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceDAO {
    private final ServicesRepo servicesRepo;

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public ServiceDAO(ServicesRepo servicesRepo) {
        this.servicesRepo = servicesRepo; }

    public ServiceEntity save(ServiceEntity serviceEntity){
        return servicesRepo.save(serviceEntity);
    }

    public Optional<ServiceEntity> findByID(Long id){
        return servicesRepo.findById(id);
    }

    public Collection<ServiceEntity> findAll(){
        return servicesRepo.findAll();
    }

    public List<AllServicesDTO> findAllServiceForListMenu(){
//        return  em.createQuery(getAllServices,);
        return servicesRepo.getAllServices();
    }

    public void deleteById(Long id) throws ServiceDatabaseException {
            servicesRepo.deleteById(id);
    }
    public boolean existsById(Long id){
        return servicesRepo.existsById(id);
    }

}
