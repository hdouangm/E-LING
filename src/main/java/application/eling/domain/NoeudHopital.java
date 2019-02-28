package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static application.eling.domain.NoeudHopital.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM NoeudHopital b ORDER BY b.id DESC")
public class NoeudHopital implements Serializable {
    public static final String FIND_ALL = "NoeudHopital.findAllNoeudHopitals";

    @Id
    @GeneratedValue
    private Integer id;
    private Integer niveau;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<NoeudHopital> noeudsInferieurs;
    private Employe chef;
    @ManyToOne(cascade = CascadeType.ALL)
    private NoeudHopital noeudSuperieur;


    public NoeudHopital(){

    }

    public NoeudHopital(Integer niveau, Set<NoeudHopital> noeudsInferieurs, Employe chef) {
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

    public Set<NoeudHopital> getNoeudsInferieurs() { return noeudsInferieurs; }

    public void setNoeudsInferieurs(Set<NoeudHopital> noeudsInferieurs) { this.noeudsInferieurs = noeudsInferieurs; }

    public Employe getChef() {
        return chef;
    }

    public void setChef(Employe chef) {
        this.chef = chef;
    }

    public NoeudHopital getNoeudSuperieur() { return noeudSuperieur; }

    public void setNoeudSuperieur(NoeudHopital noeudSuperieur) { this.noeudSuperieur = noeudSuperieur; }

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
