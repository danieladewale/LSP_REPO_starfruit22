package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Main ETL Pipeline class that orchestrates the Extract-Transform-Load process.
 * Demonstrates composition by using DataExtractor, DataTransformer, and DataLoader
 * components to build a complete pipeline.
 * 
 * @author Your Name
 * @version 1.0
 */
public class ETLPipeline {
    
    private final DataExtractor extractor;
    private final DataTransformer transformer;
    private final DataLoader loader;
    
    /**
     * Constructs an ETL Pipeline with the specified components.
     * Demonstrates dependency injection and composition.
     * 
     * @param extractor the data extraction component
     * @param transformer the data transformation component  
     * @param loader the data loading component
     */
    public ETLPipeline(DataExtractor extractor, DataTransformer transformer, DataLoader loader) {
        this.extractor = extractor;
        this.transformer = transformer;
        this.loader = loader;
    }
    
    /**
     * Executes the complete ETL pipeline process.
     * 
     * @param inputPath the path to the input data file
     * @param outputPath the path for the output data file
     * @throws IOException if file operations fail
     */
    public void execute(String inputPath, String outputPath) throws IOException {
        try {
            System.out.println("=== Starting ETL Pipeline ===");
            
            // Validate input file exists
            if (!new File(inputPath).exists()) {
                throw new IOException("Input file not found: " + inputPath);
            }
            
            // Extract
            System.out.println("Step 1: Extracting data from " + inputPath);
            List<Product> extractedData = extractor.extractData(inputPath);
            System.out.println("Extracted " + extractedData.size() + " records");
            
            // Transform
            System.out.println("Step 2: Transforming data");
            List<Product> transformedData = transformer.transform(extractedData);
            System.out.println("Transformed " + transformedData.size() + " records");
            
            // Load
            System.out.println("Step 3: Loading data to " + outputPath);
            loader.loadData(transformedData, outputPath);
            
            System.out.println("=== ETL Pipeline Completed Successfully ===");
            
        } catch (IOException e) {
            System.err.println("ETL Pipeline failed: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Main method to run the ETL pipeline.
     * Creates the pipeline components and executes the process.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Define file paths using relative paths as required
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";
        
        try {
            // Create pipeline components (composition)
            DataExtractor extractor = new CSVDataExtractor();
            DataTransformer transformer = new ProductBusinessTransformer();
            DataLoader loader = new CSVDataLoader();
            
            // Create and execute pipeline
            ETLPipeline pipeline = new ETLPipeline(extractor, transformer, loader);
            pipeline.execute(inputPath, outputPath);
            
        } catch (IOException e) {
            System.err.println("Pipeline execution failed: " + e.getMessage());
            System.exit(1);
        }
    }
}