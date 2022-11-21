package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetShortMusiqueServiceDTO {
    private Long service_id;
    private String nom;
    private String type;
    private String musique_type ;
    private String presentation;

}
