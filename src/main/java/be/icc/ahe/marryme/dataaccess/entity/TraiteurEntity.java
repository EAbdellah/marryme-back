package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "traiteur")
@NoArgsConstructor
@Setter
@Getter

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

  }
