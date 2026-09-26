interface Inspectable {
    String runDiagnostics();
}

abstract class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Inspectable {
    private static final double DAILY_RATE = 1500.0;

    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * DAILY_RATE;
    }

    @Override
    public String runDiagnostics() {
        return "Car [" + getLicensePlate() + "]: Engine OK, Brakes OK";
    }
}

class ElectricScooter extends Vehicle implements Inspectable {
    private static final double DAILY_RATE = 400.0;

    public ElectricScooter(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * DAILY_RATE;
    }

    @Override
    public String runDiagnostics() {
        return "Scooter [" + getLicensePlate() + "]: Battery Health 98%, Brakes OK";
    }
}