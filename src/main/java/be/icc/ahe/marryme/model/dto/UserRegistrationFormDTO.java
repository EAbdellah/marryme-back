package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserRegistrationFormDTO {


    private String nom;
    private String prenom;
    private String email;
    private Long nTel;
    private String login;
    private String mdp;

    @Override
    public String toString() {
        return "UserRegistrationFormDTO{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", nTel=" + nTel +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
