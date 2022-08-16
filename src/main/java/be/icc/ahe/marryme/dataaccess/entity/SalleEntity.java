package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.HallType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salle")
@NoArgsConstructor
@Setter
@Getter

public class SalleEntity extends ServiceEntity implements Serializable {

    @Column(name = "capacite_total", nullable = false)
    private Integer capaciteTotal;
    @Column(name = "place_assise", nullable = false)
    private Integer placeAssise;
    @Column(name = "piste_dance", nullable = false)
    private Boolean pisteDance;
    @Column(name = "decoration", nullable = false)
    private Boolean decoration;
    @Column(name = "materiel_musique", nullable = false)
    private Boolean materielMusique;
    @Column(name = "traiteur", nullable = false)
    private Boolean traiteur;
    @Column(name = "cuisine", nullable = false)
    private Boolean cuisine;
    @Column(name = "is_external", nullable = false)
    private Boolean isExternal;
    @Enumerated(EnumType.STRING)
    @Column(name = "hall_type")
    private HallType hallTypeEntity;

    @Column(name = "have_parking", nullable = false)
    private Boolean haveParking;

//    @OneToOne(targetEntity = ParkingEntity.class/*, cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "salleEntity",optional=true, orphanRemoval = true*/)
//    @JoinColumn(name="parking_id")

    @OneToOne(targetEntity = ParkingEntity.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "salleEntity")
    private ParkingEntity parkingEntity;

 }
