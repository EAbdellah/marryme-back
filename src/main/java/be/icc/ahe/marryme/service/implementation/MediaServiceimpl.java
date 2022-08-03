package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.MediaDAO;
import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaServiceimpl implements MediaService {

    private final MediaDAO mediaDAO;

    @Autowired
    public MediaServiceimpl(MediaDAO mediaDAO) {
        this.mediaDAO = mediaDAO;
    }

    @Override
    public void save(MediaEntity mediaEntity) throws Exception {
        mediaDAO.save(mediaEntity);
    }
}
