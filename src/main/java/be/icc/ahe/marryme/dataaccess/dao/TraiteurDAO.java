package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.dataaccess.repository.TraiteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TraiteurDAO {
    private final TraiteurRepo traiteurRepo;

    @Autowired
    public TraiteurDAO(TraiteurRepo traiteurRepo) {
        this.traiteurRepo = traiteurRepo;
    }

    public TraiteurEntity save(TraiteurEntity traiteurEntity){

        return traiteurRepo.save(traiteurEntity);
    }
}
