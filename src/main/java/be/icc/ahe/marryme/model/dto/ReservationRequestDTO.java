package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.model.Formule;
import be.icc.ahe.marryme.model.Reservation;
import be.icc.ahe.marryme.model.Service;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.mapper.UserMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ReservationRequestDTO {

    private Date reservationDate;
    private String formuleId;
    private Integer price;
    private File contract;

}
