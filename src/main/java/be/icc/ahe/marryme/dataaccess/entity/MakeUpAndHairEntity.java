package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.GetShortMakeUpAndAirServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@NamedNativeQuery(
        name  = "getMakeUpAndAirByProvider",
        query = "SELECT  service.service_id,service.presentation,service.nom,service.type,muah.do_hair,muah.do_make_up,muah.do_man,muah.do_woman " +
                "FROM ((((myschema.make_up_and_hair as muah " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = muah.service_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ;"
        ,
        resultSetMapping = "makeUpAndAirByProvider"
)

@SqlResultSetMapping(
        name = "makeUpAndAirByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortMakeUpAndAirServiceDTO.class,
                        columns = {
                                @ColumnResult(name = "service_id", type = Long.class),
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "do_hair", type = Boolean.class),
                                @ColumnResult(name = "do_make_up", type = Boolean.class),
                                @ColumnResult(name = "do_man", type = Boolean.class),
                                @ColumnResult(name = "do_woman", type = Boolean.class),
                                @ColumnResult(name = "presentation", type = String.class)

                        })
        }
)

@Entity
@Table(name = "make_up_and_hair")
@NoArgsConstructor
@Setter
@Getter
public class MakeUpAndHairEntity  extends ServiceEntity implements Serializable {

    @Column(name = "do_hair")
    private Boolean doHair;
    @Column(name = "do_make_up")
    private Boolean doMakeUp;
    @Column(name = "do_man")
    private Boolean doMan;
    @Column(name = "do_woman")
    private Boolean doWoman;
}
