package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Parking {

    private Long parkingID;
    private Integer capacity;
    private Boolean voiturier;
    private Salle salle;

}
