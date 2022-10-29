package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "musique")
@NoArgsConstructor

@Setter
@Getter


public class MusiqueEntity extends ServiceEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "musique_type")
    private MusiqueType musiqueType ;

    public MusiqueEntity(MusiqueType musiqueType) {
        this.musiqueType = musiqueType;
    }


}
