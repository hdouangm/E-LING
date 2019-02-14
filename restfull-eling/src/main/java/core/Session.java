package main.java.core;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Session {

	private final EntityManagerFactory emf;
	
	private Session(String str){
		this.emf = Persistence.createEntityManagerFactory(str);
	}
	
	public static Session getSession(main.java.core.Persistence persist){
			return new Session(persist.getPersistence());
	}
	
	public EntityManagerFactory getEmf(){
		return emf;
	}
}
