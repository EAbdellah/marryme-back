package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.Salle;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalleMapper {
    SalleMapper INSTANCE = Mappers.getMapper( SalleMapper.class );

    Salle entityToModel(SalleEntity salleEntity,
                        @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    SalleEntity modelToEntity(Salle salle,
                              @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(source = "service_id", target = "serviceID")
    @Mapping(source = "capacite_total", target = "capaciteTotal")
    @Mapping(source = "hall_type", target = "hallTypeEntity")
    @Mapping(source = "is_external", target = "isExternal")
    @Mapping(source = "piste_dance", target = "pisteDance")
    @Mapping(source = "place_assise", target = "placeAssise")
    @Mapping(source = "have_parking", target = "haveParking")
    @Mapping(source = "materiel_musique", target = "materielMusique")
    Salle dtoToModel(GetShortSalleServiceDTO form);


}
