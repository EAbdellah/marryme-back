//package be.icc.ahe.marryme.model.mapper;
//
//import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
//import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
//import be.icc.ahe.marryme.model.Salle;
//import be.icc.ahe.marryme.model.Service;
//import org.mapstruct.Mapper;
//import org.mapstruct.ObjectFactory;
//import org.mapstruct.factory.Mappers;
//
//@Mapper
//public interface ServiceMapper {
//    ServiceMapper INSTANCE = Mappers.getMapper( ServiceMapper.class );
//
//    Service entityToModel(ServiceEntity serviceEntity);
//    ServiceEntity modelToEntity(Service Service);
//
//
//    default Service map(ServiceEntity serviceEntity) {
//        if (serviceEntity.getClass().equals(SalleEntity.class)) {
//            return new Salle();
//        }else
//            throw new IllegalArgumentException("Unknown media type.");
//
//    }
//
//    default ServiceEntity map(Service Service) {
//        if (Service.getClass().equals(Salle.class)) {
//            return new SalleEntity();
//        }else
//            throw new IllegalArgumentException("Unknown media type.");
//
//    }
//}
