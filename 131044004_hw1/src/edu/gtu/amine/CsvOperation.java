package edu.gtu.amine;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Amine
 */
public class CsvOperation {

    private Database database = Database.getInstance(); //database singleton object

    /**
     * creates user.csv , staff.csv and book.csv
     * fill the these files with datas same as database
     */
    public void createFiles() {
        try {
            writeToStaffFile();
            writeToUserFile();
            writeToBookFile();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    private void writeToStaffFile() throws IOException {

        PrintWriter pw = new PrintWriter(new File("staff.csv"));

        for (int i = 0; i < database.getUsers().size(); ++i) {

            User usr = database.getUsers().get(i);
            if (usr instanceof LibraryStaff) {
                LibraryStaff targetStaff = (LibraryStaff) usr;
                pw.write(targetStaff.toCsvFormat());

            }
        }
        pw.close();

    }

    private void writeToUserFile() throws IOException {

        PrintWriter pw = new PrintWriter(new File("user.csv"));

        for (int i = 0; i < database.getUsers().size(); ++i) {

            User usr = database.getUsers().get(i);
            if (usr instanceof LibraryUser) {
                LibraryUser targetUser = (LibraryUser) usr;
                pw.write(targetUser.toCsvFormat());

            }
        }
        pw.close();

    }

    private void writeToBookFile() throws IOException {

        PrintWriter pw = new PrintWriter(new File("book.csv"));

        for (int i = 0; i < database.getBooks().size(); ++i) {

            Book theBook = database.getBooks().get(i);
            pw.write(theBook.toCsvFormat());

        }
        pw.close();

    }
}
