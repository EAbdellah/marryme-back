package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ServiceDAO;
import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ServiceDatabaseException;
//import be.icc.ahe.marryme.model.mapper.ServiceMapper;
import be.icc.ahe.marryme.model.dto.SingleServiceViewDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.model.mapper.dtomapper.ServiceViewMapper;
import be.icc.ahe.marryme.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ServicesServiceImpl implements ServicesService {

    private final ServiceDAO serviceDAO;

    @Autowired
    public ServicesServiceImpl(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @Override
    public Collection<ServiceEntity> findAll() {
        return serviceDAO.findAll();
    }



    @Override
    public ServiceEntity save(ServiceEntity serviceEntity) throws ServiceDatabaseException {

        ServiceEntity finalServiceEntity = serviceEntity;
        Optional.ofNullable(serviceEntity)
                .orElseThrow(() -> new ServiceDatabaseException("Can not save null service: " + finalServiceEntity));


        ServiceEntity persistedRServiceEntity = serviceDAO.save(serviceEntity);

        Optional.ofNullable(persistedRServiceEntity)
                .orElseThrow(() -> new ServiceDatabaseException("Persisted service is null: " + persistedRServiceEntity));


        return persistedRServiceEntity;

    }

    @Override
    public ServiceEntity findByID(Long id) throws ServiceDatabaseException {

        ServiceEntity serviceEntity= this.serviceDAO.findByID(id)
                .orElseThrow(() -> new ServiceDatabaseException("None service found at id:" + id));



        return serviceEntity;

    }

    @Override
    public ServiceEntity update(ServiceEntity serviceEntity) throws ServiceDatabaseException {

        Optional.ofNullable(serviceEntity)
                .orElseThrow(() -> new ServiceDatabaseException("Can not persist null serviceEntity: " + serviceEntity));

        if (serviceDAO.existsById(serviceEntity.getServiceID())) {
            throw new ServiceDatabaseException("Try to update into data base a service that does not exist: " + serviceEntity);
        }

        ServiceEntity persistedServiceEntity= serviceDAO.save(serviceEntity);


        Optional.ofNullable(serviceEntity)
                .orElseThrow(() -> new ServiceDatabaseException("Persisted service is null: " + persistedServiceEntity));

        return persistedServiceEntity;
    }

    @Override
    public void deleteById(Long id) throws ServiceDatabaseException {
        if (serviceDAO.existsById(id)) {
            serviceDAO.deleteById(id);
        } else {
            throw new ServiceDatabaseException("None service found at id: " + id);
        }
        if (serviceDAO.existsById(id)) {
            throw new ServiceDatabaseException("Failed to delete service into database at id: " + id);
        }
    }

    public SingleServiceViewDTO mapServiceToSingleViewDTO (ServiceEntity serviceEntity){


        return ServiceViewMapper.INSTANCE.entityToDTO(serviceEntity,new CycleAvoidingMappingContext());
    }

    public ServiceEntity setType (ServiceEntity serviceEntity){

        String type = serviceEntity.getType();

        if (type != null && !type.isEmpty()){
            type.replaceFirst("Entity","");
        }

        serviceEntity.setType(type);
        return serviceEntity;
    }


}
