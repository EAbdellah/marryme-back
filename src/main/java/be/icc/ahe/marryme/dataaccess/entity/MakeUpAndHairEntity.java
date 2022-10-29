package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "make_up_and_hair")
@NoArgsConstructor
@Setter
@Getter
public class MakeUpAndHairEntity  extends ServiceEntity implements Serializable {

    @Column(name = "do_hair", nullable = false)
    private Boolean doHair;
    @Column(name = "do_make_up", nullable = false)
    private Boolean doMakeUp;
    @Column(name = "do_man", nullable = false)
    private Boolean doMan;
    @Column(name = "do_woman", nullable = false)
    private Boolean doWoman;
}
