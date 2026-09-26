class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class MainM4 {
    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        
        // Assigning second variable to point to the exact same object
        IdCard duplicate = ravi;
        
        // Modify state via the second variable
        duplicate.booksIssued = 3;

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Separate object with identical contents
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}