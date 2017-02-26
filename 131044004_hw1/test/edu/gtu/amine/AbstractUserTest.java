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
public class AbstractUserTest {
    

    /**
     * Test of getUserName method, of class AbstractUser.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        AbstractUser instance = null;
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class AbstractUser.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        AbstractUser instance = null;
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class AbstractUser.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        AbstractUser instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class AbstractUser.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        AbstractUser instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listBooksOnShelf method, of class AbstractUser.
     */
    @Test
    public void testListBooksOnShelf() {
        System.out.println("listBooksOnShelf");
        AbstractUser instance = null;
        instance.listBooksOnShelf();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllBooks method, of class AbstractUser.
     */
    @Test
    public void testListAllBooks() {
        System.out.println("listAllBooks");
        AbstractUser instance = null;
        instance.listAllBooks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractUserImpl extends AbstractUser {

        public AbstractUserImpl() {
            super("", "");
        }

    }
    
}
