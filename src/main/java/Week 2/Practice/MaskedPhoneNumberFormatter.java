import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null) {
            throw new NullPointerException("Phone number cannot be null.");
        }

        String trimmedPhone = phone.trim();

        // Validate that phone number length is exactly 10 and all characters are digits
        if (trimmedPhone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < trimmedPhone.length(); i++) {
            if (!Character.isDigit(trimmedPhone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String last4Digits = trimmedPhone.substring(6);
        StringBuilder maskedBuilder = new StringBuilder("XXXXXX");
        maskedBuilder.append("-").append(last4Digits);

        return maskedBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            String result = maskPhoneNumber(phoneNumber);
            System.out.println(result);

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}