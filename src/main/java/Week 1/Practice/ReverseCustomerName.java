import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            throw new NullPointerException("Customer name cannot be null.");
        }

        char[] originalChars = customerName.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        return new String(reversedChars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Customer name cannot be empty.");
            }

            String reversedName = reverseCustomerName(name);

            System.out.println("Original Name: " + name);
            System.out.println("Reversed Name: " + reversedName);

        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}