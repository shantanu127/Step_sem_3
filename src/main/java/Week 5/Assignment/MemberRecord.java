import java.util.Arrays;

// Base Immutable Class
public class MemberRecord {

    private final String memberId;
    private final String[] borrowedBookIsbns;

    public MemberRecord(String memberId, String[] borrowedBookIsbns) {
        this.memberId = memberId;
        // Defensive copy on input
        this.borrowedBookIsbns = (borrowedBookIsbns != null) 
            ? Arrays.copyOf(borrowedBookIsbns, borrowedBookIsbns.length) 
            : new String[0];
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBorrowedBookIsbns() {
        // Defensive copy on output
        return Arrays.copyOf(borrowedBookIsbns, borrowedBookIsbns.length);
    }

    // Wither pattern for updating book record while maintaining immutability
    public MemberRecord withUpdatedIsbn(int index, String newIsbn) {
        if (index < 0 || index >= borrowedBookIsbns.length) {
            throw new IndexOutOfBoundsException("Invalid ISBN array index.");
        }
        String[] updatedIsbns = getBorrowedBookIsbns();
        updatedIsbns[index] = newIsbn;
        return new MemberRecord(this.memberId, updatedIsbns);
    }

    // Polymorphic batch processing for nightly audit logs
    public static String processNightlyAudit(MemberRecord[] records) {
        if (records == null) {
            return "0 processed | 0 null skipped | 0 premium | 0 regular";
        }

        int processedCount = 0;
        int nullCount = 0;
        int premiumCount = 0;
        int regularCount = 0;

        for (MemberRecord record : records) {
            if (record == null) {
                nullCount++;
                continue;
            }

            processedCount++;

            if (record instanceof PremiumMemberRecord) {
                premiumCount++;
            } else {
                regularCount++;
            }
        }

        return String.format("%d processed | %d null skipped | %d premium | %d regular",
                processedCount, nullCount, premiumCount, regularCount);
    }
}

// Derived Immutable Subclass for Premium Members
class PremiumMemberRecord extends MemberRecord {

    private final double discountRate;

    public PremiumMemberRecord(String memberId, String[] borrowedBookIsbns, double discountRate) {
        super(memberId, borrowedBookIsbns);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}