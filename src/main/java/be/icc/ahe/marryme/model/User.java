package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor @Setter @Getter
public class User  {

    private String mdp;
    private Role role;
    private boolean isActive;
    private boolean isNonLocked;
    private String[] authorities;
    private List<Reservation> reservations;

    @Override
    public String toString() {
        return "User{" +

                ", mdp='" + mdp + '\'' +
                ", role=" + role +
                ", reservations=" + reservations +
                '}';
    }
}
