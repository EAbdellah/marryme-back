package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "service_traiteur")
public class ServiceTraiteurEntity extends ServiceEntity implements Serializable {

    @Column(name = "man_only", nullable = false)
    private Boolean manOnly;
    @Column(name = "woman_only", nullable = false)
    private Boolean womanOnly;

    public ServiceTraiteurEntity() {
    }

    public Boolean getManOnly() {
        return manOnly;
    }

    public void setManOnly(Boolean manOnly) {
        this.manOnly = manOnly;
    }

    public Boolean getWomanOnly() {
        return womanOnly;
    }

    public void setWomanOnly(Boolean womanOnly) {
        this.womanOnly = womanOnly;
    }

    @Override
    public String toString() {
        return "ServiceTraiteurEntity{" +
                "manOnly=" + manOnly +
                ", womanOnly=" + womanOnly +
                '}';
    }
}
