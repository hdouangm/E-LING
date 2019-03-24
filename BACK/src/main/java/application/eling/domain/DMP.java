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

    @OneToOne(cascade = CascadeType.ALL)
    private Examen examen;
    @OneToOne(cascade = CascadeType.ALL)
    private DemandeExamen demandeExamen;

    @OneToOne(cascade=CascadeType.ALL)
    private Patient patient;

    @OneToOne(cascade=CascadeType.ALL)
    private Posologie posologie;

    @OneToOne(cascade=CascadeType.ALL)
    private Diagnostique diagnostique;

    private String profession;
    private String motif;
    private String affectionCongenitales;
    private String maladieInfectieuse;
    private String autreAffections;
    private String interventionsChir;
    private String accidents;
    private String maladies;
    private String allergies;
    private String groupeSanguin;
    private String groupeRhesus;

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getGroupeRhesus() {
        return groupeRhesus;
    }

    public void setGroupeRhesus(String groupeRhesus) {
        this.groupeRhesus = groupeRhesus;
    }

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

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public DemandeExamen getDemandeExamen() {
        return demandeExamen;
    }

    public void setDemandeExamen(DemandeExamen demandeExamen) {
        this.demandeExamen = demandeExamen;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Posologie getPosologie() {
        return posologie;
    }

    public void setPosologie(Posologie posologie) {
        this.posologie = posologie;
    }

    public Diagnostique getDiagnostique() {
        return diagnostique;
    }

    public void setDiagnostique(Diagnostique diagnostique) {
        this.diagnostique = diagnostique;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getAffectionCongenitales() {
        return affectionCongenitales;
    }

    public void setAffectionCongenitales(String affectionCongenitales) {
        this.affectionCongenitales = affectionCongenitales;
    }

    public String getMaladieInfectieuse() {
        return maladieInfectieuse;
    }

    public void setMaladieInfectieuse(String maladieInfectieuse) {
        this.maladieInfectieuse = maladieInfectieuse;
    }

    public String getAutreAffections() {
        return autreAffections;
    }

    public void setAutreAffections(String autreAffections) {
        this.autreAffections = autreAffections;
    }

    public String getInterventionsChir() {
        return interventionsChir;
    }

    public void setInterventionsChir(String interventionsChir) {
        this.interventionsChir = interventionsChir;
    }

    public String getAccidents() {
        return accidents;
    }

    public void setAccidents(String accidents) {
        this.accidents = accidents;
    }

    public String getMaladies() {
        return maladies;
    }

    public void setMaladies(String maladies) {
        this.maladies = maladies;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "DMP{" +
                "id=" + id +
                ", ss='" + ss + '\'' +
                '}';
    }
}
