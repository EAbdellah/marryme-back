package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import org.springframework.stereotype.Component;

@Component
public interface ServiceTraiteurService {
    void save(ServiceTraiteurEntity serviceTraiteurEntity) throws Exception;

}
