package application.domain;

import static application.domain.Patient.FIND_ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;



@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Patient b ORDER BY b.id DESC")
public class Patient {
    public static final String FIND_ALL = "Patient.findAllPatients";
    @Id
    @GeneratedValue
    private Integer id;
    
    @OneToOne
    private NoeudHopital noeudHopital;
    
    @OneToOne
    private DMP dmp;
    
    @OneToOne
    private DonneesSociales donneesSociales;

    public Patient(){

    }

    public Patient(NoeudHopital noeudHopital, DMP dmp, DonneesSociales donneesSociales) {
        this.noeudHopital = noeudHopital;
        this.dmp = dmp;
        this.donneesSociales = donneesSociales;
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