package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Competence> competences  = new HashSet<Competence>(0);
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Patient> patient = new HashSet<Patient>();

    public Employe() {

    }

    public Employe(NoeudHopital noeudHopital, CompteAphp compteAphp, DonneesSociales donneesSociales, Integer niveau, Set<Competence> competences, Set<Patient> patient) {
        this.noeudHopital = noeudHopital;
        this.compteAphp = compteAphp;
        this.donneesSociales = donneesSociales;
        this.niveau = niveau;
        this.competences = competences;
        this.patient = patient;
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

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }

    public Set<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Set<Patient> patient) {
        this.patient = patient;
    }

    public void addPatient(Patient patient) {
        this.patient.add(patient);
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", noeudHopital=" + noeudHopital +
                ", compteAphp=" + compteAphp +
                ", donneesSociales=" + donneesSociales +
                ", examen=" + examen +
                ", niveau=" + niveau +
                ", competences=" + competences +
                ", patient=" + patient +
                '}';
    }
}
