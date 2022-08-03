package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@MappedSuperclass
@Table(name = "AbstractService")
public abstract class ServiceEntity  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id", nullable = false)
    private Long ServiceID;

    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToOne(targetEntity = AddressEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="adress_id",nullable = false)
    private AddressEntity serviceAdress;

    @OneToOne(targetEntity = SocieteEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name="societe_id",nullable = false)
    private SocieteEntity societe;

    @OneToMany( mappedBy="serviceEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FormuleEntity> formuleEntities = new ArrayList<>();

    @OneToMany(mappedBy="serviceEntity",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<ReservationEntity> reservationEntities = new ArrayList<>();


    @ManyToMany(targetEntity =FermetureEntity.class ,fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "fermeture_service",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "fermeture_date_id") }
    )
    private Collection<FermetureEntity> fermetures = new HashSet<>() ;



@OneToOne(targetEntity = ImageEntity.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "serviceEntity")
private ImageEntity image;


    public ServiceEntity() {
    }

    public Long getServiceID() {
        return ServiceID;
    }

    public void setServiceID(Long serviceID) {
        ServiceID = serviceID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public AddressEntity getServiceAdress() {
        return serviceAdress;
    }

    public void setServiceAdress(AddressEntity serviceAdress) {
        this.serviceAdress = serviceAdress;
    }

    public SocieteEntity getSociete() {
        return societe;
    }

    public void setSociete(SocieteEntity societe) {
        this.societe = societe;
    }

    public List<FormuleEntity> getFormuleEntities() {
        return formuleEntities;
    }

    public void setFormuleEntities(List<FormuleEntity> formuleEntities) {
        this.formuleEntities.clear();
        this.formuleEntities.addAll(formuleEntities);

//        this.formuleEntities = formuleEntities;
    }

    public Collection<FermetureEntity> getFermetures() {
        return fermetures;
    }

    public void setFermetures(Collection<FermetureEntity> fermetures) {
//        this.fermetures.clear();
//        this.fermetures.addAll(fermetures);
        this.fermetures = fermetures;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public List<ReservationEntity> getReservationEntities() {
        return reservationEntities;
    }

    public void setReservationEntities(List<ReservationEntity> reservationEntities) {
        this.reservationEntities = reservationEntities;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "ServiceID=" + ServiceID +
                ", nom='" + nom + '\'' +
                ", serviceAdress=" + serviceAdress +
                ", societe=" + societe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceEntity)) return false;
        ServiceEntity that = (ServiceEntity) o;
        return Objects.equals(getServiceID(), that.getServiceID()) &&
                Objects.equals(getNom(), that.getNom()) &&
                Objects.equals(getServiceAdress(), that.getServiceAdress()) &&
                Objects.equals(getSociete(), that.getSociete()) &&
                Objects.equals(getFormuleEntities(), that.getFormuleEntities()) &&
                Objects.equals(reservationEntities, that.reservationEntities) &&
                Objects.equals(getFermetures(), that.getFermetures()) &&
                Objects.equals(getImage(), that.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceID(), getNom(), getServiceAdress(), getSociete(), getFormuleEntities(), reservationEntities, getFermetures(), getImage());
    }
}
