import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        Map<Character, Integer> charFrequencyMap = new LinkedHashMap<>();

        // Count character frequency
        for (char c : text.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        // Scan original string to find first character with frequency 1
        for (char c : text.toCharArray()) {
            if (charFrequencyMap.get(c) == 1) {
                return c;
            }
        }

        // Return null character indicator if no non-repeating character found
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            char result = findFirstNonRepeatingChar(text);

            if (result != '\0') {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}