package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservation")
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


    public ReservationEntity() {
    }

    public Long getReservationID() {
        return reservationID;
    }

    public void setReservationID(Long reservationID) {
        this.reservationID = reservationID;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
