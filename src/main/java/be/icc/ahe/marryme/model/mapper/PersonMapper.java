package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );

    @Mapping(source = "user", target = "userEntity")
    PersonEntity modelToEntity(Person person);

    @Mapping(source = "userEntity", target = "user")
    Person entityToModel(PersonEntity personEntity);

    @Mapping(source = "phone", target = "phoneNbr")
    Person RegistrationProviderDtoToModel(ProviderRegisterFormDTO providerRegisterFormDTO);

}
