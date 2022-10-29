package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fermeture {

    private Long id;
    private Date date;
    Collection<Service> service = new HashSet<>();

}
