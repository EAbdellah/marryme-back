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
public class User extends Person {

    private String login;
    private String mdp;
    private Role role;
    private List<Reservation> reservations;

    @Override
    public String toString() {
        return "User{" +

                "personID=" + getPersonID() +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", nTel=" + getNTel() +
                ", localisation=" + getLocalisation() +
                "login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", role=" + role +
                ", reservations=" + reservations +
                '}';
    }
}
