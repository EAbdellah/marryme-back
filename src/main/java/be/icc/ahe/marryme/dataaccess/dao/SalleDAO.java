package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.dataaccess.repository.SalleRepo;
import be.icc.ahe.marryme.exception.sqlexception.SalleDatabaseException;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Component
public class SalleDAO {

    private final SalleRepo salleRepo;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public SalleDAO(SalleRepo salleRepo) {
        this.salleRepo = salleRepo;
    }


    public SalleEntity save(SalleEntity salleEntity){
        return salleRepo.save(salleEntity);
    }

    public Optional<SalleEntity> findByID(Long id){
        return salleRepo.findById(id);
    }



    public void deleteById(Long id) throws SalleDatabaseException {
            salleRepo.deleteById(id);

    }

    public boolean existsById(Long id){
        return salleRepo.existsById(id);
    }

    public GetShortSalleServiceDTO getSalleByProvider(String email){
        return salleRepo.getSalleByProvider(email);
    }
}
