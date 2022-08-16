package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "societe")
@NoArgsConstructor @Getter @Setter
public class SocieteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "societe_id", nullable = false)
    private Long societeID;
    @Column(name = "n_tva", nullable = false)
    private Long nTVA;
    @Column(name = "n_entreprise", nullable = false)
    private Long nEntreprise;
    @Column(name = "nom", nullable = false, length = 128)
    private String nom;
    @Column(name = "email", nullable = false, length = 128)
    private String email;
    @Column(name = "nTel", nullable = false)
    private Long nTel;

    @OneToOne(targetEntity = AddressEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name="service_id")
    private AddressEntity localisation;

    @OneToOne(targetEntity = PersonEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="person_id")
    private PersonEntity owner;



}
