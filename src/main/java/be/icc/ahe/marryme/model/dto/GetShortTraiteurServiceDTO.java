package be.icc.ahe.marryme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetShortTraiteurServiceDTO {

    private Long service_id;
    private String nom;
    private String type;
    private Boolean do_vegan;
    private Boolean do_fish;
    private Boolean do_meat;
    private Boolean do_vegetarian;

}
