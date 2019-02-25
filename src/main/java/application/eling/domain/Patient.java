package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.io.Serializable;

import static application.eling.domain.Patient.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Patient b ORDER BY b.id DESC")
public class Patient implements Serializable {
    public static final String FIND_ALL = "Patient.findAllPatients";

    private Integer id;
    private NoeudHopital noeudHopital;
    private DMP dmp;
    private DonneesSociales donneesSociales;

    public Patient(){

    }

    public Patient(NoeudHopital noeudHopital, DMP dmp, DonneesSociales donneesSociales) {
        this.noeudHopital = noeudHopital;
        this.dmp = dmp;
        this.donneesSociales = donneesSociales;
    }

    @Id
    @GeneratedValue
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
                ", donneesSociales=" + donneesSociales +
                '}';
    }
}
