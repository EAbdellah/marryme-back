package be.icc.ahe.marryme.dataaccess.entity;

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
@Setter
@Getter
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
    private Integer codePostal;
    @Column(name = "supDimanche", nullable = true)
    private Integer supDimanche;
    @Column(name = "supVeilleFerier", nullable = true)
    private Integer supVeilleFerier;

    @OneToMany(mappedBy="formule",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ImageEntity> images;

    @ManyToOne( targetEntity = ServiceEntity.class, fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="service_id")
    private ServiceEntity serviceEntity;


}
