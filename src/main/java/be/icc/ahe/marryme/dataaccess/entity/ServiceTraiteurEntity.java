package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortServiceTraiteurServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NamedNativeQuery(
        name  = "getServiceTraiteurByProvider",
        query = "SELECT service.service_id,service.presentation,service.nom,service.type,Straiteur.man_only,Straiteur.woman_only " +
                "FROM ((((myschema.service_traiteur as Straiteur  " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = Straiteur.service_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ; "
        ,
        resultSetMapping = "serviceTraiteurByProvider"
)

@SqlResultSetMapping(
        name = "serviceTraiteurByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortServiceTraiteurServiceDTO.class,
                        columns = {

                                @ColumnResult(name = "service_id", type = Long.class),
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "man_only", type = Boolean.class),
                                @ColumnResult(name = "woman_only", type = Boolean.class),
                                @ColumnResult(name = "presentation", type = String.class)
                        })
        }
)
@Entity
@Table(name = "service_traiteur")
@NoArgsConstructor
@Setter
@Getter

public class ServiceTraiteurEntity extends ServiceEntity implements Serializable {

    @Column(name = "man_only")
    private Boolean manOnly;
    @Column(name = "woman_only")
    private Boolean womanOnly;

    }
