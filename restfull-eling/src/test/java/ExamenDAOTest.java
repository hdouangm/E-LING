package test.java;

import static org.junit.Assert.fail;

import org.junit.Test;

import main.java.core.Examen;
import main.java.core.ExamenDAO;

public class ExamenDAOTest {

	@Test
	public void creerEtSupprimerExamen() {
		ExamenDAO dao = new ExamenDAO();
		Examen examen = new Examen(999, "test");
		try {
			dao.create(examen);
			dao.delete(examen.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void modifierExamen() {
		ExamenDAO dao = new ExamenDAO();
		Examen examen = new Examen(999, "test");
		try {
			dao.create(examen);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		examen.setName("test_ok");
		try {
			dao.update(examen);
			examen = dao.get(999);
			if(!examen.getName().equals("test_ok"))
				fail("Modification failed");
			dao.delete(examen.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
