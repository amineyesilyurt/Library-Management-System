package edu.gtu.amine;

/**
 *
 * @author Amine
 */
public class LibraryStaff extends AbstractUser {

    private Database database = Database.getInstance();//database

    /**
     *
     * This constructor calls AbstractUser's constructor
     * Adds the staff to user database , if catches the exception print the message to the screen
     * @param userName name of the staff
     * @param password password of the staff
     */
    public LibraryStaff(String userName, String password) {
        super(userName, password);
        try {
            database.addUser(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     *  Takes book as a paramater and add the book to book database
     *  If catches exception print the message
     * @param theBook the book will add to book database
     */
    public void addBook(Book theBook) {
            database.addBook(theBook);
    }

    /**
     *  Remove the book from book database if catches eception print the message on screen
     * @param theBook the book which will remove the book database
     */
    public void removeBook(Book theBook) {
        try {
            database.removeBook(theBook);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    /**
     * Register the user, takes  a user as a parameter and add the user to user database
     * If catches exception print the mesage on the screen
     * @param theUsr
     */
    public void RegisterUser(User theUsr) {
        try {
            database.addUser(theUsr);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     *  Display all users (not include staffs ).
     */
    public void displayAllUserOnDatabase() {
        System.out.println("All Users: ");
        for (int i = 0; i < database.getUsers().size(); ++i) {
            User usr = database.getUsers().get(i);
            if (usr instanceof LibraryUser) {
                LibraryUser libUser = (LibraryUser) usr;
                System.out.println(libUser.toString());
            }

        }
    }

    /**
     *  Display staff's profile
     */

    @Override
    public void displayMyProfile() {
        System.out.println("******************YOUR PRFOFILE******************");
        System.out.println("   Library Staff :");
        String profile = String.format("   Nickname :" + getUserName() + "\n");
        profile += String.format("   Password :" + getPassword() + "\n");
        System.out.print(profile);
        System.out.println("*************************************************");

    }

    /**
     *
     * @return false if staff not register to the system, return true if staff already registered system.
     */

    @Override
    public boolean logIn() {

        for (int i = 0; i < database.getUsers().size(); ++i) {
            User usr = database.getUsers().get(i);
            if (usr instanceof LibraryStaff) {
                LibraryStaff targetStaff = (LibraryStaff) usr;
                if (this.equals(targetStaff)) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     *
     * @param obj staff object
     * @return true if two staff's userName and password same
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibraryStaff other = (LibraryStaff) obj;
        if (this.getUserName() != other.getUserName()
                && this.getPassword() != other.getPassword()) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return string of staff's information (user name and password)
     */
    @Override
    public String toString() {
        String result = String.format("LibraryStaff{ user name= " + getUserName() + " password= " + getPassword() + " }");
        return result;
    }

    /**
     *
     * @return string of staff's information like csv(commo seperated) format
     */
    public String toCsvFormat() {
        String result = String.format(getUserName() + "," + getPassword() + "\n");
        return result;
    }

}
