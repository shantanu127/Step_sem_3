interface Inspectable {
    String runDiagnostics();
}

abstract class Vehicle {
    private final String regNo;

    public Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public abstract double calculateRepairCost(int hours);
}

class Car extends Vehicle implements Inspectable {
    private static final double HOURLY_RATE = 500.0;

    public Car(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateRepairCost(int hours) {
        return hours * HOURLY_RATE;
    }

    @Override
    public String runDiagnostics() {
        return "Car [" + getRegNo() + "]: Engine OK, Brakes OK";
    }
}

class ElectricBike extends Vehicle implements Inspectable {
    private static final double HOURLY_RATE = 300.0;

    public ElectricBike(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateRepairCost(int hours) {
        return hours * HOURLY_RATE;
    }

    @Override
    public String runDiagnostics() {
        return "Electric Bike [" + getRegNo() + "]: Battery Health 95%, Motor OK";
    }
}

public class WorkshopManager {

    public static String processWorkshopBatch(Vehicle[] vehicles, int[] repairHours) {
        if (vehicles == null || repairHours == null) {
            return "0 processed | 0 null skipped | Total Repair Cost: Rs 0.00";
        }

        int processedCount = 0;
        int nullCount = 0;
        double totalCost = 0.0;

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                nullCount++;
                continue;
            }

            processedCount++;
            int hours = (i < repairHours.length) ? repairHours[i] : 0;
            totalCost += vehicles[i].calculateRepairCost(hours);
        }

        return String.format("%d processed | %d null skipped | Total Repair Cost: Rs %.2f",
                processedCount, nullCount, totalCost);
    }
}