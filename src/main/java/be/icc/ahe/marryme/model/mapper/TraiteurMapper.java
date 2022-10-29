package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.model.ServiceTraiteur;
import be.icc.ahe.marryme.model.Traiteur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TraiteurMapper {
    TraiteurMapper INSTANCE = Mappers.getMapper( TraiteurMapper.class );

    Traiteur entityToModel(TraiteurEntity traiteurEntity);
    TraiteurEntity modelToEntity(Traiteur traiteur);

}
