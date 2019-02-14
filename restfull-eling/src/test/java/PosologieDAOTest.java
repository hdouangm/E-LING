package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.core.Posologie;
import main.java.core.PosologieDAO;

public class PosologieDAOTest {

	@Test
	public void creerEtSupprimerPosologie() {
		PosologieDAO dao = new PosologieDAO();
		Posologie posologie = new Posologie(999, "test");
		try {
			dao.create(posologie);
			dao.delete(posologie.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void modifierPosologie() {
		PosologieDAO dao = new PosologieDAO();
		Posologie posologie = new Posologie(999, "test");
		try {
			dao.create(posologie);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		posologie.setName("test_ok");
		try {
			dao.update(posologie);
			posologie = dao.get(999);
			if(!posologie.getName().equals("test_ok"))
				fail("Modification failed");
			dao.delete(posologie.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
