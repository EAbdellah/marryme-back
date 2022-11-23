package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper( AddressMapper.class );

    AddressEntity modelToEntity(Address address);
    Address entityToModel(AddressEntity addressEntity);

    @Mapping(source = "country", target = "pays")
    @Mapping(source = "city", target = "ville")
    @Mapping(source = "postalCode", target = "codePostal")
    @Mapping(source = "street", target = "rue")
    @Mapping(source = "box", target = "box")
    @Mapping(source = "houseNumber", target = "numero")
    Address RegistrationProviderDtoToModel(ProviderRegisterFormDTO providerRegisterFormDTO);



}
