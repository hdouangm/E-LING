package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static application.eling.domain.Posologie.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Posologie b ORDER BY b.id DESC")
public class Posologie implements Serializable {
    public static final String FIND_ALL = "Posologie.findAllPosologies";

    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;
    private String posologie;
    private List<String> suiviTraitement;
    private Employe responsable;
    private Boolean publication;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Acte> codesActes = new HashSet<Acte>(0);
    private Integer prix;
    private Boolean payer;

    public Posologie(){

    }

    public Posologie(DMP dmp, String posologie, List<String> suiviTraitement, Employe responsable, Boolean publication, Set<Acte> codesActes, Integer prix, Boolean payer) {
        this.dmp = dmp;
        this.posologie = posologie;
        this.suiviTraitement = suiviTraitement;
        this.responsable = responsable;
        this.publication = publication;
        this.codesActes = codesActes;
        this.prix = prix;
        this.payer = payer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DMP getDmp() {
        return dmp;
    }

    public void setDmp(DMP dmp) {
        this.dmp = dmp;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public List<String> getSuiviTraitement() {
        return suiviTraitement;
    }

    public void setSuiviTraitement(List<String> suiviTraitement) {
        this.suiviTraitement = suiviTraitement;
    }

    public Employe getResponsable() {
        return responsable;
    }

    public void setResponsable(Employe responsable) {
        this.responsable = responsable;
    }

    public Boolean getPublication() {
        return publication;
    }

    public void setPublication(Boolean publication) {
        this.publication = publication;
    }

    public Set<Acte> getCodesActes() {
        return codesActes;
    }

    public void setCodesActes(Set<Acte> codesActes) {
        this.codesActes = codesActes;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Boolean getPayer() {
        return payer;
    }

    public void setPayer(Boolean payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        return "Posologie{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", posologie='" + posologie + '\'' +
                ", suiviTraitement=" + suiviTraitement +
                ", responsable=" + responsable +
                ", publication=" + publication +
                ", codesActes=" + codesActes +
                ", prix=" + prix +
                ", payer=" + payer +
                '}';
    }
}
