package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adress")
@NoArgsConstructor @Setter @Getter
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id", nullable = false)
    private Long adressID;

    @Column(name = "pays", nullable = false, length = 128)
    private String pays;

    @Column(name = "ville", nullable = false, length = 128)
    private String ville;

    @Column(name = "codePostal", nullable = false)
    private Integer codePostal;

    @Column(name = "rue", nullable = false, length = 128)
    private String rue;

    @Column(name = "numero", nullable = false, length = 128)
    private String numero;

    @Column(name = "box", nullable = false, length = 128)
    private String box;




}
