package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Interface for data extraction operations in the ETL pipeline.
 * Demonstrates polymorphism by allowing different extraction implementations.
 * 
 * @author Your Name
 * @version 1.0
 */
public interface DataExtractor {
    /**
     * Extracts data from the specified source and returns a list of products.
     * 
     * @param sourcePath the path to the data source
     * @return a list of Product objects extracted from the source
     * @throws IOException if an error occurs during data extraction
     */
    List<Product> extractData(String sourcePath) throws IOException;
}