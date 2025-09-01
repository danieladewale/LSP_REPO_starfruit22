package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ETLPipeline {
    public static void main(String[] args) {
        final String inputPath = "data/products.csv";
        final String outputPath = "data/transformed_products.csv";

        List<String[]> rows = new ArrayList<>();
        int rowsRead = 0, rowsTransformed = 0, rowsSkipped = 0;

        // ------------ Extract ------------
        try {
            Path in = Paths.get(inputPath);
            if (!Files.exists(in)) {
                System.out.println("Error: Input file '" + inputPath + "' not found.");
                return;
            }
            try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    rows.add(line.split(","));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        rowsRead = Math.max(0, rows.size() - 1); // exclude header
        // Handle empty input (only header)
        if (rowsRead <= 0) {
            writeHeaderOnly(outputPath);
            printSummary(0, 0, 0, outputPath);
            return;
        }

        // ------------ Transform ------------
        List<String[]> out = new ArrayList<>();
        out.add(new String[] {"ProductID","Name","Price","Category","PriceRange"}); // header

        for (int i = 1; i < rows.size(); i++) { // skip header
            String[] r = rows.get(i);
            if (r.length < 4) { rowsSkipped++; continue; }

            try {
                int productId = Integer.parseInt(r[0].trim());
                String name = r[1].trim().toUpperCase();                 // (1) uppercase
                double price = Double.parseDouble(r[2].trim());
                String category = r[3].trim();
                String originalCategory = category;

                // (2) discount if Electronics
                if (originalCategory.equalsIgnoreCase("Electronics")) {
                    price = round(price * 0.90, 2);
                } else {
                    price = round(price, 2); // normalize to 2 decimals anyway
                }

                // (3) recategorize if post-discount > 500 and original category was Electronics
                if (originalCategory.equalsIgnoreCase("Electronics") && price > 500.0) {
                    category = "Premium Electronics";
                }

                // (4) price range from FINAL price
                String priceRange = priceRange(price);

                out.add(new String[] {
                        String.valueOf(productId),
                        name,
                        String.format("%.2f", price),
                        category,
                        priceRange
                });
                rowsTransformed++;
            } catch (Exception e) {
                rowsSkipped++;
            }
        }

        // ------------ Load ------------
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {
            for (String[] r : out) {
                pw.println(String.join(",", r));
            }
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
            return;
        }

        // ------------ Summary ------------
        printSummary(rowsRead, rowsTransformed, rowsSkipped, outputPath);
    }

    private static void writeHeaderOnly(String outputPath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {
            pw.println("ProductID,Name,Price,Category,PriceRange");
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }

    private static void printSummary(int read, int transformed, int skipped, String outPath) {
        System.out.println("Run Summary:");
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + transformed);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + outPath);
    }

    private static double round(double value, int places) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private static String priceRange(double price) {
        if (price <= 10.00) return "Low";
        if (price <= 100.00) return "Medium";
        if (price <= 500.00) return "High";
        return "Premium";
        }
}
