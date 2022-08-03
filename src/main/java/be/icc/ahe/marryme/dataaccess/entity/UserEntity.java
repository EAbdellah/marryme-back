package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends PersonEntity implements Serializable {

    private String login;
    private String mdp;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private Role role;

    @OneToMany(mappedBy="userEntity")
    private List<ReservationEntity> reservationEntities;


    public UserEntity() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
