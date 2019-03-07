package main.java.core;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Examen implements Serializable {
  
    @Id
    @GeneratedValue
    private int id;
    private String date;
    private String resultats;
  //  private Employe responsable;
    private boolean publicationMed=false;
    private boolean publicationLab=false;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Acte> codesActes = new HashSet<Acte>(0);
    private int prix;
    private boolean payer=false;

    public Examen(){

    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean getPublicationMed() {
		return publicationMed;
	}

	public void setPublicationMed(boolean publicationMed) {
		this.publicationMed = publicationMed;
	}

	public boolean getPublicationLab() {
		return publicationLab;
	}

	public void setPublicationLab(boolean publicationLab) {
		this.publicationLab = publicationLab;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public boolean getPayer() {
		return payer;
	}

	public void setPayer(boolean payer) {
		this.payer = payer;
	}

	public Set<Acte> getCodesActes() {
		return codesActes;
	}

	public void setCodesActes(Set<Acte> codesActes) {
		this.codesActes = codesActes;
	}

	public String getResultats() {
		return resultats;
	}

	public void setResultats(String resultats) {
		this.resultats = resultats;
	}


	/*public Employe getResponsable() {
		return responsable;
	}

	public void setResponsable(Employe responsable) {
		this.responsable = responsable;
	}*/

	
	

}
