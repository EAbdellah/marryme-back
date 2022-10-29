package be.icc.ahe.marryme.dataaccess.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "fermeture")
@NoArgsConstructor
@Setter
@Getter
public class FermetureEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fermeture_date_id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

//    @ManyToMany(targetEntity =ServiceEntity0 ,cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE},fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "fermeture_service",
//            joinColumns = { @JoinColumn(name = "fermeture_date_id") },
//            inverseJoinColumns = { @JoinColumn(name = "service_id") }
//    )
    @ManyToMany(mappedBy = "fermetures", fetch = FetchType.LAZY)
    @JsonBackReference
Collection <ServiceEntity> serviceEntity = new HashSet<>();

}
