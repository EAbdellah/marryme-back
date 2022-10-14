package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
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
    @Column(name = "mdp", nullable = false, length = 128)
    private String mdp;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private Role role;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_non_locked")
    private boolean isNonLocked;

    @OneToMany(mappedBy="userEntity")
    private List<ReservationEntity> reservationEntities;


}
