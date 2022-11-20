package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "formuleID")
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
    private Integer supSamedi;
    private Integer supVeilleFerier;
    @JsonManagedReference
    private List<Image> images;
    private Service service;
    @JsonManagedReference(value="formule-reservation")
    private List<Reservation> reservation;
    private boolean isActive;



}
