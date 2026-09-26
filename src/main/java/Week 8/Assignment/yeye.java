abstract class Room {
    private final String roomNumber;
    private final int capacity;
    private int currentOccupancy;

    public Room(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.currentOccupancy = 0;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public boolean isFull() {
        return currentOccupancy >= capacity;
    }

    public void incrementOccupancy() {
        this.currentOccupancy++;
    }

    public abstract boolean canAcceptStudent(Student student);
}

class SingleRoom extends Room {
    public SingleRoom(String roomNumber) {
        super(roomNumber, 1);
    }

    @Override
    public boolean canAcceptStudent(Student student) {
        return !isFull();
    }
}

class SharedRoom extends Room {
    public SharedRoom(String roomNumber, int capacity) {
        super(roomNumber, capacity);
    }

    @Override
    public boolean canAcceptStudent(Student student) {
        return !isFull();
    }
}

class SpecialAccessRoom extends Room {
    public SpecialAccessRoom(String roomNumber) {
        super(roomNumber, 1);
    }

    @Override
    public boolean canAcceptStudent(Student student) {
        return !isFull() && student.requiresSpecialAccess();
    }
}

class Student {
    private final String studentId;
    private final boolean specialAccessRequired;

    public Student(String studentId, boolean specialAccessRequired) {
        this.studentId = studentId;
        this.specialAccessRequired = specialAccessRequired;
    }

    public String getStudentId() {
        return studentId;
    }

    public boolean requiresSpecialAccess() {
        return specialAccessRequired;
    }
}

class RoomAllotmentEngine {
    public static boolean allotRoom(Student student, Room room) {
        if (!room.canAcceptStudent(student)) {
            if (room.isFull()) {
                System.out.println("Allotment failed: Room " + room.getRoomNumber() + " is full.");
            } else if (room instanceof SpecialAccessRoom && !student.requiresSpecialAccess()) {
                System.out.println("Allotment failed: Room " + room.getRoomNumber() + " requires special access eligibility.");
            } else {
                System.out.println("Allotment failed for student " + student.getStudentId() + " in room " + room.getRoomNumber() + ".");
            }
            return false;
        }

        room.incrementOccupancy();
        System.out.println("Allotment successful: Student " + student.getStudentId() + " assigned to Room " + room.getRoomNumber() + ".");
        return true;
    }
}