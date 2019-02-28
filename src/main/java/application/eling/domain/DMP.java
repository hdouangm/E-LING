package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;

import static application.eling.domain.DMP.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DMP b ORDER BY b.id DESC")
public class DMP implements Serializable {
    public static final String FIND_ALL = "DMP.findAllDMPs";

    @Id
    @GeneratedValue
    private Integer id;
    private String ss;

    @OneToOne(cascade = CascadeType.ALL)
    private Intervention intervention;
    @OneToOne(cascade = CascadeType.ALL)
    private DemandeIntervention demandeIntervention;


    public DMP(){

    }

    public DMP(String ss){
        this.ss = ss;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public DemandeIntervention getDemandeIntervention() {
        return demandeIntervention;
    }

    public void setDemandeIntervention(DemandeIntervention demandeIntervention) {
        this.demandeIntervention = demandeIntervention;
    }

    @Override
    public String toString() {
        return "DMP{" +
                "id=" + id +
                ", ss='" + ss + '\'' +
                '}';
    }
}
