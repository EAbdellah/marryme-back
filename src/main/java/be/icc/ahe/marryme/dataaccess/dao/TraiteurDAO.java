package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.dataaccess.repository.TraiteurRepo;
import be.icc.ahe.marryme.exception.sqlexception.TraiteurDatabaseException;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
public class TraiteurDAO {
    private final TraiteurRepo traiteurRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public TraiteurDAO(TraiteurRepo traiteurRepo) {
        this.traiteurRepo = traiteurRepo;
    }

    public TraiteurEntity save(TraiteurEntity traiteurEntity){

        return traiteurRepo.save(traiteurEntity);
    }

    public Optional<TraiteurEntity> findByID(Long id){
        return traiteurRepo.findById(id);
    }


    public void deleteById(Long id) throws TraiteurDatabaseException {
            traiteurRepo.deleteById(id);
    }

    public boolean existsById(Long id){
        return traiteurRepo.existsById(id);
    }

    public GetShortTraiteurServiceDTO getTraiteurByProvider(String email){
        return traiteurRepo.getTraiteurByProvider(email);
    }

}
