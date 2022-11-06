package be.icc.ahe.marryme.dataaccess.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Data

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
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="formule_id", nullable=false)
    private FormuleEntity formule;

    @Column(name = "price", nullable = false, length = 128)
    private Integer price;

    @Column(name = "status", nullable = false, length = 128)
    private String status;

    @Column(name = "payementId")
    private String payementId;

    @Column(name = "token")
    private String token;

    @Column(name = "contract")
    private File contract;

    @Column(name = "inceptionDate", nullable = false)
    private Date inceptionDate;


}
