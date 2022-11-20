package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.GetShortMusiqueServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NamedNativeQuery(
        name  = "getMusiqueByProvider",
        query = "SELECT service.service_id,service.nom,service.type,musique.musique_type " +
                "FROM ((((myschema.musique as musique  " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = musique.service_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ;"
        ,
        resultSetMapping = "musiqueByProvider"
)

@SqlResultSetMapping(
        name = "musiqueByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortMusiqueServiceDTO.class,
                        columns = {
                                @ColumnResult(name = "service_id", type = Long.class),
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "musique_type", type = String.class)

                        })
        }
)

@Entity
@Table(name = "musique")
@NoArgsConstructor

@Setter
@Getter


public class MusiqueEntity extends ServiceEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "musique_type")
    private MusiqueType musiqueType ;

    public MusiqueEntity(MusiqueType musiqueType) {
        this.musiqueType = musiqueType;
    }


}
