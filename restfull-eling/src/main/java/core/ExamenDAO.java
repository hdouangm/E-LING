package main.java.core;

import javax.ejb.Stateless;


public class ExamenDAO extends GenericDAO<Examen>{

	public ExamenDAO() {
		super(Persistence.ELING);
		try {
			this.create(new Examen());
			this.create(new Examen());
			this.create(new Examen());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
