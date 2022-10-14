package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter @Setter @NoArgsConstructor
public class Person {

    private Long personID;
    private String nom;
    private String prenom;
    private String email;
    private Long nTel;
    private Address localisation;
    private User user;

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", nTel=" + nTel +
                ", localisation=" + localisation +
                ", user=" + user +
                '}';
    }
}
