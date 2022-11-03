package be.icc.ahe.marryme.model;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;
import java.sql.Date;

@Data
@NoArgsConstructor
public class Reservation {

    private Long reservationID;
    private Date reservationDate;
    private String ticket;
    private Service service;
    @JsonBackReference
    private User user;
    private Formule formule;
    private Integer price;
    private String status;
    private String payementId;
    private String token;
    private File contract;
    private Date inceptionDate;


}
