import java.util.ArrayList;
import java.util.List;

class TimeSlot {
    private final int startHour;
    private final int endHour;

    public TimeSlot(int startHour, int endHour) {
        if (startHour < 0 || endHour > 24 || startHour >= endHour) {
            throw new IllegalArgumentException("Invalid time slot hours.");
        }
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public boolean overlapsWith(TimeSlot other) {
        return this.startHour < other.endHour && other.startHour < this.endHour;
    }

    @Override
    public String toString() {
        return String.format("%02d:00-%02d:00", startHour, endHour);
    }
}

class Equipment {
    private final String equipmentId;
    private final String name;
    private final List<TimeSlot> bookedSlots;

    public Equipment(String equipmentId, String name) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.bookedSlots = new ArrayList<>();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable(TimeSlot slot) {
        for (TimeSlot booked : bookedSlots) {
            if (booked.overlapsWith(slot)) {
                return false;
            }
        }
        return true;
    }

    public boolean bookSlot(TimeSlot slot) {
        if (!isAvailable(slot)) {
            return false;
        }
        bookedSlots.add(slot);
        return true;
    }
}

class Student {
    private final String studentId;

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
}

class BookingService {
    public static boolean createBooking(Student student, Equipment equipment, TimeSlot slot) {
        if (equipment.bookSlot(slot)) {
            System.out.println("Booking successful: " + equipment.getName() + " (" + equipment.getEquipmentId() +
                    ") booked for " + student.getStudentId() + " at " + slot + ".");
            return true;
        } else {
            System.out.println("Booking failed: " + equipment.getName() + " (" + equipment.getEquipmentId() +
                    ") is already booked during " + slot + ".");
            return false;
        }
    }
}