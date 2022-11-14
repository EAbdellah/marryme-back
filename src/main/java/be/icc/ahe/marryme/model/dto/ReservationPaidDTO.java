package be.icc.ahe.marryme.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationPaidDTO {
    String resTicket;
    String paymentId;
    String status;
    String payerId;
    String merchantId;
    String timstamp;
}

