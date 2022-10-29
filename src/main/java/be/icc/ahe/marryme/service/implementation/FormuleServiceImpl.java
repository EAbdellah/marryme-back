package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.FormuleDAO;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.exception.sqlexception.FormuleDatabaseException;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.mapper.FormuleMapper;
import be.icc.ahe.marryme.service.FormuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormuleServiceImpl implements FormuleService {

    private final FormuleDAO formuleDAO;

    @Autowired
    public FormuleServiceImpl(FormuleDAO formuleDAO) {
        this.formuleDAO = formuleDAO;
    }

    @Override
    public Formule save(Formule formule) throws FormuleDatabaseException {

        Optional.ofNullable(formule)
                .orElseThrow(() -> new FormuleDatabaseException("Can not persist null formule: " + formule));

        FormuleEntity persistedFormuleEntity = formuleDAO.save(FormuleMapper.INSTANCE.modelToEntity(formule));

        Optional.ofNullable(persistedFormuleEntity)
                .orElseThrow(() -> new FormuleDatabaseException("Persisted formule is null: " + persistedFormuleEntity));

        return FormuleMapper.INSTANCE.entityToModel(persistedFormuleEntity);

    }


    @Override
    public Formule findByID(Long id) throws FormuleDatabaseException {

        FormuleEntity formuleEntity = this.formuleDAO.findByID(id)
                .orElseThrow(() -> new FormuleDatabaseException("None formule found at id:" + id));

        return  FormuleMapper.INSTANCE.entityToModel(formuleEntity);

    }

    @Override
    public Formule update(Formule formule) throws FormuleDatabaseException {

        Optional.ofNullable(formule)
                .orElseThrow(() -> new FormuleDatabaseException("Can not persist null formule: " + formule));

        if (formuleDAO.existsById(formule.getFormuleID())){
            throw new FormuleDatabaseException("Try to update into data base a formule that does not exist: " + formule);
        }

        FormuleEntity peristedformuleEntity = formuleDAO.save(FormuleMapper.INSTANCE.modelToEntity(formule));


        Optional.ofNullable(peristedformuleEntity)
                .orElseThrow(() -> new FormuleDatabaseException("Persisted formule is null: " + peristedformuleEntity));

        return FormuleMapper.INSTANCE.entityToModel(peristedformuleEntity);
    }

    @Override
    public void deleteById(Long id) throws FormuleDatabaseException {
        if (formuleDAO.existsById(id)) {
            formuleDAO.deleteById(id);
        } else {
            throw new FormuleDatabaseException("None formule found at id: " + id);
        }
        if (formuleDAO.existsById(id)){
            throw new FormuleDatabaseException("Failed to delete formule into database at id: " + id);
        }
    }


}
