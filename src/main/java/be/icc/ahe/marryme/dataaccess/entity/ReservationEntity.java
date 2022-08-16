package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Setter
@Getter

public class ReservationEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private Long reservationID;
    @Column(name = "reservation_date", nullable = false)
    private Date reservationDate;
    @Column(name = "ticket", nullable = false, length = 128)
    private String ticket;

    @ManyToOne( targetEntity = ServiceEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name="service_id")
    private ServiceEntity serviceEntity;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private UserEntity userEntity;
}
