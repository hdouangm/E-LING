package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.eling.domain.DemandeIntervention.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DemandeIntervention b ORDER BY b.id DESC")
public class DemandeIntervention {
    public static final String FIND_ALL = "DemandeIntervention.findAllDemandeInterventions";
    @Id
    @GeneratedValue
    private Integer id;
    private boolean publication;
    private DMP dmp;

    public DemandeIntervention(){

    }

    public Integer getId(){
        return id;
    }

    public DMP getDmp() {
        return dmp;
    }

    public void setDmp(DMP dmp) {
        this.dmp = dmp;
    }

    public boolean isPublication() {
        return publication;
    }

    public void setPublication(boolean publication) {
        this.publication = publication;
    }
}
