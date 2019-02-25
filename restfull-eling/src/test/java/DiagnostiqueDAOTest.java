package test.java;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import main.java.core.Acte;
import main.java.core.Diagnostique;
import main.java.core.DiagnostiqueDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DiagnostiqueDAOTest {

	@Test
	public void testa_creerDiagnostique() {
		DiagnostiqueDAO dao = new DiagnostiqueDAO();
		Diagnostique diagnostique = new Diagnostique();
		try {
			dao.create(diagnostique);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testb_getAndModifierDiagnostique() {
		DiagnostiqueDAO dao = new DiagnostiqueDAO();
		Diagnostique diagnostique = dao.findAll().get(0);
		diagnostique.setPrix(10);
		try {
			dao.update(diagnostique);
			diagnostique = dao.findAll().get(0);
			assertTrue(diagnostique.getPrix()==10);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void testd_supprimerDiagnostique() {
		DiagnostiqueDAO dao = new DiagnostiqueDAO();
		Diagnostique diagnostique = dao.findAll().get(0);
		try {
			dao.delete(diagnostique.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertTrue(dao.findAll().isEmpty());
	}
	
	@Test
	public void testc_coderActe() {
		DiagnostiqueDAO dao = new DiagnostiqueDAO();
		Diagnostique diagnostique = dao.findAll().get(0);
		Acte acte = new Acte();
		acte.setDescription("acte_test");
		acte.setPrix(15);
		diagnostique.getCodesActes().add(acte);
		try {
			dao.update(diagnostique);
			diagnostique = dao.findAll().get(0);
			assertTrue(diagnostique.getCodesActes().size()==1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	

}
