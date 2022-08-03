package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.ServiceTraiteurDAO;
import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.service.ServiceTraiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTraiteurServiceImpl implements ServiceTraiteurService {

    private final ServiceTraiteurDAO serviceTraiteurDAO;

    @Autowired
    public ServiceTraiteurServiceImpl(ServiceTraiteurDAO serviceTraiteurDAO) {
        this.serviceTraiteurDAO = serviceTraiteurDAO;
    }

    @Override
    public void save(ServiceTraiteurEntity serviceTraiteurEntity) throws Exception {
        serviceTraiteurDAO.save(serviceTraiteurEntity);

    }
}
