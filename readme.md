# Assignment 2 – CSV ETL Pipeline

This program reads a CSV file (`data/products.csv`), applies transformations, and writes the results to `data/transformed_products.csv`. It follows the Extract → Transform → Load process: product names are uppercased, a 10% discount is applied to Electronics, items over $500 in Electronics become Premium Electronics, and a PriceRange column is added (Low, Medium, High, Premium). Prices are rounded to two decimals with HALF_UP rounding. The program also handles missing or empty input files gracefully and prints a run summary.


## Assumptions
- The program is always run from the project root (the folder containing `src/` and `data/`).
- Input file is named `products.csv` and placed inside the `data/` folder.
- Input CSV format is `ProductID,Name,Price,Category` with a header row.
- Prices are valid decimal numbers; product IDs are integers.
- Fields do not contain commas or quotes (simple split on `,` is safe).
- Output is always written to `data/transformed_products.csv` with the correct header.

## Testing
I tested the program using three scenarios:
1. **Normal Input (Case A):** `products.csv` with 6 sample products. Verified that output matched the golden file, with names uppercased, Electronics discounted, Premium Electronics reclassified, and PriceRange calculated.
2. **Empty Input (Case B):** `products.csv` with only the header row. Verified that output contained only the header row, no errors.
3. **Missing File (Case C):** Deleted `products.csv`. Verified that the program printed a clear error message and stopped without crashing.
4. Also tested rows with fewer than 4 fields → they were skipped as expected.

These tests confirm the program handles normal, empty, and error cases correctly.

## How to Run
From the project root (the folder that contains `src/` and `data/`):

```bash
javac src/org/howard/edu/lsp/assignment2/ETLPipeline.java
java -cp src org.howard.edu.lsp.assignment2.ETLPipeline
```
## AI Usage
I used ChatGPT mainly to clarify assignment requirements, assist me with writing the pipeline, and stay on track. For example, I asked about whether this code should go in the same file as Assignment 1 and how to create the CSV files to run the program. ChatGPT’s response explained the correct folder structure and gave me a sample products.csv, which I used to test my code. I also asked for help drafting a README. The responses gave me structure and examples, but I rewrote everything in my own words, adjusted the code to fit the rubric, and tested the program myself to make sure it worked as required.

