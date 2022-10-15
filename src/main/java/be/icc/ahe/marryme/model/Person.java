package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter @Setter @NoArgsConstructor @ToString
public class Person {

    private Long personID;
    private String firstName;
    private String lastName;
    private Long phoneNbr;
    private Address localisation;
    private User user;

}
