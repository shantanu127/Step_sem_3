public class ReservationSystem {

    private final int totalCapacity;
    private int availableCopies;

    public ReservationSystem(int totalCapacity) {
        if (totalCapacity <= 0 || totalCapacity > 500) {
            throw new IllegalArgumentException("Total capacity must be positive and up to 500 copies.");
        }
        this.totalCapacity = totalCapacity;
        this.availableCopies = totalCapacity;
    }

    public void reserveCopy() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }

    public void cancelReservation() {
        if (availableCopies < totalCapacity) {
            availableCopies++;
        }
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }
}