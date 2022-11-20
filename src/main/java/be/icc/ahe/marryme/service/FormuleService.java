package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.FormuleDatabaseException;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.dto.GetShortFermetureDTO;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public interface FormuleService {
    Formule save(Formule formule) throws FormuleDatabaseException;
    Formule findByID(Long id) throws FormuleDatabaseException;
    Formule update(Formule formule) throws FormuleDatabaseException;
    void deleteById(Long id) throws FormuleDatabaseException;
     List<GetShortFormuleDTO> getAllFormuleByProvider(String email);

    }
