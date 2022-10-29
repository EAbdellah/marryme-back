package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.MakeUpAndHairDAO;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ImageDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.MakeUpAndHairDatabaseException;
import be.icc.ahe.marryme.model.Image;
import be.icc.ahe.marryme.model.MakeUpAndHair;
import be.icc.ahe.marryme.model.mapper.ImageMapper;
import be.icc.ahe.marryme.model.mapper.MakeUpAndHairMapper;
import be.icc.ahe.marryme.service.MakeUpAndHairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.Optional;

@Service
public class MakeUpAndHairServiceImpl implements MakeUpAndHairService {

    private final MakeUpAndHairDAO makeUpAndHairDAO;

    @Autowired
    public MakeUpAndHairServiceImpl(MakeUpAndHairDAO makeUpAndHairDAO) {
        this.makeUpAndHairDAO = makeUpAndHairDAO;
    }


    @Override
    public MakeUpAndHair save(MakeUpAndHair makeUpAndHair) throws MakeUpAndHairDatabaseException {

        Optional.ofNullable(makeUpAndHair)
                .orElseThrow(() -> new MakeUpAndHairDatabaseException("Can not persist null makeUpAndHair: " + makeUpAndHair));

        MakeUpAndHairEntity persistedMakeUpAndHairEntity = makeUpAndHairDAO.save(MakeUpAndHairMapper.INSTANCE.modelToEntity(makeUpAndHair));

        Optional.ofNullable(persistedMakeUpAndHairEntity)
                .orElseThrow(() -> new MakeUpAndHairDatabaseException("Persisted makeUpAndHair is null: " + persistedMakeUpAndHairEntity));

        return MakeUpAndHairMapper.INSTANCE.entityToModel(persistedMakeUpAndHairEntity);

    }

    @Override
    public MakeUpAndHair findByID(Long id) throws MakeUpAndHairDatabaseException {

        MakeUpAndHairEntity makeUpAndHairEntity = this.makeUpAndHairDAO.findByID(id)
                .orElseThrow(() -> new MakeUpAndHairDatabaseException("None makeUpAndHair found at id:" + id));

        return MakeUpAndHairMapper.INSTANCE.entityToModel(makeUpAndHairEntity);

    }

    @Override
    public MakeUpAndHair update(MakeUpAndHair makeUpAndHair) throws MakeUpAndHairDatabaseException {

        Optional.ofNullable(makeUpAndHair)
                .orElseThrow(() -> new MakeUpAndHairDatabaseException("Can not persist null makeUpAndHair: " + makeUpAndHair));

        if (makeUpAndHairDAO.existsById(makeUpAndHair.getServiceID())) {
            throw new MakeUpAndHairDatabaseException("Try to update into data base a makeUpAndHair that does not exist: " + makeUpAndHair);
        }

        MakeUpAndHairEntity persistedMakeUpAndHairEntity = makeUpAndHairDAO.save(MakeUpAndHairMapper.INSTANCE.modelToEntity(makeUpAndHair));


        Optional.ofNullable(persistedMakeUpAndHairEntity)
                .orElseThrow(() -> new MakeUpAndHairDatabaseException("Persisted makeUpAndHair is null: " + persistedMakeUpAndHairEntity));

        return MakeUpAndHairMapper.INSTANCE.entityToModel(persistedMakeUpAndHairEntity);
    }

    @Override
    public void deleteById(Long id) throws MakeUpAndHairDatabaseException {
        if (makeUpAndHairDAO.existsById(id)) {
            makeUpAndHairDAO.deleteById(id);
        } else {
            throw new MakeUpAndHairDatabaseException("None makeUpAndHair found at id: " + id);
        }
        if (makeUpAndHairDAO.existsById(id)) {
            throw new MakeUpAndHairDatabaseException("Failed to delete makeUpAndHair into database at id: " + id);
        }
    }
}
