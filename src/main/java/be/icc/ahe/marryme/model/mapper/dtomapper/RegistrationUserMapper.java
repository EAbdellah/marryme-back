package be.icc.ahe.marryme.model.mapper.dtomapper;

import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationUserMapper {
    RegistrationUserMapper INSTANCE = Mappers.getMapper(RegistrationUserMapper.class);


    User dtotomodel(UserRegistrationFormDTO userRegistrationFormDTO);
}
