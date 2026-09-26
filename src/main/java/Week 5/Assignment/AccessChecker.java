import java.util.LinkedHashMap;
import java.util.Map;

class LibraryMember {
    private String membershipPin; // Private: accessible only inside LibraryMember
    String branchCode;            // Package-private / Default: accessible only in the same package
    protected double finesOwed;   // Protected: accessible to same package and subclasses
    public String displayName;    // Public: accessible from anywhere

    public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}

public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier) {
            case "public":
                return "ALLOWED";

            case "protected":
                if (accessorContext.equals("SAME_CLASS") || 
                    accessorContext.equals("SAME_PACKAGE") || 
                    accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "default":
                if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "private":
                if (accessorContext.equals("SAME_CLASS")) {
                    return "ALLOWED";
                }
                return "DENIED";

            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        Map<String, int[]> counts = new LinkedHashMap<>();
        counts.put("private", new int[]{0, 0});   // index 0: allowed, index 1: denied
        counts.put("default", new int[]{0, 0});
        counts.put("protected", new int[]{0, 0});
        counts.put("public", new int[]{0, 0});

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String modifier = attempt[0];
                    String context = attempt[1];

                    if (counts.containsKey(modifier)) {
                        String result = classifyAccess(modifier, context);
                        if ("ALLOWED".equals(result)) {
                            counts.get(modifier)[0]++;
                        } else {
                            counts.get(modifier)[1]++;
                        }
                    }
                }
            }
        }

        StringBuilder summary = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, int[]> entry : counts.entrySet()) {
            if (i > 0) {
                summary.append(" | ");
            }
            summary.append(entry.getKey()).append(": ")
                   .append(entry.getValue()[0]).append(" allowed / ")
                   .append(entry.getValue()[1]).append(" denied");
            i++;
        }

        return summary.toString();
    }
}