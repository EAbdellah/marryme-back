package be.icc.ahe.marryme.model;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.HallType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Salle extends Service {
    private Integer capaciteTotal;
    private Integer placeAssise;
    private Boolean pisteDance;
    private Boolean decoration;
    private Boolean materielMusique;
    private Boolean traiteur;
    private Boolean cuisine;
    private Boolean isExternal;
    private HallType hallTypeEntity;
    private Boolean haveParking;
    private Parking parking;


}
