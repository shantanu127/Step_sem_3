import java.util.Scanner;

public class ExamSeatChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            throw new IllegalArgumentException("Seat numbers array cannot be null or empty.");
        }

        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter total number of seats: ");
            int totalSeats = scanner.nextInt();

            if (totalSeats <= 0) {
                throw new IllegalArgumentException("Number of seats must be greater than zero.");
            }

            int[] seatNumbers = new int[totalSeats];
            System.out.println("Enter " + totalSeats + " seat numbers:");
            for (int i = 0; i < totalSeats; i++) {
                seatNumbers[i] = scanner.nextInt();
            }

            checkDuplicateSeats(seatNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred during execution: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}