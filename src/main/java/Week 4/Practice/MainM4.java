class SrmStudent {
    private String name;

    // Static fields loaded once
    private static String collegeName;
    private static int academicYear;

    // Static block executes exactly once when the class is loaded
    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = 2026;
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + this.name);
    }
}

public class MainM4 {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String name : names) {
            new SrmStudent(name);
        }
    }
}