import java.util.Scanner;

public class CsvStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", name, rollNumber, department);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter CSV Record: ");
            String csvInput = scanner.nextLine();

            parseStudentRecord(csvInput);

        } catch (Exception e) {
            System.out.println("An error occurred during parsing: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}