package be.icc.ahe.marryme.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Data
@NoArgsConstructor
public abstract class Service {


    private Long ServiceID;
    private String nom;
    private Address address;
    private List<Formule> formules = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private Collection<Fermeture> fermetures = new HashSet<>() ;
    private Image image;
    private String presentation;




}
