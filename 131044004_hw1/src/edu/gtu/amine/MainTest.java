/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gtu.amine;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amine
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LibraryStaff admin = new LibraryStaff("amine", "1234");
        admin.logIn();

        LibraryUser usr1 = new LibraryUser("Nisa", "nisa7477");
        LibraryUser usr2 = new LibraryUser("Ali", "ali_25");
        admin.RegisterUser(usr1);
        admin.RegisterUser(usr2);

        usr1.logIn();

        Book b1 = new Book("Suc ve Ceza", "Dostoyevski", -1);
        Book b2 = new Book("Yaprak Dokumu", "Resat Nuri Guntekin", -1);
        Book b3 = new Book("Suc ve Ceza", "Dostoyevski", -1);
        Book b4 = new Book("Yaprak Dokumu", "Resat Nuri Guntekin", -1);
        Book b5 = new Book("Bögürtlen", "Yahya", -1);

        //admin.addBook(b1);
        admin.addBook(b2);
        admin.addBook(b3);
       // admin.addBook(b4);

        try {
            usr1.borrowBook(b2);
        } catch (Exception ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        CsvOperation csvOperation = new CsvOperation();
        csvOperation.createFiles();

    }

}
