package org.howard.edu.lsp.midterm.question4;

/**
 * Abstract base class representing a smart campus device.
 * This class provides common functionality for all devices including
 * identification, location tracking, heartbeat monitoring, and connection status.
 */
public abstract class Device {
    private String id;
    private String location;
    private long lastHeartbeatEpochSeconds;
    private boolean connected;

    // PROVIDED CONSTRUCTOR
    public Device(String id, String location) {
        if (id == null || id.isEmpty() || location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Invalid id or location");
        }
        this.id = id;
        this.location = location;
        this.lastHeartbeatEpochSeconds = 0;
        this.connected = false;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public long getLastHeartbeatEpochSeconds() {
        return lastHeartbeatEpochSeconds;
    }

    public boolean isConnected() {
        return connected;
    }

    /**
     * Sets the connection status of the device.
     *
     * @param connected true if the device is connected, false otherwise
     */
    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    /**
     * Updates the last heartbeat timestamp to the current time.
     *
     * @param epochSeconds the epoch time in seconds
     */
    public void setLastHeartbeatEpochSeconds(long epochSeconds) {
        this.lastHeartbeatEpochSeconds = epochSeconds;
    }

    /**
     * Abstract method to perform device-specific operations.
     * Each concrete device class must implement this method.
     */
    public abstract void performOperation();

    /**
     * Abstract method to reset the device to its default state.
     * Each concrete device class must implement this method.
     */
    public abstract void reset();

    @Override
    public String toString() {
        return "Device [id=" + id + ", location=" + location +
               ", connected=" + connected +
               ", lastHeartbeat=" + lastHeartbeatEpochSeconds + "]";
    }
}
