package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.Traiteur;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserEntity modelToEntity(User user,
                             @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    User entityToModel(UserEntity userEntity,
                       @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

}
