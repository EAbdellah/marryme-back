package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "traiteur")
public class TraiteurEntity  extends ServiceEntity implements Serializable {

    @Column(name = "do_meat", nullable = false)
    private Boolean doMeat;
    @Column(name = "do_fish", nullable = false)
    private Boolean doFish;
    @Column(name = "do_vegan", nullable = false)
    private Boolean doVegan;
    @Column(name = "do_vegetarian", nullable = false)
    private Boolean DoVegetarian;

    public TraiteurEntity(Boolean doMeat) {
        this.doMeat = doMeat;
    }

    public TraiteurEntity() {

    }

    public Boolean getDoMeat() {
        return doMeat;
    }

    public void setDoMeat(Boolean doMeat) {
        this.doMeat = doMeat;
    }

    public Boolean getDoFish() {
        return doFish;
    }

    public void setDoFish(Boolean doFish) {
        this.doFish = doFish;
    }

    public Boolean getDoVegan() {
        return doVegan;
    }

    public void setDoVegan(Boolean doVegan) {
        this.doVegan = doVegan;
    }

    public Boolean getDoVegetarian() {
        return DoVegetarian;
    }

    public void setDoVegetarian(Boolean doVegetarian) {
        DoVegetarian = doVegetarian;
    }

    @Override
    public String toString() {
        return "TraiteurEntity{" +
                "doMeat=" + doMeat +
                ", doFish=" + doFish +
                ", doVegan=" + doVegan +
                ", DoVegetarian=" + DoVegetarian +
                '}';
    }
}
