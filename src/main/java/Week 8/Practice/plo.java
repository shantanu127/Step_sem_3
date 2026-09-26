import java.util.ArrayList;
import java.util.List;

abstract class Room {
    private final String roomNumber;
    private final double basePrice;

    public Room(String roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double calculateCost(int nights);
}

class StandardRoom extends Room {
    public StandardRoom(String roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculateCost(int nights) {
        return getBasePrice() * nights;
    }
}

class DeluxeRoom extends Room {
    private final double luxuryTaxRate = 0.15; // 15% luxury tax

    public DeluxeRoom(String roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculateCost(int nights) {
        double base = getBasePrice() * nights;
        return base + (base * luxuryTaxRate);
    }
}

class SuiteRoom extends Room {
    private final double serviceCharge = 100.0;

    public SuiteRoom(String roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculateCost(int nights) {
        return (getBasePrice() * nights) + serviceCharge;
    }
}

interface AddOnService {
    double getCost();
    String getDescription();
}

class BreakfastService implements AddOnService {
    @Override
    public double getCost() {
        return 20.0;
    }

    @Override
    public String getDescription() {
        return "Breakfast";
    }
}

class SpaService implements AddOnService {
    @Override
    public double getCost() {
        return 50.0;
    }

    @Override
    public String getDescription() {
        return "Spa Access";
    }
}

class HotelBooking {
    private final Room room;
    private final int nights;
    private final List<AddOnService> addOns;

    public HotelBooking(Room room, int nights) {
        this.room = room;
        this.nights = nights;
        this.addOns = new ArrayList<>();
    }

    public void addService(AddOnService service) {
        addOns.add(service);
    }

    public double calculateTotalBill() {
        double roomCost = room.calculateCost(nights);
        double addOnCost = 0;
        for (AddOnService service : addOns) {
            addOnCost += service.getCost();
        }
        return roomCost + addOnCost;
    }
}