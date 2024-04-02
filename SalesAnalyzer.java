import java.util.*;

public class ProductSalesAnalyzer {
    
    public static void main(String[] args) {
        // Sample product sales data
        double[] sales = {20.5, 45.75, 60.0, 85.25, 110.75, 150.0, 175.25, 200.0, 225.75};
        
        // Define price ranges
        double[] priceRanges = {50.0, 100.0, 200.0, Double.MAX_VALUE};
        
        // Initialize counters for each price range
        int[] productCounts = new int[priceRanges.length + 1];
        double[] revenuePerRange = new double[priceRanges.length + 1];
        
        // Analyze product sales
        for (double sale : sales) {
            int rangeIndex = getPriceRangeIndex(sale, priceRanges);
            productCounts[rangeIndex]++;
            revenuePerRange[rangeIndex] += sale;
        }
        
        // Display results
        System.out.println("Price Range \t Number of Products Sold \t Total Revenue");
        for (int i = 0; i < priceRanges.length; i++) {
            String range = (i == 0) ? "$0 - $" + priceRanges[i] : "$" + priceRanges[i-1] + " - $" + priceRanges[i];
            System.out.println(range + "\t\t\t " + productCounts[i] + "\t\t\t\t $" + revenuePerRange[i]);
        }
        // Last range
        System.out.println("$" + priceRanges[priceRanges.length - 1] + " and
