import java.util.*;

public class MedicalTestAnalyzer {

    public static void main(String[] args) {
        // Sample medical test results
        double[] testResults = {75.5, 85.0, 90.0, 110.0, 120.0, 130.0, 95.0, 100.0, 80.0, 105.0};

        // Define result ranges
        double[] resultRanges = {70.0, 100.0, 120.0, Double.MAX_VALUE};

        // Initialize counters for each result range
        int[] patientCounts = new int[resultRanges.length + 1];
        double[] resultSum = new double[resultRanges.length + 1];

        // Analyze test results
        for (double result : testResults) {
            int rangeIndex = getResultRangeIndex(result, resultRanges);
            patientCounts[rangeIndex]++;
            resultSum[rangeIndex] += result;
        }

        // Display results
        System.out.println("Result Range \t\t Number of Patients \t Average Value");
        for (int i = 0; i < resultRanges.length; i++) {
            String range;
            if (i == 0) {
                range = "Below " + resultRanges[i];
            } else {
                range = resultRanges[i - 1] + " - " + resultRanges[i];
            }
            double averageValue = (patientCounts[i] != 0) ? (resultSum[i] / patientCounts[i]) : 0;
            System.out.printf("%-20s \t %d \t\t\t %.2f\n", range, patientCounts[i], averageValue);
        }
        // Last range
        System.out.printf("Above %.0f \t\t\t %d \t\t\t %.2f\n", resultRanges[resultRanges.length - 1], patientCounts[resultRanges.length], (resultSum[resultRanges.length] / patientCounts[resultRanges.length]));
    }

    // Helper method to find the result range index for a given result
    private static int getResultRangeIndex(double result, double[] resultRanges) {
        for (int i = 0; i < resultRanges.length; i++) {
            if (result < resultRanges[i]) {
                return i;
            }
        }
        return resultRanges.length; // if the result exceeds all ranges
    }
}
