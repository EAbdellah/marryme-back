package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.dataaccess.repository.MediaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MediaDAO {
    private final MediaRepo mediaRepo;

    @Autowired
    public MediaDAO(MediaRepo mediaRepo) {
        this.mediaRepo = mediaRepo;
    }

    public MediaEntity save(MediaEntity mediaEntity){

        return mediaRepo.save(mediaEntity);
    }
}
