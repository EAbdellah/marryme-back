package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NamedNativeQuery(
        name  = "getTraiteurByProvider",
        query = "SELECT service.service_id,service.presentation,service.nom,service.type,traiteur.do_vegan,traiteur.do_fish,traiteur.do_meat,traiteur.do_vegetarian " +
                "FROM ((((myschema.traiteur as traiteur  " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = traiteur.service_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ; "
        ,
        resultSetMapping = "traiteurByProvider"
)

@SqlResultSetMapping(
        name = "traiteurByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortTraiteurServiceDTO.class,
                        columns = {

                                @ColumnResult(name = "service_id", type = Long.class),
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "do_vegan", type = Boolean.class),
                                @ColumnResult(name = "do_fish", type = Boolean.class),
                                @ColumnResult(name = "do_meat", type = Boolean.class),
                                @ColumnResult(name = "do_vegetarian", type = Boolean.class),
                                @ColumnResult(name = "presentation", type = String.class)

                        })
        }
)

@Entity
@Table(name = "traiteur")
@NoArgsConstructor
@Setter
@Getter

public class TraiteurEntity  extends ServiceEntity implements Serializable {

    @Column(name = "do_meat")
    private Boolean doMeat;
    @Column(name = "do_fish")
    private Boolean doFish;
    @Column(name = "do_vegan")
    private Boolean doVegan;
    @Column(name = "do_vegetarian")
    private Boolean DoVegetarian;

    public TraiteurEntity(Boolean doMeat) {
        this.doMeat = doMeat;
    }

  }
