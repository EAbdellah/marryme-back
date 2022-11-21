package be.icc.ahe.marryme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class GetShortServiceTraiteurServiceDTO {


    private Long serviceId;
    private String nom;
    private String type;
    private Boolean man_only;
    private Boolean woman_only;
    private String presentation;

}
