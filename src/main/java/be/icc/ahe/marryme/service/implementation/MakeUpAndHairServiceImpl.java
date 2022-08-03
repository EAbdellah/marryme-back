package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.MakeUpAndHairDAO;
import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.service.MakeUpAndHairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeUpAndHairServiceImpl implements MakeUpAndHairService {

    private final MakeUpAndHairDAO makeUpAndHairDAO;

    @Autowired
    public MakeUpAndHairServiceImpl(MakeUpAndHairDAO makeUpAndHairDAO) {
        this.makeUpAndHairDAO = makeUpAndHairDAO;
    }

    @Override
    public void save(MakeUpAndHairEntity makeUpAndHairEntity) throws Exception {
        makeUpAndHairDAO.save(makeUpAndHairEntity);
    }
}
