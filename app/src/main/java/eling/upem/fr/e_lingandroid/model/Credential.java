package eling.upem.fr.e_lingandroid.model;

public class Credential {

    private String nom, prenom, token;

    public Credential(String nom, String prenom, String token) {
        this.nom = nom;
        this.prenom = prenom;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
