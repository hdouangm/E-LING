package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.core.Diagnostique;
import main.java.core.DiagnostiqueDAO;

public class DiagnostiqueDAOTest {

	@Test
	public void creerEtSupprimerDiagnostique() {
		DiagnostiqueDAO dao = new DiagnostiqueDAO();
		Diagnostique diagnostique = new Diagnostique(999, "test");
		try {
			dao.create(diagnostique);
			dao.delete(diagnostique.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void modifierDiagnostique() {
		DiagnostiqueDAO dao = new DiagnostiqueDAO();
		Diagnostique diagnostique = new Diagnostique(999, "test");
		try {
			dao.create(diagnostique);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		diagnostique.setName("test_ok");
		try {
			dao.update(diagnostique);
			diagnostique = dao.get(999);
			if(!diagnostique.getName().equals("test_ok"))
				fail("Modification failed");
			dao.delete(diagnostique.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
