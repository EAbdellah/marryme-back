package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.repository.FermetureRepo;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;
import java.util.Optional;

@Component
@Transactional
public class FermetureDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(FermetureDAO.class);

    private final FermetureRepo fermetureRepo;

    @Autowired
    public FermetureDAO(FermetureRepo fermetureRepo) {
        this.fermetureRepo = fermetureRepo;
    }

    public FermetureEntity save(FermetureEntity fermetureEntity){
        return fermetureRepo.save(fermetureEntity);
    }

    public Optional<FermetureEntity> findByID(Long id){

        return fermetureRepo.findById(id);
    }


    public void deleteById(Long id)  {
            fermetureRepo.deleteById(id);
    }

    public boolean existsById(Long id){
        return fermetureRepo.existsById(id);
    }



}
