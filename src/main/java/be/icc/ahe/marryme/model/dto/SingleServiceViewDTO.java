package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Fermeture;
import be.icc.ahe.marryme.model.Formule;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SingleServiceViewDTO {
    private Long serviceID;
    private String type ;
    private String nom;
    private Address address;
    private List<Formule> formules;
    private List<Fermeture> fermetures;
}
