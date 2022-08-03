package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import org.springframework.stereotype.Service;

@Service
public interface FormuleService {
    void save(FormuleEntity formuleEntity) throws Exception;
    void deleteByID(Long id) throws Exception;
    FormuleEntity getByID(Long id) throws Exception;

}
