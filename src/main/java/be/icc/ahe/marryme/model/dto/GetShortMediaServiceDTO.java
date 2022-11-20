package be.icc.ahe.marryme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class GetShortMediaServiceDTO {
    private Long service_id;
    private String nom;
    private String type;
    private Boolean is_photo;
    private Boolean is_video;
    private Boolean do_album;
    private Boolean do_souvenir;
}
