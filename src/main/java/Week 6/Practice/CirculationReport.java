public class CirculationReport {

    public static String batchPrint(LibraryMember[] members) {
        if (members == null) {
            return "";
        }

        StringBuilder reportBuilder = new StringBuilder();

        for (LibraryMember member : members) {
            if (member == null) {
                continue;
            }

            // Polymorphic call to displayInfo()
            reportBuilder.append(member.displayInfo());

            // Downcast check to access subclass-specific method getCourse()
            if (member instanceof StudentMember) {
                StudentMember studentMember = (StudentMember) member;
                reportBuilder.append(" [Course via downcast: ")
                             .append(studentMember.getCourse())
                             .append("]");
            }

            reportBuilder.append(" | ");
        }

        return reportBuilder.toString();
    }
}