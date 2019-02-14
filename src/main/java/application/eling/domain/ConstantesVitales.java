package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.eling.domain.ConstantesVitales.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM ConstantesVitales b ORDER BY b.id DESC")
public class ConstantesVitales {

    public static final String FIND_ALL = "ConstantesVitales.findAllConstantesVitaless";
    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;

    public ConstantesVitales(){

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
