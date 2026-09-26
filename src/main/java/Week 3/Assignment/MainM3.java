class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns using constructor chaining via this(...)
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class MainM3 {
    public static void main(String[] args) {
        Employee permanentEmployee = new Employee("E-101", "Divya", 65000);
        Employee internEmployee = new Employee("E-102", "Arjun");

        permanentEmployee.printProfile();
        internEmployee.printProfile();
    }
}