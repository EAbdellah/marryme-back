package be.icc.ahe.marryme.model;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Musique extends Service {
    private MusiqueType musiqueType ;

}
