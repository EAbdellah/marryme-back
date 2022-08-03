package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "make_up_and_hair")
public class MakeUpAndHairEntity  extends ServiceEntity implements Serializable {

    @Column(name = "do_hair", nullable = false)
    private Boolean doHair;
    @Column(name = "do_make_up", nullable = false)
    private Boolean doMakeUp;
    @Column(name = "do_man", nullable = false)
    private Boolean doMan;
    @Column(name = "do_woman", nullable = false)
    private Boolean doWoman;

    public MakeUpAndHairEntity() {
    }

    public Boolean getDoHair() {
        return doHair;
    }

    public void setDoHair(Boolean doHair) {
        this.doHair = doHair;
    }

    public Boolean getDoMakeUp() {
        return doMakeUp;
    }

    public void setDoMakeUp(Boolean doMakeUp) {
        this.doMakeUp = doMakeUp;
    }

    public Boolean getDoMan() {
        return doMan;
    }

    public void setDoMan(Boolean doMan) {
        this.doMan = doMan;
    }

    public Boolean getDoWoman() {
        return doWoman;
    }

    public void setDoWoman(Boolean doWoman) {
        this.doWoman = doWoman;
    }

    @Override
    public String toString() {
        return "MakeUpAndHairEntity{" +
                "doHair=" + doHair +
                ", doMakeUp=" + doMakeUp +
                ", doMan=" + doMan +
                ", doWoman=" + doWoman +
                '}';
    }
}
