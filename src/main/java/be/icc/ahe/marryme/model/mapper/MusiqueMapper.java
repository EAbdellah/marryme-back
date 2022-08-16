package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.model.Media;
import be.icc.ahe.marryme.model.Musique;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MusiqueMapper {
    MusiqueMapper INSTANCE = Mappers.getMapper( MusiqueMapper.class );

    MusiqueEntity entityToModel(Musique musique);
    Musique modelToEntity(MusiqueEntity musiqueEntity);

}
