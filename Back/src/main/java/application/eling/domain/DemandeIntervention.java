package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


import java.io.Serializable;

import static application.eling.domain.DemandeIntervention.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DemandeIntervention b ORDER BY b.id DESC")
public class DemandeIntervention implements Serializable {
    public static final String FIND_ALL = "DemandeIntervention.findAllDemandeInterventions";

    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;
    private String date;
    private Boolean publierDemande;
    private Boolean demandeRemplie;
    private String type;

    public DemandeIntervention(){

    }

    public DemandeIntervention(DMP dmp, String date, Boolean publierDemande, Boolean demandeRemplie, String type) {
        this.dmp = dmp;
        this.date = date;
        this.publierDemande = publierDemande;
        this.demandeRemplie = demandeRemplie;
        this.type = type;
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

    public Boolean getPublierDemande() { return publierDemande; }

    public void setPublierDemande(Boolean publierDemande) { this.publierDemande = publierDemande; }

    public Boolean getDemandeRemplie() { return demandeRemplie; }

    public void setDemandeRemplie(Boolean demandeRemplie) { this.demandeRemplie = demandeRemplie; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DemandeIntervention{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", date='" + date + '\'' +
                ", publierDemande=" + publierDemande +
                ", demandeRemplie=" + demandeRemplie +
                ", type='" + type + '\'' +
                '}';
    }
}
