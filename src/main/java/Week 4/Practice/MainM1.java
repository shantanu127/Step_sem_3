class LibraryBook {
    private String title;
    private String isbn;
    private boolean catalogued;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        if (isbn == null || isbn.trim().isEmpty()) {
            this.isbn = "PENDING";
        } else {
            this.isbn = isbn;
        }
        this.catalogued = true;
    }

    // Constructor chaining via this(...)
    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public void printStatus() {
        System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
    }
}

public class MainM1 {
    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            LibraryBook book;
            if (isbns[i] == null || isbns[i].trim().isEmpty()) {
                book = new LibraryBook(titles[i]);
            } else {
                book = new LibraryBook(titles[i], isbns[i]);
            }
            book.printStatus();
        }
    }
}