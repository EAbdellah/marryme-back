package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.exception.SocieteDatabaseException;
import org.springframework.stereotype.Service;

@Service
public interface SocieteService {
    void save(SocieteEntity societeEntity) throws SocieteDatabaseException;

}
