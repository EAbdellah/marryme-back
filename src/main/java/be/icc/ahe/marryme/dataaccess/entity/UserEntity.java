package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import be.icc.ahe.marryme.model.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Setter
@Getter
@ToString
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
    @OneToMany(mappedBy="user")
    private List<ReservationEntity> reservations;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;


}
