package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Setter
@Getter

public class UserEntity extends PersonEntity implements Serializable {

    private String login;
    private String mdp;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private Role role;

    @OneToMany(mappedBy="userEntity")
    private List<ReservationEntity> reservationEntities;


}
