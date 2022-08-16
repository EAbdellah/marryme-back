package be.icc.ahe.marryme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Address {

    private Long adressID;
    private String pays;
    private String ville;
    private Integer codePostal;
    private String rue;
    private String numero;
    private String box;



}
