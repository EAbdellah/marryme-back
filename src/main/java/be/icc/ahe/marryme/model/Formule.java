package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
public class Formule {

    private Long formuleID;
    private String nom;
    private Integer prix;
    private String description;
    private Boolean isUniquePrix;
    private Integer supFerrier;
    private Integer supvendredi;
    private Integer codePostal;
    private Integer supDimanche;
    private Integer supVeilleFerier;
    @JsonManagedReference
    private List<Image> images;
    private Service service;
    private List<Reservation> reservation;



}
