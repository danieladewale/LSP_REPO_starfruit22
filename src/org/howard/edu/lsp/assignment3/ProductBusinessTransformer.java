package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of DataTransformer for product business logic.
 * Demonstrates inheritance by extending DataTransformer and implementing
 * specific business rules for product data transformation.
 * 
 * @author Your Name
 * @version 1.0
 */
public class ProductBusinessTransformer extends DataTransformer {
    
    private int transformedCount = 0;
    
    /**
     * Applies business transformations to the product list.
     * Filters products based on category and applies business rules.
     * 
     * @param products the list of products to transform
     * @return the transformed list of products
     */
    @Override
    protected List<Product> applyTransformation(List<Product> products) {
        List<Product> transformedProducts = new ArrayList<>();
        transformedCount = 0;
        
        for (Product product : products) {
            if (shouldIncludeProduct(product)) {
                Product transformedProduct = applyBusinessRules(product);
                transformedProducts.add(transformedProduct);
                transformedCount++;
            }
        }
        
        return transformedProducts;
    }
    
    /**
     * Pre-transformation hook to log start of processing.
     */
    @Override
    protected void preTransform() {
        System.out.println("Starting product business transformation...");
    }
    
    /**
     * Post-transformation hook to log completion statistics.
     */
    @Override
    protected void postTransform() {
        System.out.println("Transformation completed. Products processed: " + transformedCount);
    }
    
    /**
     * Determines if a product should be included in the output
     * based on business rules. Assignment 2 included all products.
     * 
     * @param product the product to evaluate
     * @return true if the product should be included, false otherwise
     */
    private boolean shouldIncludeProduct(Product product) {
        // Include all products (Assignment 2 behavior)
        return true;
    }
    
    /**
     * Applies business transformation rules to a product.
     * This method encapsulates the business logic to match Assignment 2 exactly.
     * 
     * @param originalProduct the original product
     * @return a new product with business rules applied
     */
    private Product applyBusinessRules(Product originalProduct) {
        // Get original values
        String originalCategory = originalProduct.getCategory();
        double originalPrice = originalProduct.getPrice();
        
        // Apply Electronics discount first (10% off = multiply by 0.90)
        double transformedPrice = originalPrice;
        if (originalCategory.equalsIgnoreCase("Electronics")) {
            transformedPrice = round(originalPrice * 0.90, 2);
        } else {
            transformedPrice = round(originalPrice, 2);
        }
        
        // Determine final category (Premium Electronics if original was Electronics and post-discount > 500)
        String finalCategory = originalCategory;
        if (originalCategory.equalsIgnoreCase("Electronics") && transformedPrice > 500.0) {
            finalCategory = "Premium Electronics";
        }
        
        // Create transformed product with uppercase name
        Product transformedProduct = new Product(
            originalProduct.getProductId(),
            originalProduct.getProductName().toUpperCase(), // Transform name to uppercase
            transformedPrice,  // Use the discounted/rounded price
            finalCategory,     // Use potentially updated category
            originalProduct.getQuantity(),
            originalProduct.getDiscountPercentage()
        );
        
        return transformedProduct;
    }
    
    /**
     * Rounds a double to specified decimal places using BigDecimal for precision.
     * 
     * @param value the value to round
     * @param places the number of decimal places
     * @return the rounded value
     */
    private double round(double value, int places) {
        java.math.BigDecimal bd = new java.math.BigDecimal(Double.toString(value));
        bd = bd.setScale(places, java.math.RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
