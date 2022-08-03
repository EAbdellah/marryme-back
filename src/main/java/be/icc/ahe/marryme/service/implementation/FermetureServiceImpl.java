package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.FermetureDAO;
import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.exception.FermetureDatabaseException;
import be.icc.ahe.marryme.exception.SalleDatabaseException;
import be.icc.ahe.marryme.service.FermetureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FermetureServiceImpl implements FermetureService {
    private final FermetureDAO fermetureDAO;

    @Autowired
    public FermetureServiceImpl(FermetureDAO fermetureDAO) {
        this.fermetureDAO = fermetureDAO;
    }

    @Override
    public void save(FermetureEntity fermetureEntity) throws FermetureDatabaseException {
        fermetureDAO.save(fermetureEntity);
    }

    @Override
    public void deleteByID(Long id) throws SalleDatabaseException {
        fermetureDAO.deleteByID(id);
    }
}
