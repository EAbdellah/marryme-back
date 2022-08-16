package be.icc.ahe.marryme.model.mapper.dtomapper;

import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-16T01:51:58+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class RegistrationUserMapperImpl implements RegistrationUserMapper {

    @Override
    public User dtotomodel(UserRegistrationFormDTO userRegistrationFormDTO) {
        if ( userRegistrationFormDTO == null ) {
            return null;
        }

        User user = new User();

        user.setNom( userRegistrationFormDTO.getNom() );
        user.setPrenom( userRegistrationFormDTO.getPrenom() );
        user.setEmail( userRegistrationFormDTO.getEmail() );
        user.setNTel( userRegistrationFormDTO.getNTel() );
        user.setLogin( userRegistrationFormDTO.getLogin() );
        user.setMdp( userRegistrationFormDTO.getMdp() );

        return user;
    }
}
