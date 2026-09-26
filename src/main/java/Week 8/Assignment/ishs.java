import java.util.Objects;

abstract class Bike {
    private final String bikeId;
    private boolean isRented;

    public Bike(String bikeId) {
        this.bikeId = Objects.requireNonNull(bikeId, "Bike ID cannot be null");
        this.isRented = false;
    }

    public String getBikeId() {
        return bikeId;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public abstract double calculateFare(int durationMinutes);
    public abstract String getBikeType();
}

class StandardBike extends Bike {
    public StandardBike(String bikeId) {
        super(bikeId);
    }

    @Override
    public double calculateFare(int durationMinutes) {
        return (durationMinutes / 30.0) * 10.0; // ₹10 per 30 mins
    }

    @Override
    public String getBikeType() {
        return "Standard Bike";
    }
}

class ElectricBike extends Bike {
    private int batteryLevel;

    public ElectricBike(String bikeId, int batteryLevel) {
        super(bikeId);
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public double calculateFare(int durationMinutes) {
        return (durationMinutes / 30.0) * 20.0; // ₹20 per 30 mins
    }

    @Override
    public String getBikeType() {
        return "Electric Bike";
    }
}

class User {
    private final String userId;

    public User(String userId) {
        this.userId = Objects.requireNonNull(userId, "User ID cannot be null");
    }

    public String getUserId() {
        return userId;
    }
}

class RentalSession {
    private final User user;
    private final Bike bike;

    public RentalSession(User user, Bike bike) {
        this.user = user;
        this.bike = bike;
    }

    public boolean startRental() {
        if (bike instanceof ElectricBike) {
            ElectricBike eBike = (ElectricBike) bike;
            if (eBike.getBatteryLevel() < 20) {
                System.out.println("Cannot rent " + bike.getBikeId() + ": Low battery (" + eBike.getBatteryLevel() + "%).");
                return false;
            }
        }
        if (bike.isRented()) {
            System.out.println("Bike " + bike.getBikeId() + " is already rented.");
            return false;
        }

        bike.setRented(true);
        System.out.println("Rental started: " + bike.getBikeType() + " " + bike.getBikeId() + " for " + user.getUserId() + ".");
        return true;
    }

    public void endRental(int durationMinutes) {
        if (!bike.isRented()) {
            System.out.println("Bike " + bike.getBikeId() + " was not rented.");
            return;
        }
        bike.setRented(false);
        double fare = bike.calculateFare(durationMinutes);
        System.out.printf("Rental ended for %s (%s). Duration: %d min. Fare: ₹%.2f.%n",
                bike.getBikeId(), user.getUserId(), durationMinutes, fare);
    }
}