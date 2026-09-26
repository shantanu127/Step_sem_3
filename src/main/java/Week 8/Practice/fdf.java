import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private final String itemId;
    private final String name;
    private final double price;

    public MenuItem(String itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

abstract class DiscountStrategy {
    public abstract double applyDiscount(double subtotal);
}

class PercentageDiscount extends DiscountStrategy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double subtotal) {
        return subtotal * (1 - percentage / 100.0);
    }
}

class FlatDiscount extends DiscountStrategy {
    private final double amount;

    public FlatDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double subtotal) {
        return Math.max(0, subtotal - amount);
    }
}

class NoDiscount extends DiscountStrategy {
    @Override
    public double applyDiscount(double subtotal) {
        return subtotal;
    }
}

enum OrderStatus {
    PLACED, PREPARING, OUT_FOR_DELIVERY, DELIVERED, CANCELLED
}

class Order {
    private final String orderId;
    private final List<MenuItem> items;
    private OrderStatus status;
    private DiscountStrategy discountStrategy;

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PLACED;
        this.discountStrategy = new NoDiscount();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        return discountStrategy.applyDiscount(subtotal);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        System.out.println("Order " + orderId + " status updated to: " + newStatus);
    }
}