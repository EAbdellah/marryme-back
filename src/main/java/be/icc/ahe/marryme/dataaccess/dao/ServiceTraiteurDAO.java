package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.dataaccess.repository.ServiceTraiteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceTraiteurDAO {
    private final ServiceTraiteurRepo serviceTraiteurRepo;

    @Autowired
    public ServiceTraiteurDAO(ServiceTraiteurRepo serviceTraiteurRepo) {
        this.serviceTraiteurRepo = serviceTraiteurRepo;
    }

    public ServiceTraiteurEntity save(ServiceTraiteurEntity serviceTraiteurEntity){

        return serviceTraiteurRepo.save(serviceTraiteurEntity);
    }
}
