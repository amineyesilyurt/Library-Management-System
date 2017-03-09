package edu.gtu.amine;

/**
 * @author Amine
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LibraryStaff admin = new LibraryStaff("amine", "1234");

        LibraryUser nisa = new LibraryUser("Nisa", "nisa7477");
        LibraryUser ali = new LibraryUser("Ali", "ali_25");
        LibraryUser hasan = new LibraryUser("Hasan", "hasan_33");
        LibraryUser faruk = new LibraryUser("Faruk", "frk99");
        LibraryUser ayse = new LibraryUser("Ayse", "Ayse_22");
        LibraryUser fatma = new LibraryUser("Fatma", "1992_fatma");
        LibraryUser simge = new LibraryUser("Simge", "simge12");
        LibraryUser ece = new LibraryUser("Ece", "Ece123");

        Book b1 = new Book("Suc ve Ceza", "Dostoyevski", -1);
        Book b2 = new Book("Yaprak Dokumu", "Resat Nuri Guntekin", -1);
        Book b3 = new Book("Golgenin Pesinde", "Georges Ifrah", -1);
        Book b4 = new Book("Matematik Sanatı", "Jerry P. King", -1);
        Book b5 = new Book("Ince Mehmet", "Yasar Kemal", -1);
        Book b6 = new Book("Tutunamayanlar", "Oguz Atay", -1);
        Book b7 = new Book("Saatleri Ayarlama Enstitusu", "Ahmet Hamdi Tanpinar", -1);
        Book b8 = new Book("Anayurt Oteli", "Yusuf Atilgan", -1);
        Book b9 = new Book("Huzur", "Ahmet Hamdi Tanpinar", -1);
        Book b10 = new Book("Aylak Adam", "Yusuf Atilgan", -1);

        //admin register all users and add all books
        if (admin.logIn()) {
            admin.RegisterUser(nisa);
            admin.RegisterUser(ali);
            admin.RegisterUser(hasan);
            admin.RegisterUser(ayse);
            admin.RegisterUser(fatma);
            admin.RegisterUser(simge);
            admin.RegisterUser(ece);
            admin.RegisterUser(faruk);

            admin.addBook(b1);
            admin.addBook(b2);
            admin.addBook(b3);
            admin.addBook(b4);
            admin.addBook(b5);
            admin.addBook(b6);
            admin.addBook(b7);
            admin.addBook(b8);
            admin.addBook(b9);
            admin.addBook(b10);

        }
        System.out.print("\n************************METHOD listAllBooks*********************\n");
        admin.listAllBooks();
        System.out.print("\n************************END OF METHOD listAllBooks**************\n");


        System.out.print("\n************************METHOD listBooksOnShelf*********************\n");
        admin.listBooksOnShelf();
        System.out.print("\n************************END OF METHOD listBooksOnShelf**************\n");

        if (faruk.logIn()) {
            try {
                faruk.borrowBook(b1);
                faruk.borrowBook(b2);
                faruk.borrowBook(b3);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
            faruk.displayMyProfile();

        }

        //controls logIn  method
        if (ece.logIn()) {
            try {
                ece.borrowBook(b4);
                ece.borrowBook(b5);
                ece.borrowBook(b6);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
            ece.displayMyProfile();

        }


        System.out.print("\n************************METHOD listBooksOnShelf*********************\n");
        admin.listBooksOnShelf();
        System.out.print("\n************************END OF METHOD listBooksOnShelf**************\n");

        System.out.print("\n After Faruk returns 3 books his profile and books on the shelf\n");

        try {
            faruk.returnBook(b1);;
            faruk.returnBook(b2);
            faruk.returnBook(b3);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        faruk.displayMyProfile();
        faruk.listBooksOnShelf();

        System.out.print("\nAfter admin remove book7 and book8 from databese ...\n\n");
        admin.removeBook(b7);
        admin.removeBook(b8);

        admin.displayAllUserOnDatabase();
        admin.listAllBooks();

        CsvOperation creatinCsv= new CsvOperation();
        creatinCsv.createFiles();

    }
}