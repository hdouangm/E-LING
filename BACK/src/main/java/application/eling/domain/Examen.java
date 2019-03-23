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

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private DMP dmp;
    private String date;
    private String urlResultats;
    @OneToOne(cascade = CascadeType.ALL)
    private Employe responsable;
    private Boolean publication;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Acte> codesActes = new HashSet<Acte>(0);
    private Integer prix;
    private Boolean payer;
    @OneToOne(cascade = CascadeType.ALL)
    private DemandeExamen demandeExamen;

    public Examen(){

    }

    public Examen(DMP dmp, String date, String urlResultats, Employe responsable, Boolean publication, Set<Acte> codesActes, Boolean payer) {
        this.dmp = dmp;
        this.date = date;
        this.urlResultats = urlResultats;
        this.responsable = responsable;
        this.publication = publication;
        this.codesActes = codesActes;
        this.prix = 0;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlResultats() { return urlResultats; }

    public void setUrlResultats(String urlResultats) { this.urlResultats = urlResultats; }

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

    public DemandeExamen getDemandeExamen() { return demandeExamen; }

    public void setDemandeExamen(DemandeExamen demandeExamen) { this.demandeExamen = demandeExamen; }


    @Override
    public String toString() {
        return "Examen{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", date=" + date +
                ", urlResultats=" + urlResultats +
                ", responsable=" + responsable +
                ", publication=" + publication +
                ", codesActes=" + codesActes +
                ", prix=" + prix +
                ", payer=" + payer +
                '}';
    }
}