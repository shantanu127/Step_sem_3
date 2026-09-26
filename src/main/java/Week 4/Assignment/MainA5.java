class CanteenPayment {
    public void processPayment(double amount) {
        System.out.println("Processing standard canteen payment of Rs " + amount);
    }
}

class DigitalWalletPayment extends CanteenPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing digital wallet payment of Rs " + amount);
    }
}

class CashPayment Processor {
    public void process(CanteenPayment payment, double amount, int[] counts) {
        payment.processPayment(amount);

        // Using instanceof for type checking
        if (payment instanceof DigitalWalletPayment) {
            counts[0]++; // Wallet payments counter
        } else if (payment instanceof CanteenPayment) {
            counts[1]++; // Cash/Standard payments counter
        }
    }
}

public class MainA5 {
    public static void main(String[] args) {
        CanteenPayment[] payments = {
            new DigitalWalletPayment(),
            new CanteenPayment(),
            new DigitalWalletPayment(),
            new CanteenPayment()
        };

        double amount = 150.0;
        int[] counts = new int[2]; // counts[0] = wallet, counts[1] = cash/standard
        CashPaymentProcessor processor = new CashPaymentProcessor();

        for (CanteenPayment payment : payments) {
            processor.process(payment, amount, counts);
        }

        System.out.println("Digital Wallet Payments: " + counts[0] + " | Standard/Cash Payments: " + counts[1]);
    }
}