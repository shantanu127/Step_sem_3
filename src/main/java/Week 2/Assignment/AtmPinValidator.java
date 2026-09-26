import java.util.Scanner;

public class AtmPinValidator {

    public static void checkPinLength(String pin) {
        if (pin == null) {
            throw new NullPointerException("PIN input cannot be null.");
        }

        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            String inputPin = scanner.nextLine();

            checkPinLength(inputPin);

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}