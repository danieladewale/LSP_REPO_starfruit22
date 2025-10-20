# References and Citations - Question 4: Smart Campus Device System

## AI-Generated Content

### Claude AI Assistance
I used Claude (Anthropic's AI assistant) via Claude Code to help implement this assignment.

**Tool Used**: Claude Code (VS Code Extension)
**Model**: Claude Sonnet 4.5
**Date**: October 20, 2025

**How Claude was used**:
- Assisted with designing the class hierarchy and interface structure
- Helped implement the abstract Device base class with common functionality
- Assisted with creating the Connectable interface
- Helped implement SmartLight and SmartThermostat concrete classes
- Provided guidance on object-oriented design principles (inheritance, polymorphism, abstraction)
- Assisted with writing comprehensive Javadoc comments
- Helped create the Main class to demonstrate all OOP concepts
- Reviewed code for proper encapsulation and method implementation

**Key implementations assisted by Claude**:
1. **Device.java** (Abstract base class):
   - Common properties: id, location, lastHeartbeatEpochSeconds, connected
   - Constructor with validation
   - Abstract methods: performOperation() and reset()
   - Getters and setters

2. **Connectable.java** (Interface):
   - Methods: connect(), disconnect(), isConnected()
   - Interface contract for network-capable devices

3. **SmartLight.java** (Concrete class):
   - Extends Device, implements Connectable
   - Properties: isOn, brightness (0-100)
   - Methods: turnOn(), setBrightness()
   - Override implementations for all abstract methods

4. **SmartThermostat.java** (Concrete class):
   - Extends Device, implements Connectable
   - Properties: targetTemperature, currentTemperature, mode
   - Methods: setTargetTemperature(), setCurrentTemperature(), setMode()
   - Override implementations for all abstract methods

5. **Main.java** (Demonstration class):
   - Demonstrates polymorphism with Device array
   - Shows interface implementation with connectivity
   - Exception handling examples
   - Comprehensive testing of all functionality

---

## Internet Resources

### Documentation and Tutorials
- **Title**: Java Abstract Classes and Interfaces
  - **URL**: https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
  - **Date Accessed**: 2025-10-20
  - **Purpose**: Referenced for understanding abstract classes and interface implementation

- **Title**: Java Inheritance
  - **URL**: https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
  - **Date Accessed**: 2025-10-20
  - **Purpose**: Referenced for class inheritance patterns and the super() constructor

- **Title**: Java Polymorphism
  - **URL**: https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
  - **Date Accessed**: 2025-10-20
  - **Purpose**: Referenced for understanding polymorphic behavior with Device array

---

## Code References

No external code snippets from Stack Overflow or forums were used. All code was written with Claude AI assistance as documented above.

---

## Design Patterns and Architecture

- **Pattern**: Template Method Pattern
  - **How it was used**: The Device abstract class defines the template with abstract methods (performOperation, reset) that concrete classes must implement
  - **Purpose**: Provides a common interface while allowing subclasses to define specific behavior

- **Pattern**: Interface Segregation
  - **How it was used**: Connectable interface separates connectivity concerns from base device functionality
  - **Purpose**: Allows devices to implement network capabilities without forcing all Device subclasses to be connectable

---

## Other Sources

- **Source**: Course lecture materials
  - **Topic**: Object-Oriented Programming - Inheritance, Polymorphism, and Abstraction
  - **What was referenced**: Class hierarchy design principles and OOP best practices

- **Source**: Course lecture materials
  - **Topic**: Java Interfaces
  - **What was referenced**: Interface design and implementation patterns

---

## Declaration
I declare that all sources used in this assignment have been properly documented above. I used Claude AI (via Claude Code) to assist with the implementation as detailed in the AI-Generated Content section above.

**Student**: Daniel Adewale
**Date**: October 20, 2025
