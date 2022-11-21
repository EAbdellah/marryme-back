package be.icc.ahe.marryme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class GetShortMakeUpAndAirServiceDTO {

    private Long service_id;
    private String nom;
    private String type;
    private Boolean do_hair;
    private Boolean do_make_up;
    private Boolean do_man;
    private Boolean do_woman;
    private String presentation;

}
