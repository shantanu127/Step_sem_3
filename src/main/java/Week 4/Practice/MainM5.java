class FeeAccount {
    public void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    public void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

class PaymentProcessor {
    public void processPayment(FeeAccount account, double amount, int[] counters) {
        account.pay(amount);

        // Using instanceof for type checking and incrementing counters
        if (account instanceof HostelFeeAccount) {
            counters[0]++; // Hostel accounts counter
        } else if (account instanceof FeeAccount) {
            counters[1]++; // Day-scholar accounts counter
        }
    }
}

public class MainM5 {
    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        double amount = 60000;
        int[] counters = new int[2]; // counters[0] = hostel, counters[1] = day-scholar
        PaymentProcessor processor = new PaymentProcessor();

        for (FeeAccount account : accounts) {
            processor.processPayment(account, amount, counters);
        }

        System.out.println("Hostel accounts processed: " + counters[0] + 
                           " | Day-scholar accounts processed: " + counters[1]);
    }
}