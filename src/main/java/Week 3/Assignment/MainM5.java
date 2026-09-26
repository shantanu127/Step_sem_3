class Employee {
    String empName;
    double salary;

    // Shared static fields
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increment count on every instantiation
    }

    public static void printCompanyInfo() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Employees: " + employeeCount);
    }
}

public class MainM5 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Anish", 55000);
        Employee emp2 = new Employee("Bhavna", 62000);
        Employee emp3 = new Employee("Chetan", 48000);

        // Called directly through the class name
        Employee.printCompanyInfo();
    }
}