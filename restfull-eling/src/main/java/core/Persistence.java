package main.java.core;

public enum Persistence {
	
	ELING("JPAPU");
	
	private String persistence;
	
	private Persistence(String persist){
		this.persistence = persist;
	}

	public String getPersistence() {
		return persistence;
	}
	

}
