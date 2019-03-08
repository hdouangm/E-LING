package fr.upem.test;

import application.rest.ConnexionRestService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Connexion.
 */
public class ConnexionTest extends TestCase
{
    ConnexionRestService repository;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    ConnexionRestService test;
    
    public ConnexionTest( String testName )
    {
        super( testName );
        repository = new ConnexionRestService();
    }
    

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ConnexionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    
    public void testConnexion()
    {
     //  assertEquals(Boolean.FALSE , repository.connexion("admin","admin"));
       /* assertEquals(Boolean.FALSE, repository.connexion("rokia","admin"));
        assertEquals(Boolean.TRUE,repository.connexion("rokia","diallo"));*/
        
    }
}
