package edu.gtu.amine;

/**
 * @author Amine
 *         This class implements User interface
 */
public abstract class AbstractUser implements User {

    private String userName; //user name
    private String password;

    private Database database = Database.getInstance();//database singleton object

    /**
     * @return userName of the user (Library Staff or Library Member)
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName user name of the user
     *                 Sets user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Constructor with two arguments
     *
     * @param userName username of the user
     * @param password password of the user
     */
    public AbstractUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Lists book on the shelf.
     * If any library member borrow the book then this book in this list.
     * This methods checks if any one borrow the book, if someone borrowed then the book
     * does not show in the list.
     */
    public void listBooksOnShelf() {
        System.out.println("Books On Shelf: ");
        for (int i = 0; i < database.getBooks().size(); ++i) {
            if (database.getBooks().get(i).getWhoBorrowed() == -1) {
                System.out.println(database.getBooks().get(i).toString());
            }
        }
    }

    /**
     * Lists all books int the library
     */
    public void listAllBooks() {
        System.out.println("All books: ");
        for (int i = 0; i < database.getBooks().size(); ++i) {
            System.out.println(database.getBooks().get(i).toString());
        }
    }
}