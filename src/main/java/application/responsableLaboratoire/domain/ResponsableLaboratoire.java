package application.responsableLaboratoire.domain;

import java.util.ArrayList;

public class ResponsableLaboratoire {
	private int id;
        private String name;
	private CompteAphp compteAphp;
	private int niveau;
	private ArrayList<String> Competences;
	private NoeudHopital noeudHopital;
	private DonneesSociales donneesSociales;
	
	public ResponsableLaboratoire() {
		super();
	}

	public ResponsableLaboratoire(int id, String name, CompteAphp compteAphp, int niveau, ArrayList<String> competences,
			NoeudHopital noeudHopital, DonneesSociales donneesSociales) {
		super();
		this.id = id;
                this.name = name;
		this.compteAphp = compteAphp;
		this.niveau = niveau;
		Competences = competences;
		this.noeudHopital = noeudHopital;
		this.donneesSociales = donneesSociales;
	}

	//---------------------------------------------------------------------------------------------------------------------------
	
	public boolean saveToDB() {
		Employe emp = new Employe(id, name, compteAphp, niveau, Competences, noeudHopital, donneesSociales);
		DataManager dataManager = new DataManager();
		dataManager.setEmploye(emp);
		return dataManager.creerEmploye(emp);
	}
	
	public boolean updateToDB() {
		Employe emp = new Employe(id, name, compteAphp, niveau, Competences, noeudHopital, donneesSociales);
		DataManager dataManager = new DataManager();
		dataManager.setEmploye(emp);
		return dataManager.modifierEmploye(emp);
	}
	
	public boolean deleteFromDB() {
		Employe emp = new Employe(id, name, compteAphp, niveau, Competences, noeudHopital, donneesSociales);
		DataManager dataManager = new DataManager();
		dataManager.setEmploye(emp);
		return dataManager.supprimerEmploye(emp);
	}
	 
	public boolean deconnexion() { // Not sure how it works, I think The call for the component must be in the front-end hmmm
		return Deconnexion.seDeconnecter();
	}
	
	public void ouvrirProfile(String id) { // Not sure how it works, I think The call for the component must be in the front-end hmmm
		Profile.ouvrirProfile(id);
	}
	
	public void creerExamen(Examen examen) { // In my STD this method should return a boolean, but since Examen is returning void I'm returning void too 
		examen.creerExamen();
	}
	
	public void modifierExamen(Examen examen) { // In my STD this method should return a boolean, but since Examen is returning void I'm returning void too 
		examen.modifierExamen();
	}

	public static void supprimerExamen(Long id) { // In my STD this method should return a boolean, but since Examen is returning void I'm returning void too 
            Examen.supprimerExamen(id);
	}
	
	public static void publierExamen(Long id) {   
		Examen.publierExamen(id); // this one is just a setter in Examen
	}
		
	//---------------------------------------------------------------------------------------------------------------------------
	
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

	@Override
	public String toString() {
		return "ResponsableLaboratoire [id=" + id + ", compteAphp=" + compteAphp + ", Niveau=" + niveau
				+ ", Competences=" + Competences + ", noeudHopital=" + noeudHopital + ", donneesSociales="
				+ donneesSociales + "]";
	}

	
}
