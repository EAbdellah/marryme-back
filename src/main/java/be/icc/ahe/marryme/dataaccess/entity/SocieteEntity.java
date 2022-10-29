package be.icc.ahe.marryme.dataaccess.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "societe")
@NoArgsConstructor
 @Getter @Setter
public class SocieteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "societe_id", nullable = false)
    private Long societeID;
    @Column(name = "n_tva", nullable = false)
    private Long nTVA;
    @Column(name = "n_entreprise", nullable = false)
    private Long nEntreprise;
    @Column(name = "nom", nullable = false, length = 128)
    private String nom;
    @Column(name = "email", nullable = false, length = 128)
    private String email;
    @Column(name = "nTel", nullable = false)
    private Long nTel;

    @OneToOne(targetEntity = AddressEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="adress_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AddressEntity localisation;

    @OneToOne(targetEntity = PersonEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="person_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PersonEntity owner;

    @OneToOne(targetEntity = ServiceEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="service_id")
    private ServiceEntity service;



//    public Long getSocieteID() {
//        return societeID;
//    }
//
//    public void setSocieteID(Long societeID) {
//        this.societeID = societeID;
//    }
//
//    public Long getnTVA() {
//        return nTVA;
//    }
//
//    public void setnTVA(Long nTVA) {
//        this.nTVA = nTVA;
//    }
//
//    public Long getnEntreprise() {
//        return nEntreprise;
//    }
//
//    public void setnEntreprise(Long nEntreprise) {
//        this.nEntreprise = nEntreprise;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Long getnTel() {
//        return nTel;
//    }
//
//    public void setnTel(Long nTel) {
//        this.nTel = nTel;
//    }
//
//    public AddressEntity getLocalisation() {
//        return localisation;
//    }
//
//    public void setLocalisation(AddressEntity localisation) {
//        this.localisation = localisation;
//    }
//
//    public PersonEntity getOwner() {
//        return owner;
//    }
//
//    public void setOwner(PersonEntity owner) {
//        this.owner = owner;
//    }
}
