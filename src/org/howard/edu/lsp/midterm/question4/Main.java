package org.howard.edu.lsp.midterm.question4;

/**
 * Main class to demonstrate the smart campus device system.
 * Shows class inheritance (Device base class extended by SmartLight and SmartThermostat)
 * and interface implementation (Connectable interface).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart Campus Device System Demo ===\n");

        // Create SmartLight devices
        SmartLight libraryLight = new SmartLight("LIGHT-001", "Library");
        SmartLight classroomLight = new SmartLight("LIGHT-002", "Classroom A");

        // Create SmartThermostat devices
        SmartThermostat dormThermostat = new SmartThermostat("THERMO-001", "Dormitory");
        SmartThermostat labThermostat = new SmartThermostat("THERMO-002", "Computer Lab");

        // Demonstrate connectivity
        System.out.println("--- Connecting Devices ---");
        libraryLight.connect();
        classroomLight.connect();
        dormThermostat.connect();
        labThermostat.connect();
        System.out.println();

        // Configure and operate SmartLights
        System.out.println("--- Configuring SmartLights ---");
        libraryLight.turnOn(true);
        libraryLight.setBrightness(75);
        System.out.println(libraryLight);

        classroomLight.turnOn(true);
        classroomLight.setBrightness(100);
        System.out.println(classroomLight);
        System.out.println();

        // Configure and operate SmartThermostats
        System.out.println("--- Configuring SmartThermostats ---");
        dormThermostat.setMode("AUTO");
        dormThermostat.setTargetTemperature(23.0);
        dormThermostat.setCurrentTemperature(20.5);
        System.out.println(dormThermostat);

        labThermostat.setMode("COOL");
        labThermostat.setTargetTemperature(21.0);
        labThermostat.setCurrentTemperature(25.0);
        System.out.println(labThermostat);
        System.out.println();

        // Perform operations on all devices
        System.out.println("--- Performing Device Operations ---");
        libraryLight.performOperation();
        System.out.println();
        classroomLight.performOperation();
        System.out.println();
        dormThermostat.performOperation();
        System.out.println();
        labThermostat.performOperation();
        System.out.println();

        // Demonstrate polymorphism - treating devices as Device objects
        System.out.println("--- Demonstrating Polymorphism ---");
        Device[] devices = {libraryLight, classroomLight, dormThermostat, labThermostat};
        System.out.println("All connected devices:");
        for (Device device : devices) {
            System.out.println("  " + device.getId() + " at " + device.getLocation() +
                             " - Connected: " + device.isConnected());
        }
        System.out.println();

        // Demonstrate disconnection
        System.out.println("--- Disconnecting Library Light ---");
        libraryLight.disconnect();
        libraryLight.performOperation(); // Should show not connected message
        System.out.println();

        // Demonstrate reset functionality
        System.out.println("--- Resetting Devices ---");
        classroomLight.reset();
        dormThermostat.reset();
        System.out.println();

        // Test exception handling
        System.out.println("--- Testing Exception Handling ---");
        try {
            new SmartLight("", "Some Location");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception creating invalid device: " + e.getMessage());
        }

        try {
            classroomLight.setBrightness(150); // Invalid brightness
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception setting invalid brightness: " + e.getMessage());
        }

        try {
            dormThermostat.setMode("INVALID"); // Invalid mode
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception setting invalid mode: " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
