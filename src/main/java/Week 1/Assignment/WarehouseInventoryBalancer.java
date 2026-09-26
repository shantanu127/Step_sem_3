import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            throw new NullPointerException("Inventory section arrays cannot be null.");
        }

        if (sectionA.length != sectionB.length) {
            throw new IllegalArgumentException("Section A and Section B must have equal item counts.");
        }

        if (sectionA.length == 0) {
            throw new IllegalArgumentException("Inventory sections cannot be empty.");
        }

        int totalA = 0;
        int totalB = 0;

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestItemIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1;
            }

            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter number of item categories: ");
            int itemCategoryCount = scanner.nextInt();

            if (itemCategoryCount <= 0) {
                throw new IllegalArgumentException("Item category count must be greater than zero.");
            }

            int[] sectionA = new int[itemCategoryCount];
            int[] sectionB = new int[itemCategoryCount];

            System.out.println("Enter quantities for Section A:");
            for (int i = 0; i < itemCategoryCount; i++) {
                sectionA[i] = scanner.nextInt();
            }

            System.out.println("Enter quantities for Section B:");
            for (int i = 0; i < itemCategoryCount; i++) {
                sectionB[i] = scanner.nextInt();
            }

            analyzeInventory(sectionA, sectionB);

        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}