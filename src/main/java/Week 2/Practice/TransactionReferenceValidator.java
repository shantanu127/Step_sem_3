import java.util.Scanner;

public class TransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            throw new NullPointerException("Raw reference string cannot be null.");
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null) {
            throw new NullPointerException("Reference cannot be null.");
        }

        // Validate overall length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String dateStr = reference.substring(3, 9);
        String seqNumber = reference.substring(9, 14);

        // Format date from ddMMyy to dd/MM/yy
        String formattedDate = dateStr.substring(0, 2) + "/" + dateStr.substring(2, 4) + "/" + dateStr.substring(4, 6);

        StringBuilder formattedLine = new StringBuilder();
        formattedLine.append("[").append(bankCode).append("] ")
                     .append("DATE: ").append(formattedDate)
                     .append(" | SEQ: ").append(seqNumber);

        return formattedLine.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter reference code: ");
            String rawReference = scanner.nextLine();

            String normalized = normalizeReference(rawReference);
            String output = validateAndFormat(normalized);

            System.out.println(output);

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}