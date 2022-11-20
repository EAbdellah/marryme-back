package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ServiceTraiteurDAO;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ServiceDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ServiceTraiteurDatabaseException;
import be.icc.ahe.marryme.model.ServiceTraiteur;
import be.icc.ahe.marryme.model.dto.GetShortServiceTraiteurServiceDTO;
import be.icc.ahe.marryme.model.mapper.ServiceTraiteurMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.service.ServiceTraiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceTraiteurServiceImpl implements ServiceTraiteurService {

    private final ServiceTraiteurDAO serviceTraiteurDAO;

    @Autowired
    public ServiceTraiteurServiceImpl(ServiceTraiteurDAO serviceTraiteurDAO) {
        this.serviceTraiteurDAO = serviceTraiteurDAO;
    }


    @Override
    public ServiceTraiteur save(ServiceTraiteur serviceTraiteur) throws ServiceTraiteurDatabaseException {

        Optional.ofNullable(serviceTraiteur)
                .orElseThrow(() -> new ServiceTraiteurDatabaseException("Can not save null serviceTraiteur: " + serviceTraiteur));

        ServiceTraiteurEntity persistedRServiceTraiteurEntity = serviceTraiteurDAO.save(ServiceTraiteurMapper.INSTANCE.modelToEntity(serviceTraiteur,new CycleAvoidingMappingContext()));

        Optional.ofNullable(persistedRServiceTraiteurEntity)
                .orElseThrow(() -> new ServiceTraiteurDatabaseException("Persisted serviceTraiteur is null: " + persistedRServiceTraiteurEntity));

        return ServiceTraiteurMapper.INSTANCE.entityToModel(persistedRServiceTraiteurEntity,new CycleAvoidingMappingContext());

    }

    @Override
    public ServiceTraiteur findByID(Long id) throws ServiceTraiteurDatabaseException {

        ServiceTraiteurEntity serviceTraiteurEntity= this.serviceTraiteurDAO.findByID(id)
                .orElseThrow(() -> new ServiceTraiteurDatabaseException("None serviceTraiteur found at id:" + id));

        return ServiceTraiteurMapper.INSTANCE.entityToModel(serviceTraiteurEntity,new CycleAvoidingMappingContext());

    }

    @Override
    public ServiceTraiteur update(ServiceTraiteur serviceTraiteur) throws ServiceTraiteurDatabaseException {

        Optional.ofNullable(serviceTraiteur)
                .orElseThrow(() -> new ServiceTraiteurDatabaseException("Can not persist null serviceTraiteur: " + serviceTraiteur));

        if (serviceTraiteurDAO.existsById(serviceTraiteur.getServiceID())) {
            throw new ServiceTraiteurDatabaseException("Try to update into data base a serviceTraiteur that does not exist: " + serviceTraiteur);
        }

        ServiceTraiteurEntity serviceTraiteurEntity= serviceTraiteurDAO.save(ServiceTraiteurMapper.INSTANCE.modelToEntity(serviceTraiteur,new CycleAvoidingMappingContext()));


        Optional.ofNullable(serviceTraiteurEntity)
                .orElseThrow(() -> new ServiceTraiteurDatabaseException("Persisted serviceTraiteur is null: " + serviceTraiteurEntity));

        return ServiceTraiteurMapper.INSTANCE.entityToModel(serviceTraiteurEntity,new CycleAvoidingMappingContext());
    }

    @Override
    public void deleteById(Long id) throws ServiceTraiteurDatabaseException {
        if (serviceTraiteurDAO.existsById(id)) {
            serviceTraiteurDAO.deleteById(id);
        } else {
            throw new ServiceTraiteurDatabaseException("None serviceTraiteur found at id: " + id);
        }
        if (serviceTraiteurDAO.existsById(id)) {
            throw new ServiceTraiteurDatabaseException("Failed to delete serviceTraiteur into database at id: " + id);
        }
    }

    @Override
    public GetShortServiceTraiteurServiceDTO getServiceTraiteurByProvider(String providerEmail) {
        return serviceTraiteurDAO.getServiceTraiteurByProvider(providerEmail);
    }


}
