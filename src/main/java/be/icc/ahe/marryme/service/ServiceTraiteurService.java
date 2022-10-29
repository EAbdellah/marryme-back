package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ServiceTraiteurDatabaseException;
import be.icc.ahe.marryme.model.ServiceTraiteur;
import org.springframework.stereotype.Component;

@Component
public interface ServiceTraiteurService {
    ServiceTraiteur save(ServiceTraiteur serviceTraiteur) throws ServiceTraiteurDatabaseException;
    ServiceTraiteur findByID(Long id) throws ServiceTraiteurDatabaseException;
    ServiceTraiteur update(ServiceTraiteur serviceTraiteur) throws ServiceTraiteurDatabaseException;
    void deleteById(Long id) throws ServiceTraiteurDatabaseException;
}
