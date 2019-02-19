package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.util.Date;
import java.util.List;

import static application.eling.domain.ConstantesVitales.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM ConstantesVitales b ORDER BY b.id DESC")
public class ConstantesVitales {
    public static final String FIND_ALL = "ConstantesVitales.findAllConstantesVitaless";
    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;
    private Date date;
    private List<String> constantes;
    private Employe infirmierEnCharge;

    public ConstantesVitales(){

    }

    public ConstantesVitales(DMP dmp, Date date, List<String> constantes, Employe infirmierEnCharge) {
        this.dmp = dmp;
        this.date = date;
        this.constantes = constantes;
        this.infirmierEnCharge = infirmierEnCharge;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getConstantes() {
        return constantes;
    }

    public void setConstantes(List<String> constantes) {
        this.constantes = constantes;
    }

    public Employe getInfirmierEnCharge() {
        return infirmierEnCharge;
    }

    public void setInfirmierEnCharge(Employe infirmierEnCharge) {
        this.infirmierEnCharge = infirmierEnCharge;
    }

    @Override
    public String toString() {
        return "ConstantesVitales{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", date=" + date +
                ", constantes=" + constantes +
                ", infirmierEnCharge=" + infirmierEnCharge +
                '}';
    }
}
