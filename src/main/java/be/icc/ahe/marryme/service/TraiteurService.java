package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import org.springframework.stereotype.Service;

@Service
public interface TraiteurService {
    void save(TraiteurEntity traiteurEntity) throws Exception;

}
