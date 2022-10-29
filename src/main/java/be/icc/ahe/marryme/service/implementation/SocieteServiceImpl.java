package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.SocieteDAO;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.exception.sqlexception.SocieteDatabaseException;
import be.icc.ahe.marryme.model.Societe;
import be.icc.ahe.marryme.model.mapper.SocieteMapper;
import be.icc.ahe.marryme.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocieteServiceImpl implements SocieteService {

    private final SocieteDAO societeDAO;

    @Autowired
    public SocieteServiceImpl(SocieteDAO societeDAO) {
        this.societeDAO = societeDAO;
    }


    @Override
    public Societe save(Societe societe) throws SocieteDatabaseException {

        Optional.ofNullable(societe)
                .orElseThrow(() -> new SocieteDatabaseException("Can not save null societe: " + societe));

        SocieteEntity persistedSocieteEntity= societeDAO.save(SocieteMapper.INSTANCE.modelToEntity(societe));

        Optional.ofNullable(persistedSocieteEntity)
                .orElseThrow(() -> new SocieteDatabaseException("Persisted societe is null: " + persistedSocieteEntity));

        return SocieteMapper.INSTANCE.entityToModel(persistedSocieteEntity);

    }

    @Override
    public Societe findByID(Long id) throws SocieteDatabaseException {

        SocieteEntity societeEntity= this.societeDAO.findByID(id)
                .orElseThrow(() -> new SocieteDatabaseException("None societe found at id:" + id));

        return SocieteMapper.INSTANCE.entityToModel(societeEntity);

    }

    @Override
    public Societe update(Societe societe) throws SocieteDatabaseException {

        Optional.ofNullable(societe)
                .orElseThrow(() -> new SocieteDatabaseException("Can not persist null societe: " + societe));

        if (societeDAO.existsById(societe.getSocieteID())) {
            throw new SocieteDatabaseException("Try to update into data base a societe that does not exist: " + societe);
        }

        SocieteEntity societeEntity= societeDAO.save(SocieteMapper.INSTANCE.modelToEntity(societe));


        Optional.ofNullable(societeEntity)
                .orElseThrow(() -> new SocieteDatabaseException("Persisted societe is null: " + societeEntity));

        return SocieteMapper.INSTANCE.entityToModel(societeEntity);
    }

    @Override
    public void deleteById(Long id) throws SocieteDatabaseException {
        if (societeDAO.existsById(id)) {
            societeDAO.deleteById(id);
        } else {
            throw new SocieteDatabaseException("None societe found at id: " + id);
        }
        if (societeDAO.existsById(id)) {
            throw new SocieteDatabaseException("Failed to delete societe into database at id: " + id);
        }
    }


}
