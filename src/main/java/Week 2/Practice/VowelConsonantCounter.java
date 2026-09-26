import java.util.Scanner;

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            throw new NullPointerException("Input text cannot be null.");
        }

        int vowelsCount = 0;
        int consonantsCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isLetter(currentChar)) {
                char lowerChar = Character.toLowerCase(currentChar);
                if (lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u') {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d\n", vowelsCount, consonantsCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter text: ");
            String inputText = scanner.nextLine();

            countVowelsAndConsonants(inputText);

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}