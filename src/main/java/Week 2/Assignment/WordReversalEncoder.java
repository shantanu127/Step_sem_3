import java.util.Scanner;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Sentence cannot be null.");
        }

        if (sentence.trim().isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            resultBuilder.append(wordBuilder.reverse());

            if (i < words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter sentence: ");
            String inputSentence = scanner.nextLine();

            String reversedSentence = reverseEachWord(inputSentence);
            System.out.println(reversedSentence);

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}