package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;

import static application.eling.domain.DonneesSociales.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DonneesSociales b ORDER BY b.id DESC")
public class DonneesSociales implements Serializable {
    public static final String FIND_ALL = "DonneesSociales.findAllDonneesSocialess";

    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String codePostal;
    private String pays;
    private String genre;
    private String age;
    @OneToOne(cascade = CascadeType.ALL)
    private Employe employe;
    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;

    public DonneesSociales(){

    }

    public DonneesSociales(String nom, String prenom, String adresse, String ville, String codePostal, String pays, String age, String genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.pays = pays;
        this.age = age;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getGenre() { return genre; }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "DonneesSociales{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", pays='" + pays + '\'' +
                ", genre='" + genre + '\'' +
                ", age='" + age + '\'' +
                '}';
    }}
