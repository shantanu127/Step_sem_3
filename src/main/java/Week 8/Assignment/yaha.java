class Wallet {
    private double balance;

    public Wallet(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up amount must be positive.");
            return;
        }
        this.balance += amount;
        System.out.printf("Recharged ₹%.2f. New Balance: ₹%.2f.%n", amount, balance);
    }

    public boolean deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduction amount must be positive.");
            return false;
        }
        if (balance < amount) {
            System.out.printf("Transaction failed: Insufficient balance (Available: ₹%.2f, Required: ₹%.2f).%n", balance, amount);
            return false;
        }
        this.balance -= amount;
        return true;
    }
}

class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private final Item item;
    private final int quantity;

    public Order(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return item.getPrice() * quantity;
    }

    public boolean processPayment(Wallet wallet) {
        double total = calculateTotal();
        if (wallet.deduct(total)) {
            System.out.printf("Purchased %dx %s. Charged: ₹%.2f. Remaining Balance: ₹%.2f.%n",
                    quantity, item.getName(), total, wallet.getBalance());
            return true;
        }
        return false;
    }
}