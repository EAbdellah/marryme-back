package be.icc.ahe.marryme.model;

public class Societe {

    private Long societeID;
    private Long nTVA;
    private Long nEntreprise;
    private String nom;
    private String email;
    private Long nTel;
    private Adresse localisation;

    public Societe() {
    }

    public Long getSocieteID() {
        return societeID;
    }

    public void setSocieteID(Long societeID) {
        this.societeID = societeID;
    }

    public Long getnTVA() {
        return nTVA;
    }

    public void setnTVA(Long nTVA) {
        this.nTVA = nTVA;
    }

    public Long getnEntreprise() {
        return nEntreprise;
    }

    public void setnEntreprise(Long nEntreprise) {
        this.nEntreprise = nEntreprise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getnTel() {
        return nTel;
    }

    public void setnTel(Long nTel) {
        this.nTel = nTel;
    }

    public Adresse getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Adresse localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "SocieteEntity{" +
                "societeID=" + societeID +
                ", nTVA=" + nTVA +
                ", nEntreprise=" + nEntreprise +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", nTel=" + nTel +
                ", localisation=" + localisation +
                '}';
    }
}
