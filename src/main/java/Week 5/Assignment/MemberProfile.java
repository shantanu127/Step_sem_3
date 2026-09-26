public class MemberProfile {

    private String memberName;
    private boolean activeStatus;
    private String verificationPin;

    // Public no-argument constructor
    public MemberProfile() {
    }

    // Convenience constructor
    public MemberProfile(String memberName) {
        this();
        this.memberName = memberName;
    }

    // Standard JavaBean Getters and Setters
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    // Write-only Verification PIN property (no getter provided)
    public void setVerificationPin(String verificationPin) {
        if (verificationPin != null && verificationPin.matches("\\d{4,6}")) {
            this.verificationPin = verificationPin;
        } else {
            throw new IllegalArgumentException("Verification PIN must be a 4-6 digit numeric string.");
        }
    }
}