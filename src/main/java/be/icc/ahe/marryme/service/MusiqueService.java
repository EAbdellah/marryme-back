package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import org.springframework.stereotype.Service;

@Service
public interface MusiqueService {
    void save(MusiqueEntity musiqueEntity) throws Exception;
}
