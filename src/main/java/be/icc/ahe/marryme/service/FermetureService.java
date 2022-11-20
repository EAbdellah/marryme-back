package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.dto.GetShortFermetureDTO;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;
@Service
public interface FermetureService {
    Fermeture save(Fermeture fermeture) throws FermetureDatabaseException;
    Fermeture findByID(Long id) throws FermetureDatabaseException;
    Fermeture update(Fermeture fermeture) throws FermetureDatabaseException;
    void deleteById(Long id) throws FermetureDatabaseException;
     List<GetShortFermetureDTO> getAllFermetureByProvider(String email);
}
