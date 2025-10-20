package org.howard.edu.lsp.midterm.question2;

/**
 * AreaCalculator provides overloaded methods to calculate areas of different shapes.
 * All methods validate input dimensions and throw IllegalArgumentException for invalid values.
 */
public class AreaCalculator {

    /**
     * Calculates the area of a circle.
     * Circle area: π (use class Math.PI) × r²
     *
     * @param radius the radius of the circle
     * @return the area of the circle
     * @throws IllegalArgumentException if radius is less than or equal to 0
     */
    public static double area(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the area of a rectangle.
     * Rectangle area: width × height
     *
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @return the area of the rectangle
     * @throws IllegalArgumentException if width or height is less than or equal to 0
     */
    public static double area(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than 0");
        }
        return width * height;
    }

    /**
     * Calculates the area of a triangle using base and height.
     * Triangle area: ½ × base × height
     *
     * @param base the base of the triangle
     * @param height the height of the triangle
     * @return the area of the triangle
     * @throws IllegalArgumentException if base or height is less than or equal to 0
     */
    public static double area(int base, int height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be greater than 0");
        }
        return 0.5 * base * height;
    }

    /**
     * Calculates the area of a square.
     * Square area: side²
     *
     * @param side the side length of the square
     * @return the area of the square
     * @throws IllegalArgumentException if side is less than or equal to 0
     */
    public static double area(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be greater than 0");
        }
        return side * side;
    }
}
