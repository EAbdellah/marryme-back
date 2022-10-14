package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T17:16:26+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity modelToEntity(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setUserEntity( userToUserEntity( person.getUser() ) );
        personEntity.setPersonID( person.getPersonID() );
        personEntity.setNom( person.getNom() );
        personEntity.setPrenom( person.getPrenom() );
        personEntity.setEmail( person.getEmail() );
        personEntity.setNTel( person.getNTel() );
        personEntity.setLocalisation( addressToAddressEntity( person.getLocalisation() ) );

        return personEntity;
    }

    @Override
    public Person entityToModel(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        Person person = new Person();

        person.setUser( userEntityToUser( personEntity.getUserEntity() ) );
        person.setPersonID( personEntity.getPersonID() );
        person.setNom( personEntity.getNom() );
        person.setPrenom( personEntity.getPrenom() );
        person.setEmail( personEntity.getEmail() );
        person.setNTel( personEntity.getNTel() );
        person.setLocalisation( addressEntityToAddress( personEntity.getLocalisation() ) );

        return person;
    }

    protected UserEntity userToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setMdp( user.getMdp() );
        userEntity.setRole( user.getRole() );
        userEntity.setActive( user.isActive() );
        userEntity.setNonLocked( user.isNonLocked() );

        return userEntity;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setAdressID( address.getAdressID() );
        addressEntity.setPays( address.getPays() );
        addressEntity.setVille( address.getVille() );
        addressEntity.setCodePostal( address.getCodePostal() );
        addressEntity.setRue( address.getRue() );
        addressEntity.setNumero( address.getNumero() );
        addressEntity.setBox( address.getBox() );

        return addressEntity;
    }

    protected User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setMdp( userEntity.getMdp() );
        user.setRole( userEntity.getRole() );
        user.setActive( userEntity.isActive() );
        user.setNonLocked( userEntity.isNonLocked() );

        return user;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setAdressID( addressEntity.getAdressID() );
        address.setPays( addressEntity.getPays() );
        address.setVille( addressEntity.getVille() );
        address.setCodePostal( addressEntity.getCodePostal() );
        address.setRue( addressEntity.getRue() );
        address.setNumero( addressEntity.getNumero() );
        address.setBox( addressEntity.getBox() );

        return address;
    }
}
