public class LibraryManagementSystem {

    private static int membersEnrolled = 0;

    private final String barcodeNumber;
    private int annualFee;
    private int feesPaid;

    public LibraryManagementSystem(int annualFee) {
        membersEnrolled++;
        this.barcodeNumber = "LIB-" + (1000 + membersEnrolled);
        this.annualFee = annualFee;
        this.feesPaid = 0;
    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    // Single-argument overload
    public void payFee(int amount) {
        if (amount > 0) {
            this.feesPaid += amount;
        }
    }

    // Two-argument overload delegating to single-arg version
    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public static boolean isValidBarcodeFormat(String code) {
        // Validates format: "L" + 2 digits + 1 uppercase letter without Regex
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'L' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));
    }

    public static String processWeeklySettlement(LibraryMember[] members) {
        if (members == null) {
            return "0 processed | 0 null skipped | 0 faculty | 0 student/general";
        }

        int processedCount = 0;
        int nullCount = 0;
        int facultyCount = 0;
        int studentOrGeneralCount = 0;

        for (LibraryMember member : members) {
            if (member == null) {
                nullCount++;
                continue;
            }

            processedCount++;

            if (member instanceof FacultyMember) {
                facultyCount++;
            } else {
                studentOrGeneralCount++;
            }
        }

        return String.format("%d processed | %d null skipped | %d faculty | %d student/general",
                processedCount, nullCount, facultyCount, studentOrGeneralCount);
    }
}