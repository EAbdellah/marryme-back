package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.SocieteDAO;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.exception.SocieteDatabaseException;
import be.icc.ahe.marryme.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocieteServiceImpl implements SocieteService {

    private final SocieteDAO societeDAO;

    @Autowired
    public SocieteServiceImpl(SocieteDAO societeDAO) {
        this.societeDAO = societeDAO;
    }

    @Override
    public void save(SocieteEntity societeEntity) throws SocieteDatabaseException {
        societeDAO.save(societeEntity);

    }
}
