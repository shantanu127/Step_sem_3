import java.util.Objects;

abstract class Vehicle {
    private final String vehicleId;
    private final String model;
    private boolean isRented;

    public Vehicle(String vehicleId, String model) {
        this.vehicleId = Objects.requireNonNull(vehicleId, "Vehicle ID cannot be null");
        this.model = Objects.requireNonNull(model, "Model cannot be null");
        this.isRented = false;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public abstract double calculateRentalCharge(int days);
    public abstract String getVehicleType();
}

class Sedan extends Vehicle {
    private static final double DAILY_RATE = 50.0;

    public Sedan(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * DAILY_RATE;
    }

    @Override
    public String getVehicleType() {
        return "Sedan";
    }
}

class SUV extends Vehicle {
    private static final double DAILY_RATE = 80.0;

    public SUV(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * DAILY_RATE;
    }

    @Override
    public String getVehicleType() {
        return "SUV";
    }
}

class Truck extends Vehicle {
    private static final double DAILY_RATE = 100.0;

    public Truck(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * DAILY_RATE;
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }
}

class Customer {
    private final String customerId;
    private final String name;

    public Customer(String customerId, String name) {
        this.customerId = Objects.requireNonNull(customerId, "Customer ID cannot be null");
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private final Customer customer;
    private final Vehicle vehicle;

    public Rental(Customer customer, Vehicle vehicle) {
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public boolean processRental(int days) {
        if (vehicle.isRented()) {
            System.out.println(vehicle.getVehicleType() + " " + vehicle.getModel() + " is currently unavailable.");
            return false;
        }

        vehicle.setRented(true);
        double charge = vehicle.calculateRentalCharge(days);
        System.out.printf("%s %s rented successfully by %s. Rental charge: $%.2f.%n",
                vehicle.getVehicleType(), vehicle.getModel(), customer.getName(), charge);
        return true;
    }

    public void returnVehicle() {
        if (!vehicle.isRented()) {
            System.out.println(vehicle.getVehicleType() + " " + vehicle.getModel() + " was not rented.");
            return;
        }

        vehicle.setRented(false);
        System.out.println(vehicle.getVehicleType() + " " + vehicle.getModel() + " returned by " + customer.getName() + ".");
    }
}