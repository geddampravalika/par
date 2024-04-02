import java.util.*;

public class WeatherDataAnalyzer {
    
    public static void main(String[] args) {
        // Sample weather data (temperature in Celsius, humidity in percentage)
        double[][] weatherData = {
            {5.0, 60.0},
            {15.0, 55.0},
            {8.0, 70.0},
            {-2.0, 80.0},
            {25.0, 45.0},
            {10.0, 65.0},
            {-5.0, 75.0},
            {18.0, 50.0},
            {12.0, 62.0},
            {20.0, 40.0}
        };
        
        // Define temperature ranges and humidity accumulator
        double[] tempRanges = {-10.0, 0.0, 10.0, 20.0, 30.0};
        int[] dayCounts = new int[tempRanges.length + 1];
        double[] humiditySums = new double[tempRanges.length + 1];
        
        // Analyze weather data
        for (double[] data : weatherData) {
            double temperature = data[0];
            double humidity = data[1];
            int rangeIndex = getTemperatureRangeIndex(temperature, tempRanges);
            dayCounts[rangeIndex]++;
            humiditySums[rangeIndex] += humidity;
        }
        
        // Display results
        System.out.println("Temperature Range \t Number of Days \t Average Humidity");
        for (int i = 0; i < tempRanges.length; i++) {
            String range;
            if (i == 0) {
                range = "< " + tempRanges[i] + "°C";
            } else {
                range = tempRanges[i-1] + "°C - " + tempRanges[i] + "°C";
            }
            double averageHumidity = (dayCounts[i] != 0) ? (humiditySums[i] / dayCounts[i]) : 0;
            System.out.printf("%-20s \t %d \t\t %.2f%%\n", range, dayCounts[i], averageHumidity);
        }
        // Last range
        System.out.printf(">= %.0f°C \t\t\t %d \t\t %.2f%%\n", tempRanges[tempRanges.length - 1], dayCounts[tempRanges.length], (humiditySums[tempRanges.length] / dayCounts[tempRanges.length]));
    }
    
    // Helper method to find the temperature range index for a given temperature
    private static int getTemperatureRangeIndex(double temperature, double[] tempRanges) {
        for (int i = 0; i < tempRanges.length; i++) {
            if (temperature < tempRanges[i]) {
                return i;
            }
        }
        return tempRanges.length; // if the temperature exceeds all ranges
    }
}
