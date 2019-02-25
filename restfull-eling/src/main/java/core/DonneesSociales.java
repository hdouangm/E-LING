package main.java.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
public class DonneesSociales {
    public static final String FIND_ALL = "DonneesSociales.findAllDonneesSocialess";

    private Integer id;
    private String nom;
    private String prenom;
    private String adressse;

    public DonneesSociales(){

    }

    public DonneesSociales(String nom, String prenom, String adressse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adressse = adressse;
    }

    @Id
    @GeneratedValue
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
