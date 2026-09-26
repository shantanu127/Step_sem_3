public class AttendanceAnnouncer {

    public static String batchPrint(GymMember[] members) {
        if (members == null) {
            return "";
        }

        StringBuilder announcementBuilder = new StringBuilder();

        for (GymMember member : members) {
            if (member == null) {
                continue;
            }

            // Polymorphic call to displayInfo()
            announcementBuilder.append(member.displayInfo());

            // Safe downcasting using instanceof check
            if (member instanceof PremiumMember) {
                PremiumMember premiumMember = (PremiumMember) member;
                announcementBuilder.append(" [Trainer via downcast: ")
                                   .append(premiumMember.getTrainerName())
                                   .append("]");
            }

            announcementBuilder.append(" | ");
        }

        return announcementBuilder.toString();
    }
}