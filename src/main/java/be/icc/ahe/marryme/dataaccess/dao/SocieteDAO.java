package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.dataaccess.repository.SocieteRepo;
import be.icc.ahe.marryme.exception.sqlexception.SocieteDatabaseException;
import be.icc.ahe.marryme.model.dto.ProviderRequestRegistrationDTO;
import be.icc.ahe.marryme.model.dto.ReservationClientDTO;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Component
public class SocieteDAO {
    private final SocieteRepo societeRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public SocieteDAO(SocieteRepo societeRepo) {
        this.societeRepo = societeRepo;
    }

    public SocieteEntity save(SocieteEntity societeEntity){

        return societeRepo.save(societeEntity);
    }


    public Optional<SocieteEntity> findByID(Long id){
        return societeRepo.findById(id);
    }

    public Optional<SocieteEntity> findByEmail(String email){
        return societeRepo.findByEmail(email);
    }


    public void deleteById(Long id) throws SocieteDatabaseException {
            societeRepo.deleteById(id);
    }

    public boolean existsById(Long id){
        return societeRepo.existsById(id);
    }

    public List<ProviderRequestRegistrationDTO> getAllProviderRequestRegistration(){
        return societeRepo.getAllProviderRequestRegistration();
    }

}
