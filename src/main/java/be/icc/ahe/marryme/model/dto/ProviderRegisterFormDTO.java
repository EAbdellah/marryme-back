package be.icc.ahe.marryme.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class ProviderRegisterFormDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String country;
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;
    private String box;
    private String name;
    private String n_entreprise;
    private String n_tva;
    private String entreprise_phone;
    private String password;
    private String email_entreprise;
    private String serviceType;
}
