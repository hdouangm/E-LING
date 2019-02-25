package main.java.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
public class CompteAphp {
    public static final String FIND_ALL = "CompteAphp.findAllCompteAphp";

    private String login;
    private String motDePasse;
    private String langue;

    public CompteAphp() {

    }

    public CompteAphp(String login, String motDePasse, String langue) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.langue = langue;
    }

    @Id
    @GeneratedValue
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Override
    public String toString() {
        return "CompteAphp{" +
                "login='" + login + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", langue='" + langue + '\'' +
                '}';
    }
}