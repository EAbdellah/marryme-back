package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.MusiqueDAO;

import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;


import be.icc.ahe.marryme.exception.sqlexception.MusiqueDatabaseException;
import be.icc.ahe.marryme.model.Musique;
import be.icc.ahe.marryme.model.mapper.MusiqueMapper;
import be.icc.ahe.marryme.service.MusiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusiqueServiceImpl implements MusiqueService {

    private final MusiqueDAO musiqueDAO;

    @Autowired
    public MusiqueServiceImpl(MusiqueDAO musiqueDAO) {
        this.musiqueDAO = musiqueDAO;
    }


    @Override
    public Musique save(Musique musique) throws MusiqueDatabaseException {

        Optional.ofNullable(musique)
                .orElseThrow(() -> new MusiqueDatabaseException("Can not persist null musique: " + musique));

        MusiqueEntity persistedMusiqueEntity = musiqueDAO.save(MusiqueMapper.INSTANCE.modelToEntity(musique));

        Optional.ofNullable(persistedMusiqueEntity)
                .orElseThrow(() -> new MusiqueDatabaseException("Persisted musique is null: " + persistedMusiqueEntity));

        return MusiqueMapper.INSTANCE.entityToModel(persistedMusiqueEntity);

    }

    @Override
    public Musique findByID(Long id) throws MusiqueDatabaseException {

        MusiqueEntity musiqueEntity = this.musiqueDAO.findByID(id)
                .orElseThrow(() -> new MusiqueDatabaseException("None musique found at id:" + id));

        return MusiqueMapper.INSTANCE.entityToModel(musiqueEntity);

    }

    @Override
    public Musique update(Musique musique) throws MusiqueDatabaseException {

        Optional.ofNullable(musique)
                .orElseThrow(() -> new MusiqueDatabaseException("Can not persist null musique: " + musique));

        if (musiqueDAO.existsById(musique.getServiceID())) {
            throw new MusiqueDatabaseException("Try to update into data base a musique that does not exist: " + musique);
        }

        MusiqueEntity persistedMusiqueEntity = musiqueDAO.save(MusiqueMapper.INSTANCE.modelToEntity(musique));


        Optional.ofNullable(persistedMusiqueEntity)
                .orElseThrow(() -> new MusiqueDatabaseException("Persisted musique is null: " + persistedMusiqueEntity));

        return MusiqueMapper.INSTANCE.entityToModel(persistedMusiqueEntity);
    }

    @Override
    public void deleteById(Long id) throws MusiqueDatabaseException {
        if (musiqueDAO.existsById(id)) {
            musiqueDAO.deleteById(id);
        } else {
            throw new MusiqueDatabaseException("None musique found at id: " + id);
        }
        if (musiqueDAO.existsById(id)) {
            throw new MusiqueDatabaseException("Failed to delete musique into database at id: " + id);
        }
    }
}
