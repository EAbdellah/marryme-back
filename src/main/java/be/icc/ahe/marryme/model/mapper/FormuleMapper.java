package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.Formule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FormuleMapper {
    FormuleMapper INSTANCE = Mappers.getMapper( FormuleMapper.class );

    FormuleEntity entityToModel(Formule formule);
    Formule modelToEntity(FormuleEntity formuleEntity);

}
