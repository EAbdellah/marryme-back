package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.Reservation;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    @OneToMany(fetch = FetchType.LAZY,cascade =CascadeType.ALL,mappedBy = "formule", orphanRemoval = true)
//    @JoinColumn(name="image_id")
    private List<ImageEntity> images;

    @JsonBackReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="service_id")
    @ToString.Exclude
    private ServiceEntity serviceEntity;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "formule", orphanRemoval = true)
//    @JoinColumn(name="reservation_id")
    @ToString.Exclude
    private List<ReservationEntity> reservation;


}
