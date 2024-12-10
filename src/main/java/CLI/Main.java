package CLI;

import java.util.Scanner;

import static CLI.Config.getValidInput;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalTickets = getValidInput(input, "Enter total number of tickets: ");
        int maximumTicketCapacity = getValidInput(input, "Enter maximum ticket capacity: ");
        int numberOfVendors = getValidInput(input, "Enter number of vendors: ");
        int ticketsPerVendor = getValidInput(input, "Enter tickets each vendor will release: ");
        int releaseRate = getValidInput(input, "Enter ticket release rate: ");
        int numberOfCustomers = getValidInput(input, "Enter number of customers: ");
        int ticketsPerCustomer = getValidInput(input, "Enter tickets each customer will purchase: ");

        if (maximumTicketCapacity <= totalTickets) {
            System.out.println("Maximum ticket capacity must be higher than total number of tickets.");
            return;
        }

        TicketPool ticketPool = new TicketPool(totalTickets, maximumTicketCapacity, numberOfVendors, numberOfCustomers);

        Config config = new Config(totalTickets, releaseRate, ticketsPerCustomer, maximumTicketCapacity, numberOfVendors, numberOfCustomers, ticketsPerVendor, ticketsPerCustomer);
        config.saveConfigToJson("info.json");
        config.saveConfigToText("config.txt");
        config.saveConfigToSerialized("config.ser");

        // Create and start vendor threads
        Thread[] vendorThreads = new Thread[numberOfVendors];
        for (int i = 0; i < numberOfVendors; i++) {
            Vendor vendor = new Vendor(ticketPool, ticketsPerVendor, releaseRate, i);
            vendorThreads[i] = new Thread(vendor, "Vendor-" + (i + 1));
            vendorThreads[i].start();
        }

        // Wait for all vendor threads to complete
        for (Thread thread : vendorThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All vendors have finished releasing tickets.");

        // Create and start customer threads
        Thread[] customerThreads = new Thread[numberOfCustomers];
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer(ticketPool, ticketsPerCustomer, i);
            customerThreads[i] = new Thread(customer, "Customer-" + (i + 1));
            customerThreads[i].start();
        }

        // Wait for all customer threads to complete
        for (Thread thread : customerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All customers have finished purchasing tickets.");
        System.out.println("Total available tickets: " + ticketPool.getAvailableTickets());
        System.out.println("Tickets sold by each vendor:");
        int[] vendorTicketsSold = ticketPool.getVendorTicketsSold();
        for (int i = 0; i < vendorTicketsSold.length; i++) {
            System.out.println("Vendor-" + (i + 1) + ": " + vendorTicketsSold[i]);
        }
        System.out.println("Tickets bought by each customer:");
        int[] customerTicketsBought = ticketPool.getCustomerTicketsBought();
        for (int i = 0; i < customerTicketsBought.length; i++) {
            System.out.println("Customer-" + (i + 1) + ": " + customerTicketsBought[i]);
        }
    }
}
