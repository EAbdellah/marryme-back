package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import org.springframework.stereotype.Service;

@Service
public interface MediaService {
    void save(MediaEntity mediaEntity) throws Exception;

}
