public class SubclassAccessChecker {

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
                // SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE is explicitly DENIED for protected
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

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) {
            return "None Denied";
        }

        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i] != null && attempts[i].length >= 2) {
                String modifier = attempts[i][0];
                String context = attempts[i][1];

                String result = classifyAccess(modifier, context);
                if ("DENIED".equals(result)) {
                    return String.format("%s via %s (attempt #%d)", modifier, context, (i + 1));
                }
            }
        }

        return "None Denied";
    }
}