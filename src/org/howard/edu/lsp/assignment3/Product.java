package org.howard.edu.lsp.assignment3;

/**
 * Represents a product in the ETL pipeline with encapsulated data and behavior.
 * Demonstrates encapsulation by bundling data fields with related methods.
 * 
 * @author Your Name
 * @version 1.0
 */
public class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int quantity;
    private double discountPercentage;
    
    /**
     * Constructs a Product with the specified attributes.
     */
    public Product(String productId, String productName, double price, 
                   String category, int quantity, double discountPercentage) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.discountPercentage = discountPercentage;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getCategory() {
        return category;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getPriceRange() {
        if (price <= 10.00) return "Low";
        if (price <= 100.00) return "Medium";
        if (price <= 500.00) return "High";
        return "Premium";
    }
    
    public String toCsvString() {
        return String.format("%s,%s,%.2f,%s,%s", 
                           productId, productName, price, category, getPriceRange());
    }
    
    @Override
    public String toString() {
        return String.format("Product{id='%s', name='%s', price=%.2f, category='%s'}",
                           productId, productName, price, category);
    }
}