package org.howard.edu.lsp.midterm.question4;

/**
 * Interface for devices that can connect to and disconnect from a network.
 * Implementing classes must provide connection management functionality.
 */
public interface Connectable {
    /**
     * Establishes a connection to the network or server.
     */
    void connect();

    /**
     * Terminates the connection to the network or server.
     */
    void disconnect();

    /**
     * Checks if the device is currently connected.
     *
     * @return true if connected, false otherwise
     */
    boolean isConnected();
}
