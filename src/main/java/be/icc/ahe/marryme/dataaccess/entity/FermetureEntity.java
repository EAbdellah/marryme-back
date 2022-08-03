package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "fermeture")
public class FermetureEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fermeture_date_id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

//    @ManyToMany(targetEntity =ServiceEntity0 ,cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE},fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "fermeture_service",
//            joinColumns = { @JoinColumn(name = "fermeture_date_id") },
//            inverseJoinColumns = { @JoinColumn(name = "service_id") }
//    )
    @ManyToMany(mappedBy = "fermetures", fetch = FetchType.LAZY)
    Collection <ServiceEntity> serviceEntity = new HashSet<>();

    public FermetureEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<ServiceEntity> getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(Collection<ServiceEntity> serviceEntity) {
        this.serviceEntity = serviceEntity;
    }
}
