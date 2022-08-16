package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor @Getter @Setter
public class Societe {

    private Long societeID;
    private Long nTVA;
    private Long nEntreprise;
    private String nom;
    private String email;
    private Long nTel;
    private Address localisation;
    private Person owner;



}
