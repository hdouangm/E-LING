package test.java;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import main.java.core.Acte;
import main.java.core.Intervention;
import main.java.core.InterventionDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InterventionDAOTest {

	@Test
	public void testa_creerIntervention() {
		InterventionDAO dao = new InterventionDAO();
		Intervention intervention = new Intervention();
		try {
			dao.create(intervention);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testb_getAndModifierIntervention() {
		InterventionDAO dao = new InterventionDAO();
		Intervention intervention = dao.findAll().get(0);
		intervention.setPrix(10);
		try {
			dao.update(intervention);
			intervention = dao.findAll().get(0);
			assertTrue(intervention.getPrix()==10);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void testd_supprimerIntervention() {
		InterventionDAO dao = new InterventionDAO();
		Intervention intervention = dao.findAll().get(0);
		try {
			dao.delete(intervention.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertTrue(dao.findAll().isEmpty());
	}
	
	@Test
	public void testc_coderActe() {
		InterventionDAO dao = new InterventionDAO();
		Intervention intervention = dao.findAll().get(0);
		Acte acte = new Acte();
		acte.setDescription("acte_test");
		acte.setPrix(15);
		intervention.getCodesActes().add(acte);
		try {
			dao.update(intervention);
			intervention = dao.findAll().get(0);
			assertTrue(intervention.getCodesActes().size()==1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	

}
