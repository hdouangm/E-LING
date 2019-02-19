package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.util.List;

import static application.eling.domain.NoeudHopital.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM NoeudHopital b ORDER BY b.id DESC")
public class NoeudHopital {
    public static final String FIND_ALL = "NoeudHopital.findAllNoeudHopitals";
    @Id
    @GeneratedValue
    private Integer id;
    private Integer niveau;
    private List<String> noeudsInferieurs;
    private Employe chef;

    public NoeudHopital(){

    }

    public NoeudHopital(Integer niveau, List<String> noeudsInferieurs, Employe chef) {
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

    public List<String> getNoeudsInferieurs() {
        return noeudsInferieurs;
    }

    public void setNoeudsInferieurs(List<String> noeudsInferieurs) {
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
