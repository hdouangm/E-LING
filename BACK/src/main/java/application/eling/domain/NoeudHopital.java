package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static application.eling.domain.NoeudHopital.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM NoeudHopital b ORDER BY b.id DESC")
public class NoeudHopital implements Serializable {
    public static final String FIND_ALL = "NoeudHopital.findAllNoeudHopitals";

    @Id
    @GeneratedValue
    private Integer id;
    private Integer niveau;
    private List<NoeudHopital> noeudsInferieurs;
    @OneToOne(cascade = CascadeType.ALL)
    private Employe chef;
    @OneToOne(cascade=CascadeType.ALL)
    Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public NoeudHopital(){

    }

    public NoeudHopital(Integer niveau, List<NoeudHopital> noeudsInferieurs, Employe chef) {
        this.niveau = niveau;
        this.noeudsInferieurs = noeudsInferieurs;
        this.chef = chef;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public List<NoeudHopital> getNoeudsInferieurs() {
        return noeudsInferieurs;
    }

    public void setNoeudsInferieurs(List<NoeudHopital> noeudsInferieurs) {
        this.noeudsInferieurs = noeudsInferieurs;
    }

    public Employe getChef() {
        return chef;
    }

    public void setChef(Employe chef) {
        this.chef = chef;
    }

    @Override
    public String toString() {
        return "NoeudHopital{" +
                "id=" + id +
                ", niveau=" + niveau +
                ", noeudsInferieurs=" + noeudsInferieurs +
                ", chef=" + chef +
                '}';
    }
}
