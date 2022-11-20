package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;
import java.util.Date;

@Data
@AllArgsConstructor
public class GetShortReservationDTO {

    private Long reservation_id;
    private Date inception_date;
    private String payement_id;
    private Integer price;
    private Date reservation_date;
    private String status;
    private String ticket;
    private String formule_Name;
}
