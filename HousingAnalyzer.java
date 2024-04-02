import java.util.*;

public class HousingAnalyzer {

    public static void main(String[] args) {
        // Sample housing prices and square footages
        double[][] housingData = {
            {150000, 1200},
            {180000, 1400},
            {220000, 1600},
            {250000, 1800},
            {280000, 2000},
            {320000, 2200},
            {350000, 2400},
            {380000, 2600},
            {420000, 2800},
            {450000, 3000}
        };

        // Define price ranges
        double[] priceRanges = {100000, 200000, 300000, 400000, Double.MAX_VALUE};

        // Initialize counters for each price range
        int[] houseCounts = new int[priceRanges.length + 1];
        double[] squareFootageSum = new double[priceRanges.length + 1];

        // Analyze housing data
        for (double[] data : housingData) {
            double price = data[0];
            double squareFootage = data[1];

            // Find the appropriate price range index
            int rangeIndex = getPriceRangeIndex(price, priceRanges);

            // Increment the number of houses sold for the corresponding price range
            houseCounts[rangeIndex]++;

            // Accumulate the square footage for the corresponding price range
            squareFootageSum[rangeIndex] += squareFootage;
        }

        // Display results
        System.out.println("Price Range \t\t Number of Houses Sold \t Average Square Footage");
        for (int i = 0; i < priceRanges.length; i++) {
            String range;
            if (i == 0) {
                range = "$0 - $" + priceRanges[i];
            } else {
                range = "$" + priceRanges[i-1] + " - $" + priceRanges[i];
            }
            double averageSquareFootage = (houseCounts[i] != 0) ? (squareFootageS
