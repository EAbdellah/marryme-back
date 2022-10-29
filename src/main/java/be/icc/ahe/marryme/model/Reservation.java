package be.icc.ahe.marryme.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reservation {

    private Long reservationID;
    private Date reservationDate;
    private String ticket;
    private Service service;
    private User user;

}
