package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.HallType;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;
import be.icc.ahe.marryme.model.dto.AllServicesDTO;
import be.icc.ahe.marryme.model.dto.GetShortMusiqueServiceDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "AbstractService")
@NoArgsConstructor
@Data


//@NamedNativeQuery(
//        name  = "getIdService",
//        query = "SELECT service.service_id,service.nom,service.type,musique.musique_type " +
//                "FROM ((((myschema.musique as musique  " +
//                "INNER JOIN myschema.abstract_service as service ON service.service_id  = musique.service_id) " +
//                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
//                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
//                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
//                "Where user.email = :provider_email ;"
//        ,
//        resultSetMapping = "musiqueByProvider"
//)
//
//@SqlResultSetMapping(
//        name = "musiqueByProvider",
//        classes = {
//                @ConstructorResult(
//                        targetClass = GetShortMusiqueServiceDTO.class,
//                        columns = {
//                                @ColumnResult(name = "service_id", type = Long.class),
//                                @ColumnResult(name = "nom", type = String.class),
//                                @ColumnResult(name = "type", type = String.class),
//                                @ColumnResult(name = "musique_type", type = String.class)
//
//                        })
//        }
//)


@NamedNativeQuery(
        name  = "getAllServices",
        query = "SELECT ase.service_id,ase.presentation,ase.type,ase.nom,ase.image_id," +
                "ma.do_hair,ma.do_make_up,ma.do_man,ma.do_woman," +
                "me.is_photo,me.is_video,me.do_album,me.do_souvenir," +
                "mu.musique_type," +
                "sa.capacite_total,sa.place_assise,sa.piste_dance,sa.decoration," +
                "sa.materiel_musique,sa.traiteur,sa.cuisine,sa.is_external," +
                "sa.hall_type,sa.have_parking," +
                "se.man_only,se.woman_only," +
                "tr.do_meat,tr.do_fish,tr.do_vegan,tr.do_vegetarian, " +
                "case "+
                "when ma.service_id is not null then 1 " +
                "when me.service_id is not null then 2 " +
                "when mu.service_id is not null then 3 " +
                "when sa.service_id is not null then 4 " +
                "when se.service_id is not null then 5 " +
                "when tr.service_id is not null then 6 " +
                "else 0 " +
                "end as clazz_ " +
                "from " +
                "abstract_service ase " +
                "left join make_up_and_hair ma on ase.service_id = ma.service_id " +
                "left join media me on ase.service_id = me.service_id "+
                "left join musique mu on ase.service_id = mu.service_id "+
                "left join salle sa on ase.service_id = sa.service_id "+
                "left join service_traiteur se on ase.service_id = se.service_id "+
                "left join traiteur tr on ase.service_id = tr.service_id "+
        " GROUP BY nom;"
        ,
        resultSetMapping = "AllServices"
//        resultClass = Object.class
)

@SqlResultSetMapping(
        name = "AllServices",
        classes = {
                @ConstructorResult(
                        targetClass = AllServicesDTO.class,
                        columns = {
                                @ColumnResult(name = "service_id", type = Long.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "image_id", type = ImageEntity.class),
                                @ColumnResult(name = "do_hair", type = Boolean.class),
                                @ColumnResult(name = "do_make_up", type = Boolean.class),
                                @ColumnResult(name = "do_man", type = Boolean.class),
                                @ColumnResult(name = "do_woman", type = Boolean.class),
                                @ColumnResult(name = "is_photo", type = Boolean.class),
                                @ColumnResult(name = "is_video", type = Boolean.class),
                                @ColumnResult(name = "do_album", type = Boolean.class),
                                @ColumnResult(name = "do_souvenir", type = Boolean.class),
                                @ColumnResult(name = "musique_type", type = String.class),
                                @ColumnResult(name = "capacite_total", type = Integer.class),
                                @ColumnResult(name = "place_assise", type = Integer.class),
                                @ColumnResult(name = "piste_dance", type = Boolean.class),
                                @ColumnResult(name = "decoration", type = Boolean.class),
                                @ColumnResult(name = "materiel_musique", type = Boolean.class),
                                @ColumnResult(name = "traiteur", type = Boolean.class),
                                @ColumnResult(name = "cuisine", type = Boolean.class),
                                @ColumnResult(name = "is_external", type = Boolean.class),
                                @ColumnResult(name = "hall_type", type = String.class),
                                @ColumnResult(name = "have_parking", type = Boolean.class),
                                @ColumnResult(name = "man_only", type = Boolean.class),
                                @ColumnResult(name = "woman_only", type = Boolean.class),
                                @ColumnResult(name = "do_meat", type = Boolean.class),
                                @ColumnResult(name = "do_fish", type = Boolean.class),
                                @ColumnResult(name = "do_vegan", type = Boolean.class),
                                @ColumnResult(name = "do_vegetarian", type = Boolean.class),
                                @ColumnResult(name = "presentation", type = String.class),

                        })
        }
)






@AllArgsConstructor
public abstract class ServiceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id", nullable = false)
    private Long serviceID;

    @Column(name = "type", nullable = false)
    private String type = getClass().getSimpleName();

    @Column(name = "nom", updatable = false)
    private String nom;

    @OneToOne(targetEntity = AddressEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "adress_id", nullable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AddressEntity address;

    @OneToMany(targetEntity = FormuleEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name="service_id")
    private List<FormuleEntity> formules ;

    @OneToMany(mappedBy = "serviceEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ReservationEntity> reservationEntities = new ArrayList<>();


    @ManyToMany(targetEntity = FermetureEntity.class, fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "fermeture_service",
            joinColumns = {@JoinColumn(name = "service_id")},
            inverseJoinColumns = {@JoinColumn(name = "fermeture_date_id")}
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference
    private Collection<FermetureEntity> fermetures = new HashSet<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(targetEntity = ImageEntity.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "image_id")
    private ImageEntity image;

    @Column(name = "presentation")
    private String presentation;



}
