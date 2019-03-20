package eling.upem.fr.e_lingandroid.model;

import java.io.Serializable;


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