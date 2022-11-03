package be.icc.ahe.marryme.model.mapper.dtomapper;

import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.Service;
import be.icc.ahe.marryme.model.dto.SingleServiceViewDTO;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceViewMapper {
    ServiceViewMapper INSTANCE = Mappers.getMapper(ServiceViewMapper.class);
    SingleServiceViewDTO entityToDTO(ServiceEntity serviceEntity,
                                     @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);


}
