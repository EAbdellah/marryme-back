package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.dataaccess.repository.MusiqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusiqueDAO {
    private final MusiqueRepo musiqueRepo;

    @Autowired
    public MusiqueDAO(MusiqueRepo musiqueRepo) {
        this.musiqueRepo = musiqueRepo;
    }

    public MusiqueEntity save(MusiqueEntity musiqueEntity){

        return musiqueRepo.save(musiqueEntity);
    }
}
