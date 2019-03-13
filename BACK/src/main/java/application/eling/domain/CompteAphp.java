package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;

import static application.eling.domain.CompteAphp.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM CompteAphp b ORDER BY b.login DESC")
public class CompteAphp implements Serializable {
    public static final String FIND_ALL = "CompteAphp.findAllCompteAphp";

    @Id
    @GeneratedValue
    private String login;
    private String motDePasse;
    private String langue;

    @OneToOne(cascade = CascadeType.ALL)
    private Employe employe;

    public CompteAphp() {

    }


    public CompteAphp(String login, String motDePasse, String langue, Employe employe) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.langue = langue;
		this.employe = employe;
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

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
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