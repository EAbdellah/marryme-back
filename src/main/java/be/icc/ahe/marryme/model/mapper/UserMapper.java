package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Traiteur;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserEntity modelToEntity(User user,
                             @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    User entityToModel(UserEntity userEntity,
                       @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(source = "email_entreprise", target = "email")
    User RegistrationProviderDtoToModel(ProviderRegisterFormDTO providerRegisterFormDTO);


}
