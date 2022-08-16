package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.model.Fermeture;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-16T01:51:58+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class FermetureMapperImpl implements FermetureMapper {

    @Override
    public FermetureEntity entityToModel(Fermeture fermeture) {
        if ( fermeture == null ) {
            return null;
        }

        FermetureEntity fermetureEntity = new FermetureEntity();

        fermetureEntity.setId( fermeture.getId() );
        fermetureEntity.setDate( fermeture.getDate() );

        return fermetureEntity;
    }

    @Override
    public Fermeture modelToEntity(FermetureEntity fermetureEntity) {
        if ( fermetureEntity == null ) {
            return null;
        }

        Fermeture fermeture = new Fermeture();

        fermeture.setId( fermetureEntity.getId() );
        fermeture.setDate( fermetureEntity.getDate() );

        return fermeture;
    }
}
