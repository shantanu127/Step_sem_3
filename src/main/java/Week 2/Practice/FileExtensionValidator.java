import java.util.Scanner;

public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty.");
        }

        int lastDotIndex = filename.lastIndexOf('.');

        // Check if '.' exists and is not at the end of the filename
        if (lastDotIndex != -1 && lastDotIndex < filename.length() - 1) {
            String extension = filename.substring(lastDotIndex + 1);

            if (extension.equalsIgnoreCase("pdf") || 
                extension.equalsIgnoreCase("docx") || 
                extension.equalsIgnoreCase("zip")) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();

            String status = validateFileExtension(filename);
            System.out.println(status);

        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}