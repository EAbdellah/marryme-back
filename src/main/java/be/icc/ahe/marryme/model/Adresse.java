package be.icc.ahe.marryme.model;

public class Adresse {

    private Long adressID;
    private String pays;
    private String ville;
    private Integer codePostal;
    private String rue;
    private String numero;
    private String box;

    public Adresse() {
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
