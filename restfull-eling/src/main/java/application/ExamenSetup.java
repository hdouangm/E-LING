package main.java.application;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import main.java.core.Examen;
import main.java.core.ExamenDAO;
import main.java.core.GenericDAO;

@Startup
@Singleton
public class ExamenSetup {

  @EJB
  private ExamenDAO examenDAO;

  @PostConstruct
  private void createData() {
	  
    try {
    	Examen exam = new Examen();
    	exam.setResultats("arborescence.png");
		examenDAO.create(exam);
		System.out.println(exam.getId());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("k");
	}
  }
}