package be.icc.ahe.marryme.model.mapper.dtomapper;

import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationUserMapper {
    RegistrationUserMapper INSTANCE = Mappers.getMapper(RegistrationUserMapper.class);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "country", target = "localisation.pays")
    @Mapping(source = "city", target = "localisation.ville")
    @Mapping(source = "postalCode", target = "localisation.codePostal")
    @Mapping(source = "street", target = "localisation.rue")
    @Mapping(source = "houseNumber", target = "localisation.numero")
    @Mapping(source = "box", target = "localisation.box")
    @Mapping(source = "phone", target = "phoneNbr")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "password", target = "user.password")
    Person dtotomodel(UserRegistrationFormDTO userRegistrationFormDTO);
}
