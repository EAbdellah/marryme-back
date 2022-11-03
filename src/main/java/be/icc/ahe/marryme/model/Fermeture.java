package be.icc.ahe.marryme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fermeture {

    private Long id;
    private Date date;
    private Collection<Service> service = new HashSet<>();

}
