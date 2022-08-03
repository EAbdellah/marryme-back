package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salle")
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
    private HallTypeEntity hallTypeEntity;

    @Column(name = "have_parking", nullable = false)
    private Boolean haveParking;

//    @OneToOne(targetEntity = ParkingEntity.class/*, cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "salleEntity",optional=true, orphanRemoval = true*/)
//    @JoinColumn(name="parking_id")

    @OneToOne(targetEntity = ParkingEntity.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "salleEntity")
    private ParkingEntity parkingEntity;

    public SalleEntity() {
    }

    public Integer getCapaciteTotal() {
        return capaciteTotal;
    }

    public void setCapaciteTotal(Integer capaciteTotal) {
        this.capaciteTotal = capaciteTotal;
    }

    public Integer getPlaceAssise() {
        return placeAssise;
    }

    public void setPlaceAssise(Integer placeAssise) {
        this.placeAssise = placeAssise;
    }

    public Boolean getPisteDance() {
        return pisteDance;
    }

    public void setPisteDance(Boolean pisteDance) {
        this.pisteDance = pisteDance;
    }

    public Boolean getDecoration() {
        return decoration;
    }

    public void setDecoration(Boolean decoration) {
        this.decoration = decoration;
    }

    public Boolean getMaterielMusique() {
        return materielMusique;
    }

    public void setMaterielMusique(Boolean materielMusique) {
        this.materielMusique = materielMusique;
    }

    public Boolean getTraiteur() {
        return traiteur;
    }

    public void setTraiteur(Boolean traiteur) {
        this.traiteur = traiteur;
    }

    public Boolean getCuisine() {
        return cuisine;
    }

    public void setCuisine(Boolean cuisine) {
        this.cuisine = cuisine;
    }

    public Boolean getExternal() {
        return isExternal;
    }

    public void setExternal(Boolean external) {
        isExternal = external;
    }

    public HallTypeEntity getHallTypeEntity() {
        return hallTypeEntity;
    }

    public void setHallTypeEntity(HallTypeEntity hallTypeEntity) {
        this.hallTypeEntity = hallTypeEntity;
    }

    public ParkingEntity getParkingEntity() {
        return parkingEntity;
    }

    public void setParkingEntity(ParkingEntity parkingEntity) {
        this.parkingEntity = parkingEntity;
    }

    public Boolean getHaveParking() {
        return haveParking;
    }

    public void setHaveParking(Boolean haveParking) {
        this.haveParking = haveParking;
    }


    @Override
    public String toString() {
        return "SalleEntity{" +
                "capaciteTotal=" + capaciteTotal +
                ", placeAssise=" + placeAssise +
                ", pisteDance=" + pisteDance +
                ", decoration=" + decoration +
                ", materielMusique=" + materielMusique +
                ", Traiteur=" + traiteur +
                ", cuisine=" + cuisine +
                ", isExternal=" + isExternal +

                '}';
    }
}
