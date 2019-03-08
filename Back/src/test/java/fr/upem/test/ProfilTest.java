/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.test;

import application.repository.DonneesSocialesRepository;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author asus
 */
public class ProfilTest extends TestCase
{

    DonneesSocialesRepository repository;
    
    public ProfilTest( String testName )
    {
        super( testName );
        repository = new DonneesSocialesRepository();
    }
    

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ProfilTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void test()
    {
       //assertEquals(Boolean.FALSE , repository.connexion("admin","admin"));
       /* assertEquals(Boolean.FALSE, repository.connexion("rokia","admin"));
        assertEquals(Boolean.TRUE,repository.connexion("rokia","diallo"));*/
        
    }
}
