package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parking")
@NoArgsConstructor
@Setter
@Getter

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

  }
