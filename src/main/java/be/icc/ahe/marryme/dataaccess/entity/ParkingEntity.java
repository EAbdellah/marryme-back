package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parking")
public class ParkingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id", nullable = false)
    private Long parkingID;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "voiturier", nullable = false)
    private Boolean voiturier;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "parkingEntity")
//    @JoinColumn(name="service_id")
//    @OneToOne(targetEntity = SalleEntity.class,fetch = FetchType.LAZY,mappedBy = "parkingEntity")
//    @JoinColumn(name="service_id")

    @OneToOne(targetEntity = SalleEntity.class,fetch = FetchType.LAZY)
    @JoinColumn(name="service_id")
    private SalleEntity salleEntity;

    public ParkingEntity() {
    }

    public Long getParkingID() {
        return parkingID;
    }

    public void setParkingID(Long parkingID) {
        this.parkingID = parkingID;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getVoiturier() {
        return voiturier;
    }

    public void setVoiturier(Boolean voiturier) {
        this.voiturier = voiturier;
    }

    public SalleEntity getSalleEntity() {
        return salleEntity;
    }

    public void setSalleEntity(SalleEntity salleEntity) {
        this.salleEntity = salleEntity;
    }



    @Override
    public String toString() {
        return "ParkingEntity{" +
                "parkingID=" + parkingID +
                ", capacity=" + capacity +
                ", voiturier=" + voiturier +
                '}';
    }
}
