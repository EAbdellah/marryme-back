package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.dataaccess.repository.SalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalleDAO {

    private final SalleRepo salleRepo;

    @Autowired
    public SalleDAO(SalleRepo salleRepo) {
        this.salleRepo = salleRepo;
    }

    public SalleEntity save(SalleEntity salleEntity){

        return salleRepo.save(salleEntity);
    }

    public void deleteByID(Long id){
         salleRepo.deleteById(id);
    }

    public Optional<SalleEntity> findByID(Long id){
        return salleRepo.findById(id);
    }
}
