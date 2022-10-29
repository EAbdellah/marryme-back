package be.icc.ahe.marryme.model.mapper;
import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.model.MakeUpAndHair;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MakeUpAndHairMapper {
    MakeUpAndHairMapper INSTANCE = Mappers.getMapper( MakeUpAndHairMapper.class );

    MakeUpAndHair entityToModel(MakeUpAndHairEntity makeUpAndHairEntity);
    MakeUpAndHairEntity modelToEntity(MakeUpAndHair makeUpAndHair);

}
