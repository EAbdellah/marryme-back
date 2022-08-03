package be.icc.ahe.marryme.model;

public abstract class  Service {

    private Long ServiceID;
    private String nom;
    private Adresse serviceAdress;
    private Societe societe;

    public Service() {
    }

    public Long getServiceID() {
        return ServiceID;
    }

    public void setServiceID(Long serviceID) {
        ServiceID = serviceID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getServiceAdress() {
        return serviceAdress;
    }

    public void setServiceAdress(Adresse serviceAdress) {
        this.serviceAdress = serviceAdress;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "ServiceID=" + ServiceID +
                ", nom='" + nom + '\'' +
                ", serviceAdress=" + serviceAdress +
                ", societe=" + societe +
                '}';
    }


}
