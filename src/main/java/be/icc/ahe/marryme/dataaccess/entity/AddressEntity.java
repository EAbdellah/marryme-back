package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adress")
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




    public AddressEntity() {
    }

    public Long getAdressID() {
        return adressID;
    }

    public void setAdressID(Long adressID) {
        this.adressID = adressID;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }


    @Override
    public String toString() {
        return "AddressEntity{" +
                "adressID=" + adressID +
                ", pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal=" + codePostal +
                ", rue='" + rue + '\'' +
                ", numero='" + numero + '\'' +
                ", box='" + box + '\'' +
                '}';
    }


}
