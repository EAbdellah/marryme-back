package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-20T03:32:04+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressEntity modelToEntity(Address address) {
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

    @Override
    public Address entityToModel(AddressEntity addressEntity) {
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

    @Override
    public Address RegistrationProviderDtoToModel(ProviderRegisterFormDTO providerRegisterFormDTO) {
        if ( providerRegisterFormDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setPays( providerRegisterFormDTO.getCountry() );
        address.setVille( providerRegisterFormDTO.getCity() );
        if ( providerRegisterFormDTO.getPostalCode() != null ) {
            address.setCodePostal( Integer.parseInt( providerRegisterFormDTO.getPostalCode() ) );
        }
        address.setRue( providerRegisterFormDTO.getStreet() );
        address.setNumero( providerRegisterFormDTO.getHouseNumber() );
        address.setBox( providerRegisterFormDTO.getBox() );

        return address;
    }
}
