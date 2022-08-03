package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.MusiqueDAO;
import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.service.MusiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusiqueServiceImpl implements MusiqueService {

    private final MusiqueDAO musiqueDAO;

    @Autowired
    public MusiqueServiceImpl(MusiqueDAO musiqueDAO) {
        this.musiqueDAO = musiqueDAO;
    }

    @Override
    public void save(MusiqueEntity musiqueEntity) throws Exception {
        musiqueDAO.save(musiqueEntity);
    }
}
