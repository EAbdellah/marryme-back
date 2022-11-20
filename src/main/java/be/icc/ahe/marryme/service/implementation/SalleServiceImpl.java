package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.SalleDAO;
import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.exception.sqlexception.FermetureDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.SalleDatabaseException;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.Salle;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import be.icc.ahe.marryme.model.mapper.ReservationMapper;
import be.icc.ahe.marryme.model.mapper.SalleMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.Optional;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleDAO salleDAO;

    @Autowired
    public SalleServiceImpl(SalleDAO salleDAO) {
        this.salleDAO = salleDAO;
    }

    @Override
    public Salle save(Salle salle) throws SalleDatabaseException {

        Optional.ofNullable(salle)
                .orElseThrow(() -> new SalleDatabaseException("Can not save null salle: " + salle));

        SalleEntity persistedRSalleEntity = salleDAO.save(SalleMapper.INSTANCE.modelToEntity(salle,new CycleAvoidingMappingContext()));

        Optional.ofNullable(persistedRSalleEntity)
                .orElseThrow(() -> new SalleDatabaseException("Persisted salle is null: " + persistedRSalleEntity));

        return SalleMapper.INSTANCE.entityToModel(persistedRSalleEntity,new CycleAvoidingMappingContext());

    }

    @Override
    public Salle findByID(Long id) throws SalleDatabaseException {

        SalleEntity salleEntity= this.salleDAO.findByID(id)
                .orElseThrow(() -> new SalleDatabaseException("None salle found at id:" + id));

        return SalleMapper.INSTANCE.entityToModel(salleEntity,new CycleAvoidingMappingContext());

    }

    @Override
    public Salle update(Salle salle) throws SalleDatabaseException {

        Optional.ofNullable(salle)
                .orElseThrow(() -> new SalleDatabaseException("Can not persist null salle: " + salle));

        if (salleDAO.existsById(salle.getServiceID())) {
            throw new SalleDatabaseException("Try to update into data base a salle that does not exist: " + salle);
        }

        SalleEntity salleEntity = salleDAO.save(SalleMapper.INSTANCE.modelToEntity(salle,new CycleAvoidingMappingContext()));


        Optional.ofNullable(salleEntity)
                .orElseThrow(() -> new SalleDatabaseException("Persisted salle is null: " + salleEntity));

        return SalleMapper.INSTANCE.entityToModel(salleEntity,new CycleAvoidingMappingContext());
    }

    @Override
    public void deleteById(Long id) throws SalleDatabaseException {
        if (salleDAO.existsById(id)) {
            salleDAO.deleteById(id);
        } else {
            throw new SalleDatabaseException("None salle found at id: " + id);
        }
        if (salleDAO.existsById(id)) {
            throw new SalleDatabaseException("Failed to delete salle into database at id: " + id);
        }
    }

    @Override
    public GetShortSalleServiceDTO getSalleByProvider(String providerEmail) {
        return salleDAO.getSalleByProvider(providerEmail);
    }


}
