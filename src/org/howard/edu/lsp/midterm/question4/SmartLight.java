package org.howard.edu.lsp.midterm.question4;

/**
 * SmartLight is a concrete class that extends Device and implements Connectable.
 * Represents a smart light bulb that can be turned on/off, dimmed, and connected to a network.
 */
public class SmartLight extends Device implements Connectable {
    private boolean isOn;
    private int brightness; // brightness level 0-100

    /**
     * Constructs a new SmartLight with the specified id and location.
     *
     * @param id the unique identifier for the light
     * @param location the physical location of the light
     */
    public SmartLight(String id, String location) {
        super(id, location);
        this.isOn = false;
        this.brightness = 0;
    }

    /**
     * Turns the light on or off.
     *
     * @param on true to turn on, false to turn off
     */
    public void turnOn(boolean on) {
        this.isOn = on;
        if (!on) {
            this.brightness = 0;
        } else if (this.brightness == 0) {
            this.brightness = 50; // Default brightness when turned on
        }
    }

    /**
     * Sets the brightness level of the light.
     *
     * @param brightness the brightness level (0-100)
     * @throws IllegalArgumentException if brightness is not between 0 and 100
     */
    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100");
        }
        this.brightness = brightness;
        if (brightness > 0) {
            this.isOn = true;
        } else {
            this.isOn = false;
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public void performOperation() {
        if (isConnected()) {
            System.out.println("SmartLight " + getId() + " at " + getLocation() +
                             " is performing operation: Light is " + (isOn ? "ON" : "OFF") +
                             " with brightness " + brightness + "%");
        } else {
            System.out.println("SmartLight " + getId() + " is not connected. Cannot perform operation.");
        }
    }

    @Override
    public void reset() {
        this.isOn = false;
        this.brightness = 0;
        setConnected(false);
        System.out.println("SmartLight " + getId() + " has been reset to default state.");
    }

    @Override
    public void connect() {
        setConnected(true);
        setLastHeartbeatEpochSeconds(System.currentTimeMillis() / 1000);
        System.out.println("SmartLight " + getId() + " connected to the network.");
    }

    @Override
    public void disconnect() {
        setConnected(false);
        System.out.println("SmartLight " + getId() + " disconnected from the network.");
    }

    @Override
    public String toString() {
        return "SmartLight [id=" + getId() + ", location=" + getLocation() +
               ", connected=" + isConnected() + ", isOn=" + isOn +
               ", brightness=" + brightness + "%]";
    }
}
