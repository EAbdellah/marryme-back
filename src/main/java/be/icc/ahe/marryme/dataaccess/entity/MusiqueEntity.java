package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "musique")
public class MusiqueEntity extends ServiceEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "musique_type")
    private MusiqueType musiqueType ;

    public MusiqueEntity() {
    }

    public MusiqueType getMusiqueType() {
        return musiqueType;
    }

    public void setMusiqueType(MusiqueType musiqueType) {
        this.musiqueType = musiqueType;
    }
}
