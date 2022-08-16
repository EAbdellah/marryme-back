package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageMapper {
    ImageMapper INSTANCE = Mappers.getMapper( ImageMapper.class );

    ImageEntity entityToModel(Image image);
    Image modelToEntity(ImageEntity imageEntity);

}
