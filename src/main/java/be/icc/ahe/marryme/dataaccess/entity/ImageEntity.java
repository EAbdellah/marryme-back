package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "image")
public class ImageEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Long imageID;

//    @Lob
    @Column(name = "photo", nullable=false)
    private byte[] photo;

//    @OneToOne(targetEntity = ServiceEntity.class,fetch = FetchType.LAZY)
@OneToOne(targetEntity = ServiceEntity.class,fetch = FetchType.LAZY)
@JoinColumn(name="service_id")
    private ServiceEntity serviceEntity;

    @ManyToOne( targetEntity = FormuleEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name="formule_id")
    private FormuleEntity formule;

    public ImageEntity() {
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public FormuleEntity getFormule() {
        return formule;
    }

    public void setFormule(FormuleEntity formule) {
        this.formule = formule;
    }
}
