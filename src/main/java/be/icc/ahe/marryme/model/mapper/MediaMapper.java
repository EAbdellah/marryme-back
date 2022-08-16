package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.model.MakeUpAndHair;
import be.icc.ahe.marryme.model.Media;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MediaMapper {
    MediaMapper INSTANCE = Mappers.getMapper( MediaMapper.class );

    MediaEntity entityToModel(Media media);
    Media modelToEntity(MediaEntity mediaEntity);

}
