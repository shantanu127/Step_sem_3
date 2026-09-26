import java.util.Arrays;

class LibraryMember {
    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;
    private int[] fineHistory;
    private int fineCount;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Member ID cannot be blank, whitespace-only, or shorter than 4 characters.");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        this.fineHistory = new int[10];
        this.fineCount = 0;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        if (memberIds == null) {
            return "Enrolled: 0 | Rejected: 0";
        }

        int enrolled = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new LibraryMember(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }
}

class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    protected void chargeFine(int amount) {
        // Halves the fine amount before passing to super
        super.chargeFine(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
    }
}