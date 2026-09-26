import java.util.Arrays;

class GymMember {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;
    private int[] lateFeeHistory;
    private int lateFeeCount;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Member ID cannot be blank, whitespace-only, or shorter than 4 characters.");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
        this.lateFeeHistory = new int[10];
        this.lateFeeCount = 0;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return this.sessionsAttended;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    protected void chargeLateFee(int amount) {
        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        // Halves the late fee and reuses parent logic
        super.chargeLateFee(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
    }
}