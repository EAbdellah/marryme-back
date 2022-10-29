package be.icc.ahe.marryme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@NoArgsConstructor @Getter @Setter
@ToString
public class Traiteur extends Service {

    private Boolean doMeat;
    private Boolean doFish;
    private Boolean doVegan;
    private Boolean DoVegetarian;


}
