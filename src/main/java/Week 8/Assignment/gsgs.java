import java.util.Objects;

abstract class WashCycle {
    private final String name;
    private final int durationMinutes;
    private final double charge;

    public WashCycle(String name, int durationMinutes, double charge) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getCharge() {
        return charge;
    }
}

class QuickWash extends WashCycle {
    public QuickWash() {
        super("Quick wash", 30, 20.00);
    }
}

class NormalWash extends WashCycle {
    public NormalWash() {
        super("Normal wash", 45, 30.00);
    }
}

class HeavyWash extends WashCycle {
    public HeavyWash() {
        super("Heavy wash", 60, 45.00);
    }
}

// Extensible design: New wash types (e.g., DelicateWash) can be added easily
class DelicateWash extends WashCycle {
    public DelicateWash() {
        super("Delicate wash", 40, 35.00);
    }
}

class Student {
    private final String name;

    public Student(String name) {
        this.name = Objects.requireNonNull(name, "Student name cannot be null");
    }

    public String getName() {
        return name;
    }
}

class WashingMachine {
    private final String machineId;
    private boolean isBusy;
    private Student currentStudent;
    private WashCycle currentWashCycle;

    public WashingMachine(String machineId) {
        this.machineId = Objects.requireNonNull(machineId, "Machine ID cannot be null");
        this.isBusy = false;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public boolean startWash(Student student, WashCycle washCycle) {
        if (isBusy) {
            System.out.println("Machine " + machineId + " is currently busy.");
            return false;
        }
        this.currentStudent = student;
        this.currentWashCycle = washCycle;
        this.isBusy = true;

        System.out.printf("%s started on %s for %s (%d min). Charge: ₹%.2f.%n",
                washCycle.getName(), machineId, student.getName(),
                washCycle.getDurationMinutes(), washCycle.getCharge());
        return true;
    }

    public void completeCycle() {
        if (!isBusy) {
            System.out.println("Machine " + machineId + " is already idle.");
            return;
        }
        System.out.println(machineId + " cycle completed. " + machineId + " is now free.");
        this.isBusy = false;
        this.currentStudent = null;
        this.currentWashCycle = null;
    }
}