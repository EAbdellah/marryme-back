package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.TraiteurDatabaseException;
import be.icc.ahe.marryme.model.Traiteur;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import org.springframework.stereotype.Service;

@Service
public interface TraiteurService {
    Traiteur save(Traiteur traiteur) throws TraiteurDatabaseException;
    Traiteur findByID(Long id) throws TraiteurDatabaseException;
    Traiteur update(Traiteur traiteur) throws TraiteurDatabaseException;
    void deleteById(Long id) throws TraiteurDatabaseException;
    GetShortTraiteurServiceDTO getTraiteurByProvider(String providerEmail);

}
