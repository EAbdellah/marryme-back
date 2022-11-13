package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import be.icc.ahe.marryme.model.Reservation;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
