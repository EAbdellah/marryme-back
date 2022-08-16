package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "AbstractService")
@NoArgsConstructor
@Setter
@Getter

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

}
