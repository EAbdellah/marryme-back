package be.icc.ahe.marryme.model;
import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;
import java.sql.Date;

@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "reservationID")
public class Reservation {

    private Long reservationID;
    private Date reservationDate;
    private String ticket;
    private Service service;
//    @JsonBackReference
    private User user;
    @JsonBackReference
    private Formule formule;
    private Integer price;
    private String status;
    private String payementId;
    private String token;
    private File contract;
    private Date inceptionDate;


}
