import java.util.Scanner;

public class MovieReviewWordProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie review text cannot be null or empty.");
        }

        // Split words by one or more whitespace characters
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;   // 1 to 4 letters
        int mediumCount = 0;  // 5 to 8 letters
        int longCount = 0;    // 9+ letters

        for (String word : words) {
            // Remove non-alphanumeric punctuation (e.g., quotes, commas, periods) to count pure letter length
            String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "");
            int length = cleanedWord.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter movie review: ");
            String review = scanner.nextLine();

            classifyWordLengths(review);

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}