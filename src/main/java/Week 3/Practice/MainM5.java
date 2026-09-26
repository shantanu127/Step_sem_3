class Student {
    String name;
    double attendance;

    // Shared static fields
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // Increment student count whenever a new object is instantiated
    }

    public static void printCollegeInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Total Students Enrolled: " + studentCount);
    }
}

public class MainM5 {
    public static void main(String[] args) {
        Student student1 = new Student("Ravi", 85.5);
        Student student2 = new Student("Anitha", 92.0);

        // Called via class name, not instance references
        Student.printCollegeInfo();
    }
}