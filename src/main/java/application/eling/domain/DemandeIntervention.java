package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.util.Date;

import static application.eling.domain.DemandeIntervention.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DemandeIntervention b ORDER BY b.id DESC")
public class DemandeIntervention {
    public static final String FIND_ALL = "DemandeIntervention.findAllDemandeInterventions";

    private Integer id;
    private DMP dmp;
    private Date date;
    private Boolean publication;
    private String type;

    public DemandeIntervention(){

    }

    public DemandeIntervention(DMP dmp, Date date, Boolean publication, String type) {
        this.dmp = dmp;
        this.date = date;
        this.publication = publication;
        this.type = type;
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

    public Boolean getPublication() {
        return publication;
    }

    public void setPublication(Boolean publication) {
        this.publication = publication;
    }

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
                ", date=" + date +
                ", publication=" + publication +
                ", type='" + type + '\'' +
                '}';
    }
}
