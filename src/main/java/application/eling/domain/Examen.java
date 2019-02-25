package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static application.eling.domain.Examen.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Examen b ORDER BY b.id DESC")
public class Examen implements Serializable {
    public static final String FIND_ALL = "Examen.findAllExamens";

    private Integer id;
    private DMP dmp;
    private String date;
    private List<String> resultats;
    private Employe responsable;
    private Boolean publication;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Acte> codesActes = new HashSet<Acte>(0);
    private Integer prix;
    private Boolean payer;

    public Examen(){

    }

    public Examen(DMP dmp, String date, List<String> resultats, Employe responsable, Boolean publication, Set<Acte> codesActes, Integer prix, Boolean payer) {
        this.dmp = dmp;
        this.date = date;
        this.resultats = resultats;
        this.responsable = responsable;
        this.publication = publication;
        this.codesActes = codesActes;
        this.prix = prix;
        this.payer = payer;
    }

    @Id
    @GeneratedValue
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getResultats() {
        return resultats;
    }

    public void setResultats(List<String> resultats) {
        this.resultats = resultats;
    }

    public Employe getResponsable() {
        return responsable;
    }

    public void setResponsable(Employe responsable) {
        this.responsable = responsable;
    }

    public Boolean getPublication() { return publication; }

    public void setPublication(Boolean publicationMed) { this.publication = publication; }

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
        return "Examen{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", date=" + date +
                ", resultats=" + resultats +
                ", responsable=" + responsable +
                ", publication=" + publication +
                ", codesActes=" + codesActes +
                ", prix=" + prix +
                ", payer=" + payer +
                '}';
    }
}
