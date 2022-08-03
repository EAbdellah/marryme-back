package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import org.springframework.stereotype.Service;

@Service
public interface MakeUpAndHairService {
    void save(MakeUpAndHairEntity makeUpAndHairEntity) throws Exception;

}
