package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.eling.domain.DonneesSociales.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DonneesSociales b ORDER BY b.id DESC")
public class DonneesSociales {
    public static final String FIND_ALL = "DonneesSociales.findAllDonneesSocialess";
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private String prenom;
    private String adressse;
    private String ville;
    private String codePostal;
    private String pays;
    private String genre;
    private String age;

    public DonneesSociales(){

    }

    public DonneesSociales(String nom, String prenom, String adressse, String ville, String codePostal, String pays, String age, String genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.adressse = adressse;
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

    public String getAdressse() {
        return adressse;
    }

    public void setAdressse(String adressse) {
        this.adressse = adressse;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DonneesSociales{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adressse='" + adressse + '\'' +
                '}';
    }
}
