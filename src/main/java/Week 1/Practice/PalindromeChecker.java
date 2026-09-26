import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return checkRecursive(text.toLowerCase(), 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return checkRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toLowerCase().toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter text to check for palindrome: ");
            String inputText = scanner.nextLine();

            if (inputText.trim().isEmpty()) {
                throw new IllegalArgumentException("Input string cannot be empty.");
            }

            boolean resIterative = isPalindromeIterative(inputText);
            boolean resRecursive = isPalindromeRecursive(inputText);
            boolean resArrayRev = isPalindromeArrayReversal(inputText);

            System.out.println("\nResults for input: \"" + inputText + "\"");
            System.out.println("Iterative Check: " + (resIterative ? "Palindrome" : "Not Palindrome"));
            System.out.println("Recursive Check: " + (resRecursive ? "Palindrome" : "Not Palindrome"));
            System.out.println("Array Reversal Check: " + (resArrayRev ? "Palindrome" : "Not Palindrome"));

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}