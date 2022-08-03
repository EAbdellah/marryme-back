package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.repository.FermetureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class FermetureDAO {
    private final FermetureRepo fermetureRepo;

    @Autowired
    public FermetureDAO(FermetureRepo fermetureRepo) {
        this.fermetureRepo = fermetureRepo;
    }

    public FermetureEntity save(FermetureEntity fermetureEntity){

        return fermetureRepo.save(fermetureEntity);
    }

    public void deleteByID(Long id){
        fermetureRepo.deleteById(id);
    }
}
