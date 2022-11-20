package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.dto.GetShortFermetureDTO;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NamedNativeQuery(
        name  = "getAllFormuleByProvider",
        query = "SELECT formule.formule_id,formule.description,formule.is_unique_prix,formule.nom,formule.prix,formule.sup_dimanche,formule.sup_ferrier,formule.sup_samedi,formule.sup_veille_ferier,formule.supvendredi " +
                "FROM ((((myschema.formule as formule " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = formule.service_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email AND formule.is_active=true ;"
        ,
        resultSetMapping = "allFormuleByProvider"
)

@SqlResultSetMapping(
        name = "allFormuleByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortFormuleDTO.class,
                        columns = {
                                @ColumnResult(name = "formule_id", type = Long.class),
                                @ColumnResult(name = "description", type = String.class),
                                @ColumnResult(name = "is_unique_prix", type = Boolean.class),
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "prix", type = Integer.class),
                                @ColumnResult(name = "sup_dimanche", type = Integer.class),
                                @ColumnResult(name = "sup_ferrier", type = Integer.class),
                                @ColumnResult(name = "sup_samedi", type = Integer.class),
                                @ColumnResult(name = "sup_veille_ferier", type = Integer.class),
                                @ColumnResult(name = "supvendredi", type = Integer.class),



                        })
        }
)




@Entity
@Table(name = "formule")
@NoArgsConstructor
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "formuleID")
public class FormuleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formule_id", nullable = false)
    private Long formuleID;
    @Column(name = "nom", nullable = false, length = 128)
    private String nom;
    @Column(name = "prix", nullable = false)
    private Integer prix;
    @Column(name = "description", nullable = false, length = 128)
    private String description;
    @Column(name = "isUniquePrix", nullable = false)
    private Boolean isUniquePrix;
    @Column(name = "supFerrier", nullable = true)
    private Integer supFerrier;
    @Column(name = "supvendredi", nullable = true)
    private Integer supvendredi;
    @Column(name = "supSamedi", nullable = true)
    private Integer supSamedi;
    @Column(name = "supDimanche", nullable = true)
    private Integer supDimanche;
    @Column(name = "supVeilleFerier", nullable = true)
    private Integer supVeilleFerier;
    @Column(name = "isActive", nullable = true)
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY,cascade =CascadeType.ALL,mappedBy = "formule")
//    @JoinColumn(name="image_id")
    private List<ImageEntity> images;

    @JsonBackReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="service_id", updatable = false, insertable = false)
    @ToString.Exclude
    private ServiceEntity serviceEntity;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "formule")
//    @JoinColumn(name="reservation_id")
    @ToString.Exclude
    private List<ReservationEntity> reservation;


}
