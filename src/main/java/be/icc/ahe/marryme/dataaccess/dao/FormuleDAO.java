package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.repository.FormuleRepo;
import be.icc.ahe.marryme.exception.sqlexception.FormuleDatabaseException;
import be.icc.ahe.marryme.model.dto.GetShortFermetureDTO;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Component
public class FormuleDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(FermetureDAO.class);
    private final FormuleRepo formuleRepo;

    @Autowired
    public FormuleDAO(FormuleRepo formuleRepo) {
        this.formuleRepo = formuleRepo;
    }


    public FormuleEntity save(FormuleEntity formuleEntity){
        return formuleRepo.save(formuleEntity);
    }

    public Optional<FormuleEntity> findByID(Long id){
        return formuleRepo.findById(id);
    }



    public void deleteById(Long id)  {
            formuleRepo.deleteById(id);
    }
    public boolean existsById(Long id){
        return formuleRepo.existsById(id);
    }

    public List<GetShortFormuleDTO> getAllFormuleByProvider(String email){
        return formuleRepo.getAllFormuleByProvider(email);
    }


}
