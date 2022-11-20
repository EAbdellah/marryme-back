package be.icc.ahe.marryme.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DecisionRequestRegistrationProvider {
    boolean accepted;
    String email;
    String nom;
}
