package application.responsableLaboratoire.domain;

public class CompteAphp {
	
	private String login;
	private String motDePasse;
	private String langue;
	
	
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
	public CompteAphp(String login, String motDePasse, String langue) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.langue = langue;
	}
	
	
}
