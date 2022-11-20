package be.icc.ahe.marryme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProviderRequestRegistrationDTO {
    String nom;
    String ntva;
    Long nentreprise;
    String email;
    String fristName;
    String LastName;
}

