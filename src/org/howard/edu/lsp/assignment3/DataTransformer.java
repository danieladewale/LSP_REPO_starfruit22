package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Abstract base class for data transformation operations.
 * Demonstrates inheritance and the Template Method design pattern.
 * Provides a framework for different types of data transformations.
 * 
 * @author Your Name
 * @version 1.0
 */
public abstract class DataTransformer {
    
    /**
     * Template method that defines the transformation process.
     * Subclasses implement the specific transformation logic.
     * 
     * @param products the list of products to transform
     * @return the transformed list of products
     */
    public final List<Product> transform(List<Product> products) {
        preTransform();
        List<Product> result = applyTransformation(products);
        postTransform();
        return result;
    }
    
    /**
     * Hook method called before transformation begins.
     * Subclasses can override to add pre-processing logic.
     */
    protected void preTransform() {
        // Default implementation does nothing
    }
    
    /**
     * Abstract method that must be implemented by subclasses
     * to define specific transformation logic.
     * 
     * @param products the list of products to transform
     * @return the transformed list of products
     */
    protected abstract List<Product> applyTransformation(List<Product> products);
    
    /**
     * Hook method called after transformation completes.
     * Subclasses can override to add post-processing logic.
     */
    protected void postTransform() {
        // Default implementation does nothing
    }
}