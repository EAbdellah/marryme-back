package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.FormuleDAO;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.service.FormuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormuleServiceImpl implements FormuleService {

    private final FormuleDAO formuleDAO;

    @Autowired
    public FormuleServiceImpl(FormuleDAO formuleDAO) {
        this.formuleDAO = formuleDAO;
    }

    @Override
    public void save(FormuleEntity formuleEntity) throws Exception {
        formuleDAO.save(formuleEntity);
    }

    @Override
    public void deleteByID(Long id) throws Exception {
        formuleDAO.deleteByID(id);
    }

    @Override
    public FormuleEntity getByID(Long id) throws Exception {
        return formuleDAO.getByID(id);
    }


}
