package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Societe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocieteMapper {

    SocieteMapper INSTANCE = Mappers.getMapper( SocieteMapper.class );

    SocieteEntity entityToModel(Societe societe);
    Societe modelToEntity(SocieteEntity societeEntity);
}
