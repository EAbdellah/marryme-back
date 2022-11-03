package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.Reservation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "formule")
@NoArgsConstructor
@Data
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

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="formule_id")
    private List<ImageEntity> images;

    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="service_id")
    private ServiceEntity serviceEntity;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="reservation_id")
    private List<ReservationEntity> reservation;




}
