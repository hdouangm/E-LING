package test.java;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import main.java.core.Acte;
import main.java.core.Examen;
import main.java.core.ExamenDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExamenDAOTest {

	@Test
	public void testa_creerExamen() {
		ExamenDAO dao = new ExamenDAO();
		Examen examen = new Examen();
		try {
			dao.create(examen);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testb_getAndModifierExamen() {
		ExamenDAO dao = new ExamenDAO();
		Examen examen = dao.findAll().get(0);
		examen.setPrix(10);
		try {
			dao.update(examen);
			examen = dao.findAll().get(0);
			assertTrue(examen.getPrix()==10);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void testd_supprimerExamen() {
		ExamenDAO dao = new ExamenDAO();
		Examen examen = dao.findAll().get(0);
		try {
			dao.delete(examen.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertTrue(dao.findAll().isEmpty());
	}
	
	@Test
	public void testc_coderActe() {
		ExamenDAO dao = new ExamenDAO();
		Examen examen = dao.findAll().get(0);
		Acte acte = new Acte();
		acte.setDescription("acte_test");
		acte.setPrix(15);
		examen.getCodesActes().add(acte);
		try {
			dao.update(examen);
			examen = dao.findAll().get(0);
			assertTrue(examen.getCodesActes().size()==1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	

}
