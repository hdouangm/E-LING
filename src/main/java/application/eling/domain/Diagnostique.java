package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.eling.domain.Diagnostique.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Diagnostique b ORDER BY b.id DESC")
public class Diagnostique {

    public static final String FIND_ALL = "Diagnostique.findAllDiagnostiques";

    @Id
    @GeneratedValue
    private Integer id;
    private boolean publication;
    private DMP dmp;

    public Diagnostique(){

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
