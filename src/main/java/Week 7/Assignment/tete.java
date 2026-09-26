abstract class PaymentMethod {
    private String accountHolder;

    public PaymentMethod(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public abstract boolean processPayment(double amount);
}

interface Refundable {
    boolean refund(double amount);
}

class CreditCard extends PaymentMethod implements Refundable {
    private double creditLimit;

    public CreditCard(String accountHolder, double creditLimit) {
        super(accountHolder);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount > 0 && amount <= creditLimit) {
            creditLimit -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean refund(double amount) {
        if (amount > 0) {
            creditLimit += amount;
            return true;
        }
        return false;
    }
}

class CryptoWallet extends PaymentMethod {
    private double balance;

    public CryptoWallet(String accountHolder, double balance) {
        super(accountHolder);
        this.balance = balance;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}