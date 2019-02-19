package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.util.Date;
import java.util.List;

import static application.eling.domain.Diagnostique.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Diagnostique b ORDER BY b.id DESC")
public class Diagnostique {

    public static final String FIND_ALL = "Diagnostique.findAllDiagnostiques";

    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;
    private String diagnostic;
    private Employe responsable;
    private Boolean publication;
    private Date date;
    private List<String> codesActes;
    private Integer prix;
    private Boolean payer;

    public Diagnostique(){

    }

    public Diagnostique(DMP dmp, String diagnostic, Employe responsable, Boolean publication, Date date, List<String> codesActes, Integer prix, Boolean payer) {
        this.dmp = dmp;
        this.diagnostic = diagnostic;
        this.responsable = responsable;
        this.publication = publication;
        this.date = date;
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

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getCodesActes() {
        return codesActes;
    }

    public void setCodesActes(List<String> codesActes) {
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
        return "Diagnostique{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", diagnostic='" + diagnostic + '\'' +
                ", responsable=" + responsable +
                ", publication=" + publication +
                ", date=" + date +
                ", codesActes=" + codesActes +
                ", prix=" + prix +
                ", payer=" + payer +
                '}';
    }
}
