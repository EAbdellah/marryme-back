package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.dataaccess.repository.MakeUpAndHairRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeUpAndHairDAO {
    private final MakeUpAndHairRepo makeUpAndHairRepo;

    @Autowired
    public MakeUpAndHairDAO(MakeUpAndHairRepo makeUpAndHairRepo) {
        this.makeUpAndHairRepo = makeUpAndHairRepo;
    }

    public MakeUpAndHairEntity save(MakeUpAndHairEntity makeUpAndHairEntity){

        return makeUpAndHairRepo.save(makeUpAndHairEntity);
    }
}
