package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "image")
@NoArgsConstructor
@Setter
@Getter

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

 }
