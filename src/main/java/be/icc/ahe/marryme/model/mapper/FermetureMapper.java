package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Fermeture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FermetureMapper {

    FermetureMapper INSTANCE = Mappers.getMapper( FermetureMapper.class );

    Fermeture entityToModel(FermetureEntity fermetureEntity);
    FermetureEntity modelToEntity(Fermeture fermeture);

}
