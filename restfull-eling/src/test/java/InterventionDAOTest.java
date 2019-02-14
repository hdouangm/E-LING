package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.core.Intervention;
import main.java.core.InterventionDAO;

public class InterventionDAOTest {

	@Test
	public void creerEtSupprimerIntervention() {
		InterventionDAO dao = new InterventionDAO();
		Intervention intervention = new Intervention(999, "test");
		try {
			dao.create(intervention);
			dao.delete(intervention.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void modifierIntervention() {
		InterventionDAO dao = new InterventionDAO();
		Intervention intervention = new Intervention(999, "test");
		try {
			dao.create(intervention);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		intervention.setName("test_ok");
		try {
			dao.update(intervention);
			intervention = dao.get(999);
			if(!intervention.getName().equals("test_ok"))
				fail("Modification failed");
			dao.delete(intervention.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
