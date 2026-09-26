import java.util.Arrays;

// Base Immutable Class
public final class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        // Defensive copy in
        this.seatNumbers = (seatNumbers != null) ? Arrays.copyOf(seatNumbers, seatNumbers.length) : new String[0];
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        // Defensive copy out
        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    // Wither pattern: returns a new immutable instance with updated seat
    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (index < 0 || index >= seatNumbers.length) {
            throw new IndexOutOfBoundsException("Invalid seat index.");
        }
        String[] updatedSeats = getSeatNumbers();
        updatedSeats[index] = newSeat;
        return new BookingReceipt(this.bookingId, updatedSeats);
    }

    // Nightly Settlement Processor
    public static String processNightlySettlement(BookingReceipt[] receipts) {
        if (receipts == null) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        int processedCount = 0;
        int nullCount = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (BookingReceipt receipt : receipts) {
            if (receipt == null) {
                nullCount++;
                continue;
            }

            processedCount++;

            if (receipt instanceof GroupBookingReceipt) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        return String.format("%d processed | %d null skipped | %d group | %d individual",
                processedCount, nullCount, groupCount, individualCount);
    }
}

// Subclass / Variant for Group Bookings
class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}