# AI Assistant Prompts Used for Assignment 3

## 1. Initial Object-Oriented Design Consultation
**Prompt**: "I have a procedural ETL pipeline in Java from Assignment 2 that reads CSV product data, applies business transformations (price calculations, discounts, category filtering), and writes output to CSV. How can I redesign this using object-oriented principles like encapsulation, inheritance, and polymorphism while maintaining the exact same functionality?"

**AI Response Excerpt**: 
"Consider breaking your ETL pipeline into separate classes with single responsibilities: a Product class to encapsulate data, interfaces for DataExtractor and DataLoader to enable polymorphism, an abstract DataTransformer class for inheritance, and an ETLPipeline class for composition. This approach separates concerns - your Product class handles data and behavior, interfaces define contracts for different implementations, and the pipeline orchestrates the process..."

## 2. Interface vs Abstract Class Design Decision
**Prompt**: "Should I use interfaces or abstract classes for my data reader and writer components in an ETL pipeline? What are the benefits of each approach for achieving polymorphism?"

**AI Response Excerpt**: 
"Use interfaces for DataExtractor and DataLoader since they represent pure contracts for behavior without shared implementation. This allows you to easily swap between CSV, JSON, or database implementations. Use an abstract class like DataTransformer when you have common functionality to share across subclasses, such as the template method pattern where the overall process is defined but specific steps are customized..."

## 3. Template Method Pattern Implementation
**Prompt**: "Explain how the Template Method pattern could be used for data transformations in an ETL pipeline. Show me a simple example with an abstract base class and concrete implementation."

**AI Response Excerpt**: 
"The Template Method pattern defines the skeleton of an algorithm in a base class, letting subclasses override specific steps without changing the overall structure. For ETL transformations, create an abstract DataTransformer with a final transform() method that calls preTransform(), applyTransformation(), and postTransform() in sequence. Subclasses implement applyTransformation() with specific business logic while inheriting the consistent workflow..."

## 4. Composition vs Inheritance Strategy
**Prompt**: "My ETLPipeline class needs to use a DataExtractor, DataTransformer, and DataLoader. Should I use inheritance or composition? What are the advantages of composition in this case?"

**AI Response Excerpt**: 
"Use composition (has-a relationship) rather than inheritance (is-a relationship) for your ETL pipeline. Your ETLPipeline is not a type of DataExtractor - it uses one. Composition provides flexibility to swap components at runtime, follows the principle 'favor composition over inheritance,' and allows you to combine different implementations easily. This makes your pipeline more modular and testable..."

## 5. Error Handling and File I/O Strategy
**Prompt**: "What's the best way to handle IOException and data parsing errors in an object-oriented ETL pipeline? Should each component handle its own errors or should there be centralized error handling?"

**AI Response Excerpt**: 
"Use a hybrid approach: let individual components throw specific exceptions (IOException for file operations, NumberFormatException for parsing), but handle them centrally in your ETLPipeline.execute() method. This maintains separation of concerns - each component focuses on its responsibility while the orchestrator handles error coordination and user communication. Use try-with-resources for proper file closure..."

## 6. Javadoc Documentation Assistance
**Prompt**: "Help me write comprehensive Javadocs for my object-oriented ETL classes following Oracle conventions. Include @param, @return, and @throws tags where appropriate, and explain how each class demonstrates OO principles."

**AI Response Excerpt**: 
"Structure your Javadocs to clearly explain both functionality and design patterns. For your Product class, mention that it 'Demonstrates encapsulation by bundling data fields with related methods.' For interfaces, explain their role in polymorphism. For the abstract DataTransformer, describe how it implements the Template Method pattern. Include specific @param descriptions, @return value explanations, and @throws for checked exceptions..."

## 7. Business Logic Encapsulation
**Prompt**: "My original Assignment 2 had business transformation logic scattered throughout static methods. How can I better encapsulate the business rules for product transformations (uppercase names, Electronics discounts, category changes) in an object-oriented design?"

**AI Response Excerpt**: 
"Encapsulate business logic within dedicated methods in your ProductBusinessTransformer class. Create private helper methods like applyElectronicsDiscount() and updateCategoryForPremiumElectronics() that handle specific rules. This encapsulation makes the business logic easier to understand, test, and modify. You can also add calculation methods directly to the Product class for price-related operations like getPriceRange()..."

## 8. Code Organization and Package Structure
**Prompt**: "I need to organize my object-oriented ETL classes under the package org.howard.edu.lsp.assignment3. What's the best way to structure the files and ensure proper Java conventions while demonstrating clear separation of concerns?"

**AI Response Excerpt**: 
"Follow these Java conventions: one public class per file, file name matches class name exactly, all classes in the same package directory. Organize by responsibility: Product.java for data model, DataExtractor.java/CSVDataExtractor.java for input handling, DataTransformer.java/ProductBusinessTransformer.java for business logic, DataLoader.java/CSVDataLoader.java for output, and ETLPipeline.java as the main orchestrator. This structure clearly shows the separation of concerns and makes the codebase maintainable..."