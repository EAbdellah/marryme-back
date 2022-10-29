package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.MediaDAO;
import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.exception.sqlexception.MediaDatabaseException;
import be.icc.ahe.marryme.model.Media;
import be.icc.ahe.marryme.model.mapper.MediaMapper;
import be.icc.ahe.marryme.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MediaServiceimpl implements MediaService {

    private final MediaDAO mediaDAO;

    @Autowired
    public MediaServiceimpl(MediaDAO mediaDAO) {
        this.mediaDAO = mediaDAO;
    }



    @Override
    public Media save(Media media) throws MediaDatabaseException {

        Optional.ofNullable(media)
                .orElseThrow(() -> new MediaDatabaseException("Can not persist null media: " + media));

        MediaEntity persistedMediaEntity = mediaDAO.save(MediaMapper.INSTANCE.modelToEntity(media));

        Optional.ofNullable(persistedMediaEntity)
                .orElseThrow(() -> new MediaDatabaseException("Persisted media is null: " + persistedMediaEntity));

        return MediaMapper.INSTANCE.entityToModel(persistedMediaEntity);

    }

    @Override
    public Media findByID(Long id) throws MediaDatabaseException {

        MediaEntity mediaEntity = this.mediaDAO.findByID(id)
                .orElseThrow(() -> new MediaDatabaseException("None media found at id:" + id));

        return MediaMapper.INSTANCE.entityToModel(mediaEntity);

    }

    @Override
    public Media update(Media media) throws MediaDatabaseException {

        Optional.ofNullable(media)
                .orElseThrow(() -> new MediaDatabaseException("Can not persist null media: " + media));

        if (mediaDAO.existsById(media.getServiceID())) {
            throw new MediaDatabaseException("Try to update into data base a media that does not exist: " + media);
        }

        MediaEntity persistedMediaEntity = mediaDAO.save(MediaMapper.INSTANCE.modelToEntity(media));


        Optional.ofNullable(persistedMediaEntity)
                .orElseThrow(() -> new MediaDatabaseException("Persisted media is null: " + persistedMediaEntity));

        return MediaMapper.INSTANCE.entityToModel(persistedMediaEntity);
    }

    @Override
    public void deleteById(Long id) throws MediaDatabaseException {
        if (mediaDAO.existsById(id)) {
            mediaDAO.deleteById(id);
        } else {
            throw new MediaDatabaseException("None media found at id: " + id);
        }
        if (mediaDAO.existsById(id)) {
            throw new MediaDatabaseException("Failed to delete media into database at id: " + id);
        }
    }
}
