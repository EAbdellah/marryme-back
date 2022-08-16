package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-16T01:51:57+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity modelToEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setPersonID( user.getPersonID() );
        userEntity.setNom( user.getNom() );
        userEntity.setPrenom( user.getPrenom() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setNTel( user.getNTel() );
        userEntity.setLocalisation( addressToAddressEntity( user.getLocalisation() ) );
        userEntity.setLogin( user.getLogin() );
        userEntity.setMdp( user.getMdp() );
        userEntity.setRole( user.getRole() );

        return userEntity;
    }

    @Override
    public User entityToModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setPersonID( userEntity.getPersonID() );
        user.setNom( userEntity.getNom() );
        user.setPrenom( userEntity.getPrenom() );
        user.setEmail( userEntity.getEmail() );
        user.setNTel( userEntity.getNTel() );
        user.setLocalisation( addressEntityToAddress( userEntity.getLocalisation() ) );
        user.setLogin( userEntity.getLogin() );
        user.setMdp( userEntity.getMdp() );
        user.setRole( userEntity.getRole() );

        return user;
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
