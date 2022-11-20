package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.listerner.AuditListener;
import be.icc.ahe.marryme.model.dto.ProviderRequestRegistrationDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NamedNativeQuery(
        name  = "getAllProviderRequestRegistration",
        query = "SELECT  societe.nom, societe.n_tva as ntva, societe.n_entreprise as nentreprise ,  userr.email as email  ,person.first_name as fristName, person.last_name as LastName " +
                "FROM ((myschema.person as person " +
                "INNER JOIN myschema.societe as societe ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as userr ON userr.user_id  = person.user_id) " +
                "Where userr.is_active = 0 AND societe.decision_registration= \"WAITING\" ;"
        ,
        resultSetMapping = "allProviderRequestRegistration"
)

@SqlResultSetMapping(
        name = "allProviderRequestRegistration",
        classes = {
                @ConstructorResult(
                        targetClass = ProviderRequestRegistrationDTO.class,
                        columns = {
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "ntva", type = String.class),
                                @ColumnResult(name = "nentreprise", type = Long.class),
                                @ColumnResult(name = "email", type = String.class),
                                @ColumnResult(name = "fristName", type = String.class),
                                @ColumnResult(name = "LastName", type = String.class),
                        })
        }
)


@Entity
@Table(name = "societe")
@NoArgsConstructor
@Data
@EntityListeners(AuditListener.class)
public class SocieteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "societe_id", nullable = false)
    private Long societeID;
    @Column(name = "n_tva", nullable = false)
    private String nTVA;
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
    private PersonEntity owner;

    @OneToOne(targetEntity = ServiceEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="service_id")
    private ServiceEntity service;

    @Column(name="decision_registration")
    private String decisionRegistration;

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
