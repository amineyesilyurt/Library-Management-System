package edu.gtu.amine;

/**
 *
 * @author Amine
 */
public class LibraryUser extends AbstractUser {

    private int userID; //user's ID
    private int countOfBorrowed; // keeps number of  user's borrowed books
    private static int countOfUsers = 0; //for determine user's ID for each user

    private Database database = Database.getInstance();//database

    /**
     *  Constructor of librar user. Takes two parameter.
     *  Initialize count of borrowed book with zero, incerases total user count, sets user ID.
     * @param userName user name of library user
     * @param password password of library user
     */
    public LibraryUser(String userName, String password) {
        super(userName, password);
        countOfBorrowed = 0;
        increaseCountUsers();
        setUserID(countOfUsers); //assigned userID with static counter
    }

    /**
     *
     * @return userID ID of library user
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @param userID ID of library user
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     *
     * @return countOfBorrowed the count of user's borrowed book.
     */
    public int getCountOfBorrowed() {
        return countOfBorrowed;
    }

    /**
     *
     * @param countOfBorrowed count  of user's borrowed book
     */
    public void setCountOfBorrowed(int countOfBorrowed) {
        this.countOfBorrowed = countOfBorrowed;
    }

    /**
     *
     * @return string of user's information (user ID , user name and password, count of borrowed book)
     */
    @Override
    public String toString() {
        return "LibraryUser : userName= " + getUserName() + ", password= " + getPassword()+ " ,user ID= "+getUserID()
                +" ,Count Of Borrowed Books= " +getCountOfBorrowed();
    }

    /**
     * Display Library user information and list user's borrowed book
     */
    @Override
    public void displayMyProfile() {
        System.out.println("******************YOUR PRFOFILE******************");
        System.out.println(this.toString());
        listMyBorrowed();
        System.out.println("*************************************************");
    }

    /**
     * LogIn method search the users database if  the user there.
     * @return true if the user in the users database.
     */
    @Override
    public boolean logIn() {

        for (int i = 0; i < database.getUsers().size(); ++i) {
            User usr = database.getUsers().get(i);
            if (usr instanceof LibraryUser) {
                LibraryUser targetUser = (LibraryUser) usr;
                if (this.equals(targetUser)) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Compare the user's object informations(username and password)
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            LibraryUser LibUsrObj = (LibraryUser) obj;
            return ((this.getUserName().equals(LibUsrObj.getUserName()))
                    && (this.getPassword().equals(LibUsrObj.getPassword())) );

        } else {
            return false;
        }
    }

    /**
     *  Control of book borrowed if not borrowed user can borrow the book
     * @param theBook the book whic user will borrow
     * @throws Exception exception throws if user try to borrow more than 3 book or  try to borrow the book already borrowed
     */
    public void borrowBook(Book theBook) throws Exception {

        /**
         * //An user can borrow maximum  3 books
         */
        if (getCountOfBorrowed() < 3) {
            if (theBook.getWhoBorrowed() == -1) //if book not borrow yet
            {
                theBook.setWhoBorrowed(this.getUserID());
                increaseCountOfBorrowed();
            } else {
                throw new Exception("This book has already borrowed by you!");
            }
        } else {
            throw new Exception("You borrowed 3 books.\nYou can't borrow more than 3 books.\n If you return the books you taked, then you borrow again.\n");
        }
    }

    /**
     * User can return the book if borrowed it.
     * @param theBook the book which user will return it
     * @throws Exception throws exception  if user borrowed any book , or try to return the book which have not borrowed yet.
     */
    public void returnBook(Book theBook) throws Exception {

        if (getCountOfBorrowed() > 0) { // if user borrowed book at least one
            if (theBook.getWhoBorrowed() == getUserID()) //controls of if user really borrowed this book
            {
                theBook.setWhoBorrowed(-1); // Status of books changed , it shows on shelf now
                decreaseCountOfBorrowed();
            } else {
                throw new Exception("Invalid return operation!");
            }
        } else {
            throw new Exception("Invalid return operation!");
        }
    }

    /**
     *  Library user can access lists of borrowed books.
     */
    public void listMyBorrowed() {
        if (getCountOfBorrowed() > 0) {
            System.out.printf("You borrowed %d book", getCountOfBorrowed());
            if (getCountOfBorrowed() > 1) {
                System.out.print("s ");
            }
            System.out.println(":");
            for (int i = 0; i < database.getBooks().size(); ++i) {
                if (database.getBooks().get(i).getWhoBorrowed() == getUserID()) {
                    System.out.println(database.getBooks().get(i).toString());
                }
            }
        } else {
            System.out.println("You have not borrow book!");
        }
    }


    private void increaseCountOfBorrowed() {
        int newCount = getCountOfBorrowed() + 1;
        setCountOfBorrowed(newCount);
    }

    private void decreaseCountOfBorrowed() {
        int newCount = getCountOfBorrowed() - 1;
        setCountOfBorrowed(newCount);
    }

    private static void increaseCountUsers() {
        countOfUsers += 1;
    }

    /**
     *
     * @return string of user's information formatted csv(comma seperated)
     */
    String toCsvFormat() {
        String result = String.format(getUserID() + "," + getUserName() + "," + getPassword() + "," + getCountOfBorrowed() + "\n");
        return result;
    }

}
