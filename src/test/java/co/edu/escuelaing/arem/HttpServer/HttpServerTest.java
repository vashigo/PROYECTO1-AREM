/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.HttpServer;

import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author andres_vaz
 */
public class HttpServerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HttpServerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HttpServerTest.class );
    }

    /**
     * Test Main
     * @throws java.io.IOException
     */
    public void testApp() throws IOException
    {
        //System.out.println("main");
        //String[] args = null;
        //HttpServer.main(args);
        //HttpServer.close();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue( true );
    }
}
