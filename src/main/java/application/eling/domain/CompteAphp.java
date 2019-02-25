package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.io.Serializable;

import static application.eling.domain.CompteAphp.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM CompteAphp b ORDER BY b.login DESC")
public class CompteAphp implements Serializable {
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