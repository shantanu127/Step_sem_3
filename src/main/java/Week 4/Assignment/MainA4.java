class MembershipCard {
    private static String libraryName;
    private static String validUntil;
    private String studentName;

    // Static block executes exactly once when the class is loaded
    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
        System.out.println("Membership card issued to: " + this.studentName + " (" + libraryName + ", Valid: " + validUntil + ")");
    }
}

public class MainA4 {
    public static void main(String[] args) {
        String[] studentNames = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String name : studentNames) {
            new MembershipCard(name);
        }
    }
}