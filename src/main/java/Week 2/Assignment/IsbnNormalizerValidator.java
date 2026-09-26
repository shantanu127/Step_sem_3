import java.util.Scanner;

public class IsbnNormalizerValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            throw new NullPointerException("Raw code cannot be null.");
        }

        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed;
        }

        String prefix = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);

        return prefix + remainder;
    }

    public static String validateAndFormat(String code) {
        if (code == null) {
            throw new NullPointerException("Code cannot be null.");
        }

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder formattedLine = new StringBuilder();
        formattedLine.append("[").append(pubCode).append("] ")
                     .append("YEAR: ").append(year)
                     .append(" | CATALOG: ").append(catalog);

        return formattedLine.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter ISBN code: ");
            String rawCode = scanner.nextLine();

            String normalizedCode = normalizeCode(rawCode);
            String result = validateAndFormat(normalizedCode);

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