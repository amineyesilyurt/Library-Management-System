package edu.gtu.amine;

import java.util.ArrayList;

/**
 *
 * @author Amine
 */
public class Database {

    private ArrayList<User> users = new ArrayList<User>(); //keeps library users  and library staffs
    private ArrayList<Book> books = new ArrayList<Book>();//keeps books
    private static Database dbIsntance;  //databese singleton object

    /**
     * A private Constructor prohibits any other class from instantiating.
     */
    private Database() {
        //Body is intentionally empty
    }

    /**
     * Return instance of database
     *
     * @return dbIsntance instance of database
     */
    public static Database getInstance() {

        if (dbIsntance == null) {
            dbIsntance = new Database();//singleton object as database
        }
        return dbIsntance;
    }

    /**
     *
     * @return users as ArryaList
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     *
     * @return books as ArrayList
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     *
     * @param theUsr the User will added to database
     * @throws Exception if user already in database then throws exception
     */
    public void addUser(User theUsr) throws Exception {
        if (!this.isExistInUsers(theUsr)) {
            users.add(theUsr);
        } else {
            throw new Exception(theUsr + " already exist in database.");
        }
    }

    /**
     *
     * @param theNewBook the book will be added to database
     */
    public void addBook(Book theNewBook) {
        books.add(theNewBook);
    }

    /**
     *
     * @param theNewBook the book which will remove from database
     * @throws Exception exception will throw if book have not returned yet or the book is not in database
     */
    public void removeBook(Book theNewBook) throws Exception {
        for (int i = 0; i < books.size(); ++i) {
            if (theNewBook.equals(books.get(i))) {
                if (books.get(i).getWhoBorrowed() == -1) {
                    books.remove(i);
                    return;
                } else {
                    throw new Exception("You can not remove book before the book is returned.");
                }

            }
        }
        throw new IllegalArgumentException("Can not remove invalid book.");
    }

    /**
     *
     * @param theUser the User which will search database of users
     * @return true if user in database
     */
    private boolean isExistInUsers(User theUser) {

        for (int i = 0; i < Database.getInstance().getUsers().size(); ++i) {
            if (Database.getInstance().getUsers().get(i).equals(theUser)) {
                return true;
            }
        }
        return false;
    }

}
