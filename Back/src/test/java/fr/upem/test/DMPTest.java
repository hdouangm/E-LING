/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.test;

import application.domain.DMP;
import application.domain.DonneesSociales;
import application.domain.NoeudHopital;
import application.domain.Patient;
import application.repository.DMPRepository;
import javax.ejb.EJB;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author asus
 */
public class DMPTest extends TestCase {
   
    @EJB
    private DMPRepository repository;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DMPTest( String testName )
    {
        super(testName);
        repository = new DMPRepository();
    }
    

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DMPTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testNotNUll()
    {  
        //repository.findByPatient(new Patient(new NoeudHopital(), new DMP(new Long(308),"sss"), new DonneesSociales()));
        /*assertNotNull("ok", repository.findByPatient(new Patient(new NoeudHopital(), new DMP(new Long(308),"sss"), new DonneesSociales())));
        assertNull("error", repository.findByPatient(new Patient(new NoeudHopital(), new DMP(new Long(208),"sss"), new DonneesSociales())));
      */
    }
    
    
}
