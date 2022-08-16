package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Setter
@Getter

public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Long personID;
    @Column(name = "nom", nullable = false, length = 128)
    private String nom;
    @Column(name = "prenom", nullable = false, length = 128)
    private String prenom;
    @Column(name = "email", nullable = false, length = 128)
    private String email;
    @Column(name = "nTel", nullable = false)
    private Long nTel;

//    @OneToOne(targetEntity = SocieteEntity.class, fetch = FetchType.EAGER)
//    @JoinColumn(name="societe_id")
//    private SocieteEntity societeEntity;

    @OneToOne(targetEntity = AddressEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="adress_id")
    private AddressEntity localisation;

  }
