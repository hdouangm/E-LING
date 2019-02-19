package application.eling.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.util.Date;

import static application.eling.domain.DemandeExamen.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DemandeExamen b ORDER BY b.id DESC")
public class DemandeExamen {
    public static final String FIND_ALL = "DemandeExamen.findAllDemandeExamens";

    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;
    private String type;
    private Date date;
    private Boolean publication;

    public DemandeExamen(){

    }

    public DemandeExamen(DMP dmp, String type, Date date, Boolean publication) {
        this.dmp = dmp;
        this.type = type;
        this.date = date;
        this.publication = publication;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "DemandeExamen{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", publication=" + publication +
                '}';
    }
}
