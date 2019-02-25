package test.java;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import main.java.core.Acte;
import main.java.core.Posologie;
import main.java.core.PosologieDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PosologieDAOTest {

	@Test
	public void testa_creerPosologie() {
		PosologieDAO dao = new PosologieDAO();
		Posologie eosologie = new Posologie();
		try {
			dao.create(eosologie);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testb_getAndModifierPosologie() {
		PosologieDAO dao = new PosologieDAO();
		Posologie eosologie = dao.findAll().get(0);
		eosologie.setPrix(10);
		try {
			dao.update(eosologie);
			eosologie = dao.findAll().get(0);
			assertTrue(eosologie.getPrix()==10);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void testd_supprimerPosologie() {
		PosologieDAO dao = new PosologieDAO();
		Posologie eosologie = dao.findAll().get(0);
		try {
			dao.delete(eosologie.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertTrue(dao.findAll().isEmpty());
	}
	
	@Test
	public void testc_coderActe() {
		PosologieDAO dao = new PosologieDAO();
		Posologie eosologie = dao.findAll().get(0);
		Acte acte = new Acte();
		acte.setDescription("acte_test");
		acte.setPrix(15);
		eosologie.getCodesActes().add(acte);
		try {
			dao.update(eosologie);
			eosologie = dao.findAll().get(0);
			assertTrue(eosologie.getCodesActes().size()==1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	

}
