package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ServiceDAO;
import be.icc.ahe.marryme.dataaccess.entity.*;
import be.icc.ahe.marryme.exception.sqlexception.ServiceDatabaseException;
//import be.icc.ahe.marryme.model.mapper.ServiceMapper;
import be.icc.ahe.marryme.model.*;
import be.icc.ahe.marryme.model.dto.SingleServiceViewDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.model.mapper.dtomapper.ServiceViewMapper;
import be.icc.ahe.marryme.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<FormuleEntity> formulesList= serviceEntity.getFormules().stream().filter(FormuleEntity::isActive).collect(Collectors.toList());
        serviceEntity.setFormules(formulesList);

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

    @Override
    public be.icc.ahe.marryme.model.Service getTypeOfService(String type){
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("SalleEntity")){
            return new Salle();

        } else if(type.equalsIgnoreCase("TraiteurEntity")){
            return  new Traiteur();

        } else if(type.equalsIgnoreCase("MusiqueEntity")){
            return new Musique();
        }else if(type.equalsIgnoreCase("MakeUpAndHairEntity")){
            return  new MakeUpAndHair();
        }else if(type.equalsIgnoreCase("MediaEntity")){
            return   new Media();
        }else if(type.equalsIgnoreCase("ServiceTraiteurEntity")){
            return  new ServiceTraiteur();
        }

        return null;
        
    }


}
