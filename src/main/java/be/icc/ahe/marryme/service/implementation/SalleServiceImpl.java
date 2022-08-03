package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.SalleDAO;
import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.exception.SalleDatabaseException;
import be.icc.ahe.marryme.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleDAO salleDAO;

    @Autowired
    public SalleServiceImpl(SalleDAO salleDAO) {
        this.salleDAO = salleDAO;
    }

    @Override
    public void save(SalleEntity salleEntity) throws SalleDatabaseException {
        salleDAO.save(salleEntity);

    }

    @Override
    public void deleteByID(Long id) throws SalleDatabaseException {
        salleDAO.deleteByID(id);
    }

    @Override
    public Optional<SalleEntity> findByID(Long id){
        return salleDAO.findByID(id);
    }
}
