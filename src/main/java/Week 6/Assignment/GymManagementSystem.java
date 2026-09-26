public class GymManagementSystem {

    private static int membersEnrolled = 0;

    private final String membershipNumber;
    private int monthlyFee;
    private int feesPaid;

    public GymManagementSystem(int monthlyFee) {
        membersEnrolled++;
        this.membershipNumber = "GYM-" + (2000 + membersEnrolled);
        this.monthlyFee = monthlyFee;
        this.feesPaid = 0;
    }

    public String getMembershipNumber() {
        return membershipNumber;
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

    // Two-argument overload delegating to flat-amount version
    public void payFee(int amount, String mode) {
        // Mode could be recorded/logged if needed
        payFee(amount);
    }

    public static boolean isValidReferralCode(String code) {
        // Check format "G" + 2 digits + 1 uppercase letter without Regex
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        if (members == null) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        int processedCount = 0;
        int nullCount = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (GymMember member : members) {
            if (member == null) {
                nullCount++;
                continue;
            }

            processedCount++;

            if (member instanceof GroupClassMember) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        return String.format("%d processed | %d null skipped | %d group | %d individual",
                processedCount, nullCount, groupCount, individualCount);
    }
}