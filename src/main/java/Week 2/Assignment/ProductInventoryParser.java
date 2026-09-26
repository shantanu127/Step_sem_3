import java.util.Scanner;

public class ProductInventoryParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.printf("Product: %s | SKU: %s | Qty: %s\n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter CSV line: ");
            String csvInput = scanner.nextLine();

            parseInventoryRecord(csvInput);

        } catch (Exception e) {
            System.out.println("An error occurred during parsing: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}