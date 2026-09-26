abstract class PaymentProcessor {
    public abstract boolean validate(double amount);
    public abstract boolean process(double amount);

    // Template method defining execution flow
    public String executeTransaction(double amount) {
        if (!validate(amount)) {
            return "Transaction Rejected: Invalid Amount";
        }
        if (process(amount)) {
            return "Transaction Successful: Rs " + amount;
        }
        return "Transaction Failed";
    }
}

class CreditCardProcessor extends PaymentProcessor {
    private double creditLimit;

    public CreditCardProcessor(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && amount <= creditLimit;
    }

    @Override
    public boolean process(double amount) {
        if (validate(amount)) {
            creditLimit -= amount;
            return true;
        }
        return false;
    }
}

class UpiProcessor extends PaymentProcessor {
    private double dailyLimit = 100000.0;

    @Override
    public boolean validate(double amount) {
        return amount > 0 && amount <= dailyLimit;
    }

    @Override
    public boolean process(double amount) {
        if (validate(amount)) {
            dailyLimit -= amount;
            return true;
        }
        return false;
    }
}