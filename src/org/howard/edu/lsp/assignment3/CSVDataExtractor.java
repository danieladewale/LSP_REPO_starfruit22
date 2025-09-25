package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV implementation of DataExtractor interface.
 * Demonstrates polymorphism by implementing the DataExtractor interface
 * and encapsulation by hiding CSV parsing details.
 * 
 * @author Your Name
 * @version 1.0
 */
public class CSVDataExtractor implements DataExtractor {
    
    /**
     * Extracts product data from a CSV file.
     * Expected CSV format: ProductID,Name,Price,Category
     * 
     * @param sourcePath the path to the CSV file
     * @return a list of Product objects extracted from the CSV
     * @throws IOException if the file cannot be read or is malformed
     */
    @Override
    public List<Product> extractData(String sourcePath) throws IOException {
        List<Product> products = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath))) {
            String line = reader.readLine(); // Skip header line
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    Product product = parseProductFromLine(line);
                    if (product != null) {
                        products.add(product);
                    }
                }
            }
        }
        
        return products;
    }
    
    /**
     * Parses a single line of CSV data into a Product object.
     * Expected format from Assignment 2: ProductID,Name,Price,Category
     * 
     * @param line the CSV line to parse
     * @return a Product object or null if the line is invalid
     */
    private Product parseProductFromLine(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                String productId = parts[0].trim();
                String productName = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                String category = parts[3].trim();
                
                // Use default values for quantity and discount (not in Assignment 2 format)
                int quantity = 1;
                double discountPercentage = 0.0;
                
                return new Product(productId, productName, price, category, quantity, discountPercentage);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing line: " + line + " - " + e.getMessage());
        }
        return null;
    }
}