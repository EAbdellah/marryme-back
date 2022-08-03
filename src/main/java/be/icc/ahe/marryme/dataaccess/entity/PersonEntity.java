package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Long personID;
    @Column(name = "nom", nullable = false, length = 128)
    private String nom;
    @Column(name = "prenom", nullable = false, length = 128)
    private String prenom;
    @Column(name = "email", nullable = false, length = 128)
    private String email;
    @Column(name = "nTel", nullable = false)
    private Long nTel;

//    @OneToOne(targetEntity = SocieteEntity.class, fetch = FetchType.EAGER)
//    @JoinColumn(name="societe_id")
//    private SocieteEntity societeEntity;

    @OneToOne(targetEntity = AddressEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="adress_id")
    private AddressEntity localisation;

    public PersonEntity() {
    }

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getnTel() {
        return nTel;
    }

    public void setnTel(Long nTel) {
        this.nTel = nTel;
    }

//    public SocieteEntity getSocieteEntity() {
//        return societeEntity;
//    }
//
//    public void setSocieteEntity(SocieteEntity societeEntity) {
//        this.societeEntity = societeEntity;
//    }

    public AddressEntity getLocalisation() {
        return localisation;
    }

    public void setLocalisation(AddressEntity localisation) {
        this.localisation = localisation;
    }
}
