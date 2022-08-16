package be.icc.ahe.marryme.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    private Long reservationID;
    private Date reservationDate;
    private String ticket;
    private Service service;
    private User user;

}
