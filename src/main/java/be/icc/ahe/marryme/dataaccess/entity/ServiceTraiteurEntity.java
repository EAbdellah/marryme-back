package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "service_traiteur")
@NoArgsConstructor
@Setter
@Getter

public class ServiceTraiteurEntity extends ServiceEntity implements Serializable {

    @Column(name = "man_only", nullable = false)
    private Boolean manOnly;
    @Column(name = "woman_only", nullable = false)
    private Boolean womanOnly;

    }
