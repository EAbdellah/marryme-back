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

    @Mapping(source = "firstName", target = "prenom")
    @Mapping(source = "lastName", target = "nom")
    @Mapping(source = "country", target = "localisation.pays")
    @Mapping(source = "city", target = "localisation.ville")
    @Mapping(source = "postalCode", target = "localisation.codePostal")
    @Mapping(source = "street", target = "localisation.rue")
    @Mapping(source = "houseNumber", target = "localisation.numero")
    @Mapping(source = "box", target = "localisation.box")
    @Mapping(source = "phone", target = "NTel")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "user.mdp")
    Person dtotomodel(UserRegistrationFormDTO userRegistrationFormDTO);
}
