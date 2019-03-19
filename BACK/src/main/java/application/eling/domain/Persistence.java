package application.eling.domain;

public enum Persistence {
	
	ELING("JPAPU");
	
	private String persistence;
	
	Persistence(String persist){
		this.persistence = persist;
	}

	public String getPersistence() {
		return persistence;
	}
	

}
