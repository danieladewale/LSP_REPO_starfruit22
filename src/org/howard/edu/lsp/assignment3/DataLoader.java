package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Interface for data loading (writing) operations in the ETL pipeline.
 * Demonstrates polymorphism by allowing different output implementations.
 * 
 * @author Your Name
 * @version 1.0
 */
public interface DataLoader {
    /**
     * Loads (writes) the processed data to the specified destination.
     * 
     * @param products the list of products to write
     * @param destinationPath the path to write the data to
     * @throws IOException if an error occurs during data writing
     */
    void loadData(List<Product> products, String destinationPath) throws IOException;
}