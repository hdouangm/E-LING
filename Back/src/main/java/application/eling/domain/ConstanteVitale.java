package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.io.Serializable;
import java.util.List;

import static application.eling.domain.ConstanteVitale.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM ConstanteVitale b ORDER BY b.id DESC")
public class ConstanteVitale implements Serializable {
    public static final String FIND_ALL = "ConstanteVitale.findAllConstanteVitales";

    @Id
    @GeneratedValue
    private Integer id;
    private DMP dmp;
    private String date;
    private String constante;
    private Employe infirmierEnCharge;

    public ConstanteVitale(){

    }

    public ConstanteVitale(DMP dmp, String date, String constante, Employe infirmierEnCharge) {
        this.dmp = dmp;
        this.date = date;
        this.constante = constante;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConstante() {
        return constante;
    }

    public void setConstante(String constante) {
        this.constante = constante;
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
                ", constante=" + constante +
                ", infirmierEnCharge=" + infirmierEnCharge +
                '}';
    }
}
