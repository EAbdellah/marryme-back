package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortReservationDTO;
import be.icc.ahe.marryme.model.dto.ReservationClientDTO;
import be.icc.ahe.marryme.model.dto.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.sql.Date;


@NamedNativeQuery(
        name  = "getAllReservationsByUser",
        query = "SELECT  res.ticket,service.type as service_type ,service.service_id,service.nom as service_name,formule.nom as formule_name,res.reservation_date,res.price,res.status " +
                "FROM ((myschema.formule as formule " +
                "INNER JOIN myschema.reservation as res ON res.formule_id  = formule.formule_id) " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = formule.service_id) " +
                "Where res.user_id = :asking_user_id ;"
        ,
        resultSetMapping = "allReservationsByUser"
)

@SqlResultSetMapping(
        name = "allReservationsByUser",
        classes = {
                @ConstructorResult(
                        targetClass = ReservationClientDTO.class,
                        columns = {
                                @ColumnResult(name = "ticket", type = String.class),
                                @ColumnResult(name = "service_type", type = String.class),
                                @ColumnResult(name = "service_id", type = Long.class),
                                @ColumnResult(name = "service_name", type = String.class),
                                @ColumnResult(name = "formule_name", type = String.class),
                                @ColumnResult(name = "reservation_date", type = Date.class),
                                @ColumnResult(name = "price", type = Integer.class),
                                @ColumnResult(name = "status", type = String.class),

                        })
        }
)


@NamedNativeQuery(
        name  = "getAllReservationByProvider",
        query = "SELECT reservation.reservation_id,reservation.inception_date,reservation.payement_id,reservation.price,reservation.reservation_date,reservation.status,reservation.ticket," +
                "formule.nom as formule_Name " +
                "FROM (((((myschema.formule as formule " +
                "INNER JOIN myschema.reservation as reservation ON reservation.formule_id  = formule.formule_id) " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = formule.service_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ; "
        ,
        resultSetMapping = "allReservationByProvider"
)

@SqlResultSetMapping(
        name = "allReservationByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortReservationDTO.class,
                        columns = {
                                @ColumnResult(name = "reservation_id", type = Long.class),
                                @ColumnResult(name = "inception_date", type = java.util.Date.class),
                                @ColumnResult(name = "payement_id", type = String.class),
                                @ColumnResult(name = "price", type = Integer.class),
                                @ColumnResult(name = "reservation_date", type = java.util.Date.class),
                                @ColumnResult(name = "status", type = String.class),
                                @ColumnResult(name = "ticket", type = String.class),
                                @ColumnResult(name = "formule_Name", type = String.class),

                        })
        }
)


@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "reservationID")
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

    @JsonBackReference
    @ManyToOne( targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="formule_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
