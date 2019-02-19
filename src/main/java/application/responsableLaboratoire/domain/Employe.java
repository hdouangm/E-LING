package application.responsableLaboratoire.domain;

import java.util.ArrayList;


public class Employe { // I don't need this model anymore, DataManager component saved the situation
	private int id;
        private String name;
	private CompteAphp compteAphp;
	private int niveau;
	private ArrayList<String> Competences;
	private NoeudHopital noeudHopital;
	private DonneesSociales donneesSociales;
	
	public Employe(int id, String name, CompteAphp compteAphp, int niveau, ArrayList<String> competences, NoeudHopital noeudHopital,
			DonneesSociales donneesSociales) {
		super();

                this.id = id;
		this.name = name;
                this.compteAphp = compteAphp;
		this.niveau = niveau;
		Competences = competences;
		this.noeudHopital = noeudHopital;
		this.donneesSociales = donneesSociales;
	}

	public boolean save() {
		/*
		 * Noeud deja existant 
		 * 
		 * 
		 */
		return false;
	}

	public boolean update() {
		
		return false;
	}
	
	public boolean delete() {
		
		return false;
	}
        
        public static ArrayList<Employe> getAllEmployes(){
            ArrayList<Employe> employes = new ArrayList<>();
            Employe e1 = new Employe(1, "Reda", null, 0, null, null, null);
            Employe e2 = new Employe(2, "Redaa", null, 0, null, null, null);
            Employe e3 = new Employe(3, "Redaaa", null, 0, null, null, null);
            
            employes.add(e3);
            employes.add(e1);
            employes.add(e2);
            
            return employes;
        }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompteAphp getCompteAphp() {
		return compteAphp;
	}

	public void setCompteAphp(CompteAphp compteAphp) {
		this.compteAphp = compteAphp;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public ArrayList<String> getCompetences() {
		return Competences;
	}

	public void setCompetences(ArrayList<String> competences) {
		Competences = competences;
	}

	public NoeudHopital getNoeudHopital() {
		return noeudHopital;
	}

	public void setNoeudHopital(NoeudHopital noeudHopital) {
		this.noeudHopital = noeudHopital;
	}

	public DonneesSociales getDonneesSociales() {
		return donneesSociales;
	}

	public void setDonneesSociales(DonneesSociales donneesSociales) {
		this.donneesSociales = donneesSociales;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Employe [id=" + id + ", compteAphp=" + compteAphp + ", Niveau=" + niveau + ", Competences="
				+ Competences + ", noeudHopital=" + noeudHopital + ", donneesSociales=" + donneesSociales + "]";
	}
	
	
}
