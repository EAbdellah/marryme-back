package be.icc.ahe.marryme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetShortFormuleDTO {
    Long formule_id;
    String description;
    Boolean is_unique_prix;
    String  nom;
    Integer prix;
    Integer sup_dimanche;
    Integer sup_ferrier;
    Integer sup_samedi;
    Integer sup_veille_ferier;
    Integer supvendredi;

}
