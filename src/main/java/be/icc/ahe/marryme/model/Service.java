package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class Service {


    private Long ServiceID;
    private String nom;
    private Address address;
//    private Societe societe;
    private List<Formule> formules = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private Collection<Fermeture> fermetures = new HashSet<>() ;
    private Image image;


}
