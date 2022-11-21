package be.icc.ahe.marryme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetShortSalleServiceDTO {

    private Long service_id;
    private String nom;
    private String type;
    private Integer capacite_total;
    private Boolean cuisine;
    private Boolean decoration;
    private String hall_type;
    private Boolean have_parking;
    private Boolean is_external;
    private Boolean materiel_musique;
    private Boolean piste_dance;
    private Integer place_assise;
    private Boolean traiteur;
    private Integer capacity;
    private Boolean voiturier;
    private String presentation;

}
