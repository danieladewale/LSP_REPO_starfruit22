package org.howard.edu.lsp.midterm.question4;

/**
 * SmartThermostat is a concrete class that extends Device and implements Connectable.
 * Represents a smart thermostat that can control temperature and connect to a network.
 */
public class SmartThermostat extends Device implements Connectable {
    private double targetTemperature; // in Celsius
    private double currentTemperature; // in Celsius
    private String mode; // "HEAT", "COOL", "AUTO", "OFF"

    /**
     * Constructs a new SmartThermostat with the specified id and location.
     *
     * @param id the unique identifier for the thermostat
     * @param location the physical location of the thermostat
     */
    public SmartThermostat(String id, String location) {
        super(id, location);
        this.targetTemperature = 22.0; // Default comfortable temperature
        this.currentTemperature = 20.0;
        this.mode = "OFF";
    }

    /**
     * Sets the target temperature.
     *
     * @param temperature the target temperature in Celsius
     * @throws IllegalArgumentException if temperature is not reasonable (below -50 or above 50)
     */
    public void setTargetTemperature(double temperature) {
        if (temperature < -50 || temperature > 50) {
            throw new IllegalArgumentException("Temperature must be between -50 and 50 degrees Celsius");
        }
        this.targetTemperature = temperature;
    }

    /**
     * Sets the current temperature (simulates sensor reading).
     *
     * @param temperature the current temperature in Celsius
     */
    public void setCurrentTemperature(double temperature) {
        this.currentTemperature = temperature;
    }

    /**
     * Sets the operating mode of the thermostat.
     *
     * @param mode the mode ("HEAT", "COOL", "AUTO", or "OFF")
     * @throws IllegalArgumentException if mode is invalid
     */
    public void setMode(String mode) {
        if (!mode.equals("HEAT") && !mode.equals("COOL") &&
            !mode.equals("AUTO") && !mode.equals("OFF")) {
            throw new IllegalArgumentException("Mode must be HEAT, COOL, AUTO, or OFF");
        }
        this.mode = mode;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public String getMode() {
        return mode;
    }

    @Override
    public void performOperation() {
        if (isConnected()) {
            System.out.println("SmartThermostat " + getId() + " at " + getLocation() +
                             " is performing operation:");
            System.out.println("  Mode: " + mode);
            System.out.println("  Current Temperature: " + currentTemperature + "°C");
            System.out.println("  Target Temperature: " + targetTemperature + "°C");

            if (!mode.equals("OFF")) {
                if (currentTemperature < targetTemperature) {
                    System.out.println("  Action: Heating to reach target temperature");
                } else if (currentTemperature > targetTemperature) {
                    System.out.println("  Action: Cooling to reach target temperature");
                } else {
                    System.out.println("  Action: Maintaining temperature");
                }
            }
        } else {
            System.out.println("SmartThermostat " + getId() + " is not connected. Cannot perform operation.");
        }
    }

    @Override
    public void reset() {
        this.targetTemperature = 22.0;
        this.currentTemperature = 20.0;
        this.mode = "OFF";
        setConnected(false);
        System.out.println("SmartThermostat " + getId() + " has been reset to default state.");
    }

    @Override
    public void connect() {
        setConnected(true);
        setLastHeartbeatEpochSeconds(System.currentTimeMillis() / 1000);
        System.out.println("SmartThermostat " + getId() + " connected to the network.");
    }

    @Override
    public void disconnect() {
        setConnected(false);
        System.out.println("SmartThermostat " + getId() + " disconnected from the network.");
    }

    @Override
    public String toString() {
        return "SmartThermostat [id=" + getId() + ", location=" + getLocation() +
               ", connected=" + isConnected() + ", mode=" + mode +
               ", target=" + targetTemperature + "°C" +
               ", current=" + currentTemperature + "°C]";
    }
}
