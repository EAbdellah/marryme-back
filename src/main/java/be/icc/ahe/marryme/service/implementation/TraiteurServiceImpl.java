package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.TraiteurDAO;
import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.exception.sqlexception.TraiteurDatabaseException;
import be.icc.ahe.marryme.model.Traiteur;
import be.icc.ahe.marryme.model.mapper.TraiteurMapper;
import be.icc.ahe.marryme.service.TraiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TraiteurServiceImpl implements TraiteurService {

    private final TraiteurDAO traiteurDAO;

    @Autowired
    public TraiteurServiceImpl(TraiteurDAO traiteurDAO) {
        this.traiteurDAO = traiteurDAO;
    }

    @Override
    public Traiteur save(Traiteur traiteur) throws TraiteurDatabaseException {

        Optional.ofNullable(traiteur)
                .orElseThrow(() -> new TraiteurDatabaseException("Can not save null traiteur: " + traiteur));

        TraiteurEntity persistedTraiteurEntity= this.traiteurDAO.save(TraiteurMapper.INSTANCE.modelToEntity(traiteur));

        Optional.ofNullable(persistedTraiteurEntity)
                .orElseThrow(() -> new TraiteurDatabaseException("Persisted traiteur is null: " + persistedTraiteurEntity));

        return TraiteurMapper.INSTANCE.entityToModel(persistedTraiteurEntity);

    }

    @Override
    public Traiteur findByID(Long id) throws TraiteurDatabaseException {

        TraiteurEntity traiteurEntity= this.traiteurDAO.findByID(id)
                .orElseThrow(() -> new TraiteurDatabaseException("None traiteur found at id:" + id));

        return TraiteurMapper.INSTANCE.entityToModel(traiteurEntity);

    }

    @Override
    public Traiteur update(Traiteur traiteur) throws TraiteurDatabaseException {

        Optional.ofNullable(traiteur)
                .orElseThrow(() -> new TraiteurDatabaseException("Can not persist null traiteur: " + traiteur));

        if (traiteurDAO.existsById(traiteur.getServiceID())) {
            throw new TraiteurDatabaseException("Try to update into data base a traiteur that does not exist: " + traiteur);
        }

        TraiteurEntity traiteurEntity= traiteurDAO.save(TraiteurMapper.INSTANCE.modelToEntity(traiteur));


        Optional.ofNullable(traiteurEntity)
                .orElseThrow(() -> new TraiteurDatabaseException("Persisted traiteur is null: " + traiteurEntity));

        return TraiteurMapper.INSTANCE.entityToModel(traiteurEntity);
    }

    @Override
    public void deleteById(Long id) throws TraiteurDatabaseException {
        if (traiteurDAO.existsById(id)) {
            traiteurDAO.deleteById(id);
        } else {
            throw new TraiteurDatabaseException("None traiteur found at id: " + id);
        }
        if (traiteurDAO.existsById(id)) {
            throw new TraiteurDatabaseException("Failed to delete traiteur into database at id: " + id);
        }
    }


}
