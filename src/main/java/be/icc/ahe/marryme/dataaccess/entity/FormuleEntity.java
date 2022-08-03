package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "formule")
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



    public FormuleEntity() {
    }

    public Long getFormuleID() {
        return formuleID;
    }

    public void setFormuleID(Long formuleID) {
        this.formuleID = formuleID;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUniquePrix() {
        return isUniquePrix;
    }

    public void setUniquePrix(Boolean uniquePrix) {
        isUniquePrix = uniquePrix;
    }

    public Integer getSupFerrier() {
        return supFerrier;
    }

    public void setSupFerrier(Integer supFerrier) {
        this.supFerrier = supFerrier;
    }

    public Integer getSupvendredi() {
        return supvendredi;
    }

    public void setSupvendredi(Integer supvendredi) {
        this.supvendredi = supvendredi;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public Integer getSupDimanche() {
        return supDimanche;
    }

    public void setSupDimanche(Integer supDimanche) {
        this.supDimanche = supDimanche;
    }

    public Integer getSupVeilleFerier() {
        return supVeilleFerier;
    }

    public void setSupVeilleFerier(Integer supVeilleFerier) {
        this.supVeilleFerier = supVeilleFerier;
    }

    @Override
    public String toString() {
        return "FormuleEntity{" +
                "formuleID=" + formuleID +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", isUniquePrix=" + isUniquePrix +
                ", supFerrier=" + supFerrier +
                ", supvendredi=" + supvendredi +
                ", codePostal=" + codePostal +
                ", supDimanche=" + supDimanche +
                ", supVeilleFerier=" + supVeilleFerier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormuleEntity)) return false;
        FormuleEntity that = (FormuleEntity) o;
        return Objects.equals(getFormuleID(), that.getFormuleID()) &&
                Objects.equals(getNom(), that.getNom()) &&
                Objects.equals(getPrix(), that.getPrix()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(isUniquePrix, that.isUniquePrix) &&
                Objects.equals(getImages(), that.getImages()) &&
                Objects.equals(getSupFerrier(), that.getSupFerrier()) &&
                Objects.equals(getSupvendredi(), that.getSupvendredi()) &&
                Objects.equals(getCodePostal(), that.getCodePostal()) &&
                Objects.equals(getSupDimanche(), that.getSupDimanche()) &&
                Objects.equals(getSupVeilleFerier(), that.getSupVeilleFerier()) &&
                Objects.equals(getServiceEntity(), that.getServiceEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFormuleID(), getNom(), getPrix(), getDescription(), isUniquePrix, getImages(), getSupFerrier(), getSupvendredi(), getCodePostal(), getSupDimanche(), getSupVeilleFerier(), getServiceEntity());
    }
}
