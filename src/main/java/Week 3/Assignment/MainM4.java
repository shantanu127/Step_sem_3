class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class MainM4 {
    public static void main(String[] args) {
        // Create initial object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Reference copy
        HallTicket copy = priya;

        // Modify state via the second variable
        copy.seatNumber = 45;

        // Create a separate object with identical values
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}