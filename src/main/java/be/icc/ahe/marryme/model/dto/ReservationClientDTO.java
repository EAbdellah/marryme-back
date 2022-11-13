package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.model.dto.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class ReservationClientDTO {
    String ticket;
    String serviceType;
    Long serviceId;
    String serviceName;
    String formuleName;
    Date reservationDate;
    Integer price;
    String status;

}
