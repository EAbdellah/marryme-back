package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.dto.GetShortFermetureDTO;
import be.icc.ahe.marryme.model.dto.ReservationClientDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;


@NamedNativeQuery(
        name  = "getAllFermetureByProvider",
        query = "SELECT  fermeture.date " +
                "FROM (((((myschema.abstract_service as service " +
                "INNER JOIN myschema.fermeture_service as fermeser ON service.service_id  = fermeser.service_id) " +
                "INNER JOIN myschema.fermeture as fermeture ON fermeser.fermeture_date_id  = fermeture.fermeture_date_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ; "
        ,
        resultSetMapping = "allFermetureByProvider"
)

@SqlResultSetMapping(
        name = "allFermetureByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortFermetureDTO.class,
                        columns = {
                                @ColumnResult(name = "date", type = java.util.Date.class),

                        })
        }
)


@Entity
@Table(name = "fermeture")
@NoArgsConstructor
@Setter
@Getter
public class FermetureEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fermeture_date_id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

//    @ManyToMany(targetEntity =ServiceEntity0 ,cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE},fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "fermeture_service",
//            joinColumns = { @JoinColumn(name = "fermeture_date_id") },
//            inverseJoinColumns = { @JoinColumn(name = "service_id") }
//    )
    @ManyToMany(mappedBy = "fermetures", fetch = FetchType.LAZY)
    @JsonBackReference
Collection <ServiceEntity> serviceEntity = new HashSet<>();

}
