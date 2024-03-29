package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;

import static application.eling.domain.Patient.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Patient b ORDER BY b.id DESC")
public class Patient implements Serializable {
    public static final String FIND_ALL = "Patient.findAllPatients";

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne(cascade=CascadeType.ALL)
    private NoeudHopital noeudHopital;
    @OneToOne(cascade=CascadeType.ALL)
    private DMP dmp;
    @ManyToOne(cascade=CascadeType.ALL)
    private DonneesSociales donneesSociales;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Employe employe;

    public Patient(){

    }

    public Patient(NoeudHopital noeudHopital, DMP dmp, DonneesSociales donneesSociales, Employe employe) {
        this.noeudHopital = noeudHopital;
        this.dmp = dmp;
        this.donneesSociales = donneesSociales;
        this.employe = employe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NoeudHopital getNoeudHopital() {
        return noeudHopital;
    }

    public void setNoeudHopital(NoeudHopital noeudHopital) {
        this.noeudHopital = noeudHopital;
    }

    public DMP getDmp() {
        return dmp;
    }

    public void setDmp(DMP dmp) {
        this.dmp = dmp;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public DonneesSociales getDonneesSociales() {
        return donneesSociales;
    }

    public void setDonneesSociales(DonneesSociales donneesSociales) {
        this.donneesSociales = donneesSociales;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", noeudHopital=" + noeudHopital +
                ", dmp=" + dmp +
                ", employe=" + employe +
                ", donneesSociales=" + donneesSociales +
                '}';
    }
}
