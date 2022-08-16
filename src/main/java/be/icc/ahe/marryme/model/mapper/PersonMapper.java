package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );

    PersonEntity entityToModel(Person person);
    Person modelToEntity(PersonEntity personEntity);

}
