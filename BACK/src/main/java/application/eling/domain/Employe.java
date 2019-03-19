package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static application.eling.domain.Employe.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Employe b ORDER BY b.id DESC")
public class Employe implements Serializable {
    public static final String FIND_ALL = "Employe.findAllEmployes";

    @Id
    @GeneratedValue
    private Integer id;



    @OneToOne(cascade=CascadeType.ALL)
    private NoeudHopital noeudHopital;
    @OneToOne(cascade=CascadeType.ALL)
    private CompteAphp compteAphp;
    @OneToOne(cascade=CascadeType.ALL)
    private DonneesSociales donneesSociales;
    @OneToOne(cascade = CascadeType.ALL)
    private Examen examen;
    private Integer niveau;
    private List<String> competences;

    public Employe() {

    }

    public Employe(NoeudHopital noeudHopital, CompteAphp compteAphp, DonneesSociales donneesSociales, Integer niveau, List<String> competences) {
        this.noeudHopital = noeudHopital;
        this.compteAphp = compteAphp;
        this.donneesSociales = donneesSociales;
        this.niveau = niveau;
        this.competences = competences;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
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

    public CompteAphp getCompteAphp() {
        return compteAphp;
    }

    public void setCompteAphp(CompteAphp compteAphp) {
        this.compteAphp = compteAphp;
    }

    public DonneesSociales getDonneesSociales() {
        return donneesSociales;
    }

    public void setDonneesSociales(DonneesSociales donneesSociales) {
        this.donneesSociales = donneesSociales;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", noeudHopital=" + noeudHopital +
                ", compteAphp=" + compteAphp +
                ", donneesSociales=" + donneesSociales +
                ", niveau=" + niveau +
                ", competences=" + competences +
                '}';
    }
}
