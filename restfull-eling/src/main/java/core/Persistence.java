package main.java.core;

public enum Persistence {
	
	ELING("Eling");
	
	private String persistence;
	
	private Persistence(String persist){
		this.persistence = persist;
	}

	public String getPersistence() {
		return persistence;
	}
	

}
