package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.dataaccess.repository.SocieteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocieteDAO {
    private final SocieteRepo societeRepo;

    @Autowired
    public SocieteDAO(SocieteRepo societeRepo) {
        this.societeRepo = societeRepo;
    }

    public SocieteEntity save(SocieteEntity societeEntity){

        return societeRepo.save(societeEntity);
    }
}
