package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.FermetureDAO;
import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.mapper.AddressMapper;
import be.icc.ahe.marryme.model.mapper.FermetureMapper;
import be.icc.ahe.marryme.service.FermetureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.Optional;

@Service
public class FermetureServiceImpl implements FermetureService {
    private final FermetureDAO fermetureDAO;

    @Autowired
    public FermetureServiceImpl(FermetureDAO fermetureDAO) {
        this.fermetureDAO = fermetureDAO;
    }

    @Override
    public Fermeture save(Fermeture fermeture) throws FermetureDatabaseException {

        Optional.ofNullable(fermeture)
                .orElseThrow(() -> new FermetureDatabaseException("Can not persist null fermeture: " + fermeture));

        FermetureEntity persistedFermetureEntity = fermetureDAO.save(FermetureMapper.INSTANCE.modelToEntity(fermeture));

        Optional.ofNullable(persistedFermetureEntity)
                .orElseThrow(() -> new FermetureDatabaseException("Persisted fermeture is null: " + persistedFermetureEntity));

        return FermetureMapper.INSTANCE.entityToModel(persistedFermetureEntity);

    }


    @Override
    public Fermeture findByID(Long id) throws FermetureDatabaseException {

        FermetureEntity fermetureEntity = this.fermetureDAO.findByID(id)
                .orElseThrow(() -> new FermetureDatabaseException("None fermeture found at id:" + id));

        return  FermetureMapper.INSTANCE.entityToModel(fermetureEntity);

    }

    @Override
    public Fermeture update(Fermeture fermeture) throws FermetureDatabaseException {

        Optional.ofNullable(fermeture)
                .orElseThrow(() -> new FermetureDatabaseException("Can not persist null fermeture: " + fermeture));

        if (fermetureDAO.existsById(fermeture.getId())){
            throw new FermetureDatabaseException("Try to update into data base a fermeture that does not exist: " + fermeture);
        }

        FermetureEntity peristedFermetureEntity = fermetureDAO.save(FermetureMapper.INSTANCE.modelToEntity(fermeture));


        Optional.ofNullable(peristedFermetureEntity)
                .orElseThrow(() -> new FermetureDatabaseException("Persisted fermeture is null: " + peristedFermetureEntity));

        return FermetureMapper.INSTANCE.entityToModel(peristedFermetureEntity);
    }

    @Override
    public void deleteById(Long id) throws FermetureDatabaseException {
        if (fermetureDAO.existsById(id)) {
            fermetureDAO.deleteById(id);
        } else {
            throw new FermetureDatabaseException("None fermeture found at id: " + id);
        }
        if (fermetureDAO.existsById(id)){
            throw new FermetureDatabaseException("Failed to delete fermeture into database at id: " + id);
        }
    }
}
