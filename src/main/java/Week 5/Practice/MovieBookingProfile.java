public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // Public no-argument constructor
    public MovieBookingProfile() {
    }

    // Convenience constructor chaining to no-arg constructor via this()
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // JavaBean Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Write-only OTP property (no getter exists)
    public void setOtp(String otp) {
        if (otp != null && otp.matches("\\d{4,6}")) {
            this.otp = otp;
        } else {
            throw new IllegalArgumentException("OTP must be a 4-6 digit numeric string.");
        }
    }
}