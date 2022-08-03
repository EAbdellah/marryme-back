package be.icc.ahe.marryme.model;

public class Salle extends Service {


    private Integer capaciteTotal;
    private Integer placeAssise;
    private Boolean pisteDance;
    private Boolean decoration;
    private Boolean materielMusique;
    private Boolean Traiteur;
    private Boolean cuisine;

    public Salle() {
    }

    public Integer getCapaciteTotal() {
        return capaciteTotal;
    }

    public void setCapaciteTotal(Integer capaciteTotal) {
        this.capaciteTotal = capaciteTotal;
    }

    public Integer getPlaceAssise() {
        return placeAssise;
    }

    public void setPlaceAssise(Integer placeAssise) {
        this.placeAssise = placeAssise;
    }

    public Boolean getPisteDance() {
        return pisteDance;
    }

    public void setPisteDance(Boolean pisteDance) {
        this.pisteDance = pisteDance;
    }

    public Boolean getDecoration() {
        return decoration;
    }

    public void setDecoration(Boolean decoration) {
        this.decoration = decoration;
    }

    public Boolean getMaterielMusique() {
        return materielMusique;
    }

    public void setMaterielMusique(Boolean materielMusique) {
        this.materielMusique = materielMusique;
    }

    public Boolean getTraiteur() {
        return Traiteur;
    }

    public void setTraiteur(Boolean traiteur) {
        Traiteur = traiteur;
    }

    public Boolean getCuisine() {
        return cuisine;
    }

    public void setCuisine(Boolean cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public String toString() {
        return "SalleEntity{" +
                "capaciteTotal=" + capaciteTotal +
                ", placeAssise=" + placeAssise +
                ", pisteDance=" + pisteDance +
                ", decoration=" + decoration +
                ", materielMusique=" + materielMusique +
                ", Traiteur=" + Traiteur +
                ", cuisine=" + cuisine +
                '}';
    }
}
