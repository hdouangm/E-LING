package application.responsableLaboratoire.domain;

import java.util.ArrayList;

public class NoeudHopital {
	private int id;
	private int niveau;
	private int chef; // id du employé chef
	private ArrayList<NoeudHopital> noeudsInferieurs;
	
	public NoeudHopital(int id, int niveau, int chef, ArrayList<NoeudHopital> noeudsInferieurs) {
		super();
		this.id = id;
		this.niveau = niveau;
		this.chef = chef;
		this.noeudsInferieurs = noeudsInferieurs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getChef() {
		return chef;
	}

	public void setChef(int chef) {
		this.chef = chef;
	}

	public ArrayList<NoeudHopital> getNoeudsInferieurs() {
		return noeudsInferieurs;
	}

	public void setNoeudsInferieurs(ArrayList<NoeudHopital> noeudsInferieurs) {
		this.noeudsInferieurs = noeudsInferieurs;
	}

	@Override
	public String toString() {
		return "NoeudHopital [id=" + id + ", niveau=" + niveau + ", chef=" + chef + ", noeudsInferieurs="
				+ noeudsInferieurs + "]";
	}
	
	
}
