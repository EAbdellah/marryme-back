package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.repository.FormuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormuleDAO {
    private final FormuleRepo formuleRepo;

    @Autowired
    public FormuleDAO(FormuleRepo formuleRepo) {
        this.formuleRepo = formuleRepo;
    }

    public FormuleEntity save(FormuleEntity formuleEntity){

        return formuleRepo.save(formuleEntity);
    }

    public void deleteByID(Long id){

         formuleRepo.deleteById(id);
    }

    public FormuleEntity getByID(Long id){

        return formuleRepo.getById(id);
    }

}
