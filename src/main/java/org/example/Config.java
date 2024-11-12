package org.example;

public class Config {
    public static final String JSON_LIB_PATH = "path/to/json-20210307.jar";

    // You can add more configurations here
    public static final int TOTAL_TICKETS = 100;
    public static final double RELEASE_RATE = 5.0;
    public static final double CUSTOMER_RATE = 3.0;
    public static final double MAX_TICKET_CAPACITY = 50.0;

    // Method to print all configurations
    public static void printConfigurations() {
        System.out.println("JSON Library Path: " + JSON_LIB_PATH);
        System.out.println("Total Tickets: " + TOTAL_TICKETS);
        System.out.println("Release Rate: " + RELEASE_RATE);
        System.out.println("Customer Rate: " + CUSTOMER_RATE);
        System.out.println("Max Ticket Capacity: " + MAX_TICKET_CAPACITY);
    }
}

