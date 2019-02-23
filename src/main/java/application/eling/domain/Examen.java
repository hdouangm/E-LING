package application.eling.domain;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static application.eling.domain.Examen.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Examen b ORDER BY b.id DESC")
public class Examen {
    public static final String FIND_ALL = "Examen.findAllExamens";

    private Integer id;
    private DMP dmp;
    private Date date;
    private List<String> resultats;
    private Employe responsable;
    private Boolean publicationMed;
    private Boolean publicationLab;
    private List<Acte> codesActes;
    private Integer prix;
    private Boolean payer;

    public Examen(){

    }

    public Examen(DMP dmp, Date date, List<String> resultats, Employe responsable, Boolean publicationMed, Boolean publicationLab, List<Acte> codesActes, Integer prix, Boolean payer) {
        this.dmp = dmp;
        this.date = date;
        this.resultats = resultats;
        this.responsable = responsable;
        this.publicationMed = publicationMed;
        this.publicationLab = publicationLab;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Boolean getPublicationMed() { return publicationMed; }

    public void setPublicationMed(Boolean publicationMed) { this.publicationMed = publicationMed; }

    public Boolean getPublicationLab() { return publicationLab; }

    public void setPublicationLab(Boolean publicationLab) { this.publicationLab = publicationLab; }

    @ManyToOne(cascade = CascadeType.ALL)
    public List<Acte> getCodesActes() {
        return codesActes;
    }

    public void setCodesActes(List<Acte> codesActes) {
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
                ", publicationMed=" + publicationMed +
                ", publicationLab=" + publicationLab +
                ", codesActes=" + codesActes +
                ", prix=" + prix +
                ", payer=" + payer +
                '}';
    }
}
