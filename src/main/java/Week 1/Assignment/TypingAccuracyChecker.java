import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            throw new NullPointerException("Original and typed texts cannot be null.");
        }

        if (original.length() != typed.length()) {
            throw new IllegalArgumentException("Original and typed texts must be of equal length.");
        }

        int matchedCount = 0;
        int firstMismatchPos = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCount++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based position indexing
            }
        }

        double accuracy = ((double) matchedCount / original.length()) * 100;

        String resultMessage = String.format("Matched: %d/%d | Accuracy: %.2f%%", 
                matchedCount, original.length(), accuracy);

        if (firstMismatchPos != -1) {
            resultMessage += String.format(" | First Mismatch at position %d ('%c' vs '%c')", 
                    firstMismatchPos, original.charAt(firstMismatchPos - 1), typed.charAt(firstMismatchPos - 1));
        } else {
            resultMessage += " | No Mismatches";
        }

        System.out.println(resultMessage);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter original text: ");
            String originalText = scanner.nextLine();

            System.out.print("Enter typed text: ");
            String typedText = scanner.nextLine();

            checkTypingAccuracy(originalText, typedText);

        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}