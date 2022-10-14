package be.icc.ahe.marryme.model.mapper.dtomapper;

import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T17:16:26+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class RegistrationUserMapperImpl implements RegistrationUserMapper {

    @Override
    public Person dtotomodel(UserRegistrationFormDTO userRegistrationFormDTO) {
        if ( userRegistrationFormDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setLocalisation( userRegistrationFormDTOToAddress( userRegistrationFormDTO ) );
        person.setUser( userRegistrationFormDTOToUser( userRegistrationFormDTO ) );
        person.setPrenom( userRegistrationFormDTO.getFirstName() );
        person.setNom( userRegistrationFormDTO.getLastName() );
        if ( userRegistrationFormDTO.getPhone() != null ) {
            person.setNTel( Long.parseLong( userRegistrationFormDTO.getPhone() ) );
        }
        person.setEmail( userRegistrationFormDTO.getEmail() );

        return person;
    }

    protected Address userRegistrationFormDTOToAddress(UserRegistrationFormDTO userRegistrationFormDTO) {
        if ( userRegistrationFormDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setPays( userRegistrationFormDTO.getCountry() );
        address.setVille( userRegistrationFormDTO.getCity() );
        if ( userRegistrationFormDTO.getPostalCode() != null ) {
            address.setCodePostal( Integer.parseInt( userRegistrationFormDTO.getPostalCode() ) );
        }
        address.setRue( userRegistrationFormDTO.getStreet() );
        address.setNumero( userRegistrationFormDTO.getHouseNumber() );
        address.setBox( userRegistrationFormDTO.getBox() );

        return address;
    }

    protected User userRegistrationFormDTOToUser(UserRegistrationFormDTO userRegistrationFormDTO) {
        if ( userRegistrationFormDTO == null ) {
            return null;
        }

        User user = new User();

        user.setMdp( userRegistrationFormDTO.getPassword() );

        return user;
    }
}
