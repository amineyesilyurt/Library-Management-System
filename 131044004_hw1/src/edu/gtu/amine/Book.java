package edu.gtu.amine;

/**
 *
 * @author Amine
 */
public class Book {

    private String name; //name of the book
    private String author; //author of the book
    private int bookID; //there might be one more than same book in the library so we need unique ID
    private int whoBorrowed; //bocomes -1 if anyone borrow otherwise userID who borrowed the book assigns
    private static int countOfBooks = 0; //total books count

    /**
     *
     * @return name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the book
     * @param name the name of thebook
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set autor of the book
     * @param author autor of the book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return user of ID who borrowed the book or return -1 if anybody borrowed the book
     */
    public int getWhoBorrowed() {
        return whoBorrowed;
    }

    /**
     *
     * @param whoBorrowed userID or -1
     */
    public void setWhoBorrowed(int whoBorrowed) {
        this.whoBorrowed = whoBorrowed;
    }

    /**
     *
     * @return countOfBooks  total count of books in the library
     */
    public static int getCountOfBooks() {
        return countOfBooks;
    }

    /**
     *
     * @param countOfBooks total count of book
     */
    public static void setCountOfBooks(int countOfBooks) {
        Book.countOfBooks = countOfBooks;
    }

    /**
     *
     * @return bookID ID of book
     */
    public int getBookID() {
        return bookID;
    }

    /**
     *
     * @param bookID ID of book
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    /**
     * Constructor three parameter
     * @param name name of the book
     * @param author autor of the book
     * @param whoBorrowed -1 or userID
     */
    public Book(String name, String author, int whoBorrowed) {
        this.name = name;
        this.author = author;
        this.whoBorrowed = whoBorrowed;
        increaseCountOfBook();
        this.bookID = getCountOfBooks(); // each book represents unique ID this way
    }

    /**
     *
     * @return String of Book's information
     */
    @Override
    public String toString() {
        String result = "Book{" + "name=" + name + ", author=" + author + ", bookID=" + bookID + ", Status=";
        if (whoBorrowed == -1) //if book on shelf
        {
            result += "On Shelf" + "}";
        } else {
            result += "Borrowed" + "}";
        }
        return result;

    }

    /**
     *
     * @param obj book object will compare
     * @return true if books same else false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.getBookID() == other.getBookID()) {
            return true;
        } else {
            return false;
        }

    }

    private void increaseCountOfBook() {
        countOfBooks += 1;
    }

    /**
     *
     * @return string of book information in the form of csv(comma seperated ) format
     */
    String toCsvFormat() {
        String result = String.format(getBookID() + "," + getName() + "," + getAuthor() + "\n");
        return result;
    }

}
