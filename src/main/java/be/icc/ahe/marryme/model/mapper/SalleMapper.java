package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.Salle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalleMapper {
    SalleMapper INSTANCE = Mappers.getMapper( SalleMapper.class );

    Salle entityToModel(SalleEntity salleEntity);
    SalleEntity modelToEntity(Salle salle);

}
