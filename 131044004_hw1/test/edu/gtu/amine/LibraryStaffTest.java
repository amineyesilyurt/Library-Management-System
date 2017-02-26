/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gtu.amine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amine
 */
public class LibraryStaffTest {
    
    public LibraryStaffTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addBook method, of class LibraryStaff.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        Book theBook = null;
        LibraryStaff instance = null;
        instance.addBook(theBook);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeBook method, of class LibraryStaff.
     */
    @Test
    public void testRemoveBook() {
        System.out.println("removeBook");
        Book theBook = null;
        LibraryStaff instance = null;
        instance.removeBook(theBook);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegisterUser method, of class LibraryStaff.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        User theUsr = null;
        LibraryStaff instance = null;
        instance.RegisterUser(theUsr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllUserOnDatabase method, of class LibraryStaff.
     */
    @Test
    public void testDisplayAllUserOnDatabase() {
        System.out.println("displayAllUserOnDatabase");
        LibraryStaff instance = null;
        instance.displayAllUserOnDatabase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMyProfile method, of class LibraryStaff.
     */
    @Test
    public void testDisplayMyProfile() {
        System.out.println("displayMyProfile");
        LibraryStaff instance = null;
        instance.displayMyProfile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logIn method, of class LibraryStaff.
     */
    @Test
    public void testLogIn() {
        System.out.println("logIn");
        LibraryStaff instance = null;
        boolean expResult = false;
        boolean result = instance.logIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class LibraryStaff.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        LibraryStaff instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class LibraryStaff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LibraryStaff instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toCsvFormat method, of class LibraryStaff.
     */
    @Test
    public void testToCsvFormat() {
        System.out.println("toCsvFormat");
        LibraryStaff instance = null;
        String expResult = "";
        String result = instance.toCsvFormat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
