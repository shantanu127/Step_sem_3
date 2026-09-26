class Item {
    private String itemName;
    private int stock;

    public Item(String itemName, int stock) {
        // Resolving field/parameter name clash
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        // Resolving field/parameter name clash
        this.stock += stock;
    }

    public void printSummary() {
        System.out.println(itemName + " | Final Stock: " + stock);
    }
}

public class MainA2 {
    public static void main(String[] args) {
        Item[] items = {
            new Item("Samosa", 15),
            new Item("Tea Powder", 40),
            new Item("Bread", 8),
            new Item("Biscuit Packs", 25)
        };

        int restockAmount = 20;

        for (Item item : items) {
            item.restock(restockAmount);
            item.printSummary();
        }
    }
}