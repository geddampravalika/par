import java.util.*;

public class EmployeeWorkHoursAnalyzer {

    public static void main(String[] args) {
        // Sample employee work hours
        int[][] workHours = {
            {45, 40, 35, 50, 55}, // Employee 1
            {40, 40, 40, 40, 40}, // Employee 2
            {30, 35, 32, 38, 40}, // Employee 3
            {50, 45, 48, 40, 42}  // Employee 4
        };

        // Initialize counters for each category
        int[] moreThan40 = new int[2]; // 0 - Number of employees, 1 - Total hours
        int[] exactly40 = new int[2];  // 0 - Number of employees, 1 - Total hours
        int[] lessThan40 = new int[2]; // 0 - Number of employees, 1 - Total hours

        // Analyze work hours
        for (int[] hours : workHours) {
            int totalHours = 0;
            for (int h : hours) {
                totalHours += h;
            }
            if (totalHours > 40 * hours.length) {
                moreThan40[0]++;
                moreThan40[1] += totalHours;
            } else if (totalHours == 40 * hours.length) {
                exactly40[0]++;
                exactly40[1] += totalHours;
            } else {
                lessThan40[0]++;
                lessThan40[1] += totalHours;
            }
        }

        // Calculate average hours worked per day for each category
        double avgMoreThan40 = moreThan40[1] / (double) (moreThan40[0] * 5);
        double avgExactly40 = exactly40[1] / (double) (exactly40[0] * 5);
        double avgLessThan40 = lessThan40[1] / (double) (lessThan40[0] * 5);

        // Display results
        System.out.println("Category \t Number of Employees \t Average Hours Worked Per Day");
        System.out.printf("More than 40 hours \t %d \t\t\t %.2f\n", moreThan40[0], avgMoreThan40);
        System.out.printf("Exactly 40 hours \t %d \t\t\t %.2f\n", exactly40[0], avgExactly40);
        System.out.printf("Less than 40 hours \t %d \t\t\t %.2f\n", lessThan40[0], avgLessThan40);
    }
}
