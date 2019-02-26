package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static application.eling.domain.Intervention.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Intervention b ORDER BY b.id DESC")
public class Intervention implements Serializable {
    public static final String FIND_ALL = "Intervention.findAllInterventions";

    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;
    private Integer type;
    private String lieu;
    private String date;
    private Employe responsable;
    private Boolean publication;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Acte> codesActes = new HashSet<Acte>(0);
    private Integer prix;
    private Boolean payer;

    public Intervention(){

    }

    public Intervention(DMP dmp, Integer type, String lieu, String date, Employe responsable, Boolean publication, Set<Acte> codesActes, Integer prix, Boolean payer) {
        this.dmp = dmp;
        this.type = type;
        this.lieu = lieu;
        this.date = date;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return "Intervention{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", type=" + type +
                ", lieu='" + lieu + '\'' +
                ", date=" + date +
                ", responsable=" + responsable +
                ", publication=" + publication +
                ", codesActes=" + codesActes +
                ", prix=" + prix +
                ", payer=" + payer +
                '}';
    }
}
