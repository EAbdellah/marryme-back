package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.TraiteurDAO;
import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.service.TraiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraiteurServiceImpl implements TraiteurService {

    private final TraiteurDAO traiteurDAO;

    @Autowired
    public TraiteurServiceImpl(TraiteurDAO traiteurDAO) {
        this.traiteurDAO = traiteurDAO;
    }

    @Override
    public void save(TraiteurEntity traiteurEntity) throws Exception {
        traiteurDAO.save(traiteurEntity);

    }
}
