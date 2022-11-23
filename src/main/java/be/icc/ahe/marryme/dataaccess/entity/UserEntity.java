package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import be.icc.ahe.marryme.model.dto.GetTypeOfService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@NamedNativeQuery(
        name  = "getTypeOfServiceByProvider",
        query = "SELECT service.type as type " +
                "FROM (((myschema.societe as societe " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ; "
        ,
        resultSetMapping = "typeOfServiceByProvider"
)

@SqlResultSetMapping(
        name = "typeOfServiceByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = String.class,
                        columns = {
                                @ColumnResult(name = "type", type = String.class),
                        })
        }
)


@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userID;
    @Column(name = "email", nullable = false, length = 128)
    private String email;
    @Column(name = "password", nullable = false, length = 128)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private Role role;
    private String[] authorities;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_not_locked")
    private boolean isNotLocked;
    @JsonManagedReference
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    private List<ReservationEntity> reservations;

    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;


}
