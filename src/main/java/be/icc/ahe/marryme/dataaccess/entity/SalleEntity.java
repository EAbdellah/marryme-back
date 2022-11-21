package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.HallType;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NamedNativeQuery(
        name  = "getSalleByProvider",
        query = "SELECT service.service_id,service.presentation,service.nom,service.type,salle.capacite_total," +
                "salle.cuisine," +
                "salle.decoration,"+
                "salle.hall_type,"+
                "salle.have_parking,salle.is_external," +
                "salle.materiel_musique," +
                "salle.piste_dance," +
                "salle.place_assise," +
                "salle.traiteur," +
                "parking.capacity " +
                ",parking.voiturier " +
                "FROM (((((myschema.salle as salle " +
                "LEFT OUTER JOIN myschema.parking as parking ON parking.service_id  = salle.service_id) " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = salle.service_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ; "
        ,
        resultSetMapping = "salleByProvider"
)

@SqlResultSetMapping(
        name = "salleByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortSalleServiceDTO.class,
                        columns = {

                                @ColumnResult(name = "service_id", type = Long.class),
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "capacite_total", type = Integer.class),
                                @ColumnResult(name = "cuisine", type = Boolean.class),
                                @ColumnResult(name = "decoration", type = Boolean.class),
                                @ColumnResult(name = "hall_type", type = String.class),
                                @ColumnResult(name = "have_parking", type = Boolean.class),
                                @ColumnResult(name = "is_external", type = Boolean.class),
                                @ColumnResult(name = "materiel_musique", type = Boolean.class),
                                @ColumnResult(name = "piste_dance", type = Boolean.class),
                                @ColumnResult(name = "place_assise", type = Integer.class),
                                @ColumnResult(name = "traiteur", type = Boolean.class),
                                @ColumnResult(name = "capacity", type = Integer.class),
                                @ColumnResult(name = "voiturier", type = Boolean.class),
                                @ColumnResult(name = "presentation", type = String.class)

                        })
        }
)


@Entity
@Table(name = "salle")
@NoArgsConstructor
@Setter
@Getter

public class SalleEntity extends ServiceEntity implements Serializable {

    @Column(name = "capacite_total")
    private Integer capaciteTotal;
    @Column(name = "place_assise")
    private Integer placeAssise;
    @Column(name = "piste_dance")
    private Boolean pisteDance;
    @Column(name = "decoration")
    private Boolean decoration;
    @Column(name = "materiel_musique")
    private Boolean materielMusique;
    @Column(name = "traiteur")
    private Boolean traiteur;
    @Column(name = "cuisine")
    private Boolean cuisine;
    @Column(name = "is_external")
    private Boolean isExternal;
    @Enumerated(EnumType.STRING)
    @Column(name = "hall_type")
    private HallType hallTypeEntity;

    @Column(name = "have_parking")
    private Boolean haveParking;

//    @OneToOne(targetEntity = ParkingEntity.class/*, cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "salleEntity",optional=true, orphanRemoval = true*/)
//    @JoinColumn(name="parking_id")

    @OneToOne(targetEntity = ParkingEntity.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "salleEntity")
    private ParkingEntity parkingEntity;

}


