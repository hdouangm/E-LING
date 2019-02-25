package application.eling.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.io.Serializable;

import static application.eling.domain.DemandeExamen.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DemandeExamen b ORDER BY b.id DESC")
public class DemandeExamen implements Serializable {
    public static final String FIND_ALL = "DemandeExamen.findAllDemandeExamens";


    private Integer id;
    private DMP dmp;
    private String type;
    private String date;
    private Boolean publierDemande;
    private Boolean demandeRemplie;

    public DemandeExamen(){

    }

    public DemandeExamen(DMP dmp, String type, String date, Boolean publierDemande, Boolean demandeRemplie) {
        this.dmp = dmp;
        this.type = type;
        this.date = date;
        this.publierDemande = publierDemande;
        this.demandeRemplie = demandeRemplie;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPublierDemande() { return publierDemande; }

    public void setPublierDemande(Boolean publierDemande) { this.publierDemande = publierDemande; }

    public Boolean getDemandeRemplie() { return demandeRemplie; }

    public void setDemandeRemplie(Boolean demandeRemplie) { this.demandeRemplie = demandeRemplie; }

    @Override
    public String toString() {
        return "DemandeExamen{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", publierDemande=" + publierDemande +
                ", demandeRemplie=" + demandeRemplie +
                '}';
    }
}
