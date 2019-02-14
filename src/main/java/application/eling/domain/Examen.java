package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.eling.domain.Examen.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Examen b ORDER BY b.id DESC")
public class Examen {
    public static final String FIND_ALL = "Examen.findAllExamens";
    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;

    public Examen(){

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
}
