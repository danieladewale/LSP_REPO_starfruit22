package org.howard.edu.lsp.midterm.question2;

/**
 * Main class demonstrates the usage of AreaCalculator's overloaded methods.
 * Tests all area calculation methods statically and handles exceptions.
 *
 * The use of overloading allows methods with different parameter types and counts
 * to share the same name (area), providing a clean and intuitive API. This is preferable
 * to using different method names like calculateCircleArea, calculateRectangleArea, etc.
 */
public class Main {
    public static void main(String[] args) {
        // Test circle area with radius 3.0
        double circleRadius = 3.0;
        double circleArea = AreaCalculator.area(circleRadius);
        System.out.println("Circle radius " + circleRadius + " -> area = " + circleArea);

        // Test rectangle area with width 5.0 and height 2.0
        double rectWidth = 5.0;
        double rectHeight = 2.0;
        double rectangleArea = AreaCalculator.area(rectWidth, rectHeight);
        System.out.println("Rectangle " + rectWidth + " x " + rectHeight + " -> area = " + rectangleArea);

        // Test triangle area with base 10 and height 6
        int triBase = 10;
        int triHeight = 6;
        double triangleArea = AreaCalculator.area(triBase, triHeight);
        System.out.println("Triangle base " + triBase + ", height " + triHeight + " -> area = " + triangleArea);

        // Test square area with side 4
        int squareSide = 4;
        double squareArea = AreaCalculator.area(squareSide);
        System.out.println("Square side " + squareSide + " -> area = " + squareArea);

        // Test exception handling with invalid input (negative radius)
        try {
            double invalidRadius = -1.0;
            AreaCalculator.area(invalidRadius);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
