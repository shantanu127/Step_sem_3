import java.util.Random;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights arrays must be non-null and equal in length.");
        }

        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            try {
                if (heights[i] <= 0 || weights[i] <= 0) {
                    throw new ArithmeticException("Height and Weight must be positive values.");
                }

                double bmi = weights[i] / (heights[i] * heights[i]);
                String status = getBmiStatus(bmi);

                System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s\n", 
                        (i + 1), heights[i], weights[i], bmi, status);

            } catch (ArithmeticException e) {
                System.out.printf("Person %-3d | Invalid Data: %s\n", (i + 1), e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        int numberOfEmployees = 10;
        double[] heights = new double[numberOfEmployees];
        double[] weights = new double[numberOfEmployees];

        Random random = new Random();

        // Populate with sample randomized data
        for (int i = 0; i < numberOfEmployees; i++) {
            heights[i] = 1.50 + (0.40 * random.nextDouble()); // 1.50m - 1.90m
            weights[i] = 45.0 + (55.0 * random.nextDouble()); // 45kg - 100kg
        }

        try {
            printWellnessReport(heights, weights);
        } catch (Exception e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}