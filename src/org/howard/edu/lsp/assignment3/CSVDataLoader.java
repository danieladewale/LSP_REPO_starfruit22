package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * CSV implementation of DataLoader interface.
 * Demonstrates polymorphism by implementing the DataLoader interface
 * and encapsulation by hiding CSV writing details.
 * 
 * @author Your Name
 * @version 1.0
 */
public class CSVDataLoader implements DataLoader {
    
    private static final String CSV_HEADER = "ProductID,Name,Price,Category,PriceRange";
    
    /**
     * Loads product data to a CSV file with proper formatting.
     * 
     * @param products the list of products to write
     * @param destinationPath the path to the output CSV file
     * @throws IOException if the file cannot be written
     */
    @Override
    public void loadData(List<Product> products, String destinationPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {
            // Write header
            writer.write(CSV_HEADER);
            writer.newLine();
            
            // Write product data
            for (Product product : products) {
                writer.write(product.toCsvString());
                writer.newLine();
            }
            
            writer.flush();
        }
        
        System.out.println("Successfully wrote " + products.size() + " products to " + destinationPath);
    }
}