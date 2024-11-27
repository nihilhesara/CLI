package CLI;

import java.util.Scanner;

import static CLI.Config.getValidInput;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalTickets = getValidInput(input, "Enter total number of tickets: ");
        int numberOfVendors = getValidInput(input, "Enter number of vendors: ");
        int ticketsPerVendor = getValidInput(input, "Enter tickets each vendor will release: ");
        int releaseRate = getValidInput(input, "Enter ticket release rate: ");
        int numberOfCustomers = getValidInput(input, "Enter number of customers: ");
        int ticketsPerCustomer = getValidInput(input, "Enter tickets each customer will purchase: ");


        TicketPool ticketPool = new TicketPool(totalTickets);

        // Create and start vendor threads
        Thread[] vendorThreads = new Thread[numberOfVendors];
        for (int i = 0; i < numberOfVendors; i++) {
            Vendor vendor = new Vendor(ticketPool, ticketsPerVendor, releaseRate);
            vendorThreads[i] = new Thread(vendor, "Vendor-" + (i + 1));
            vendorThreads[i].start();
        }

        // Create and start customer threads
        Thread[] customerThreads = new Thread[numberOfCustomers];
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer(ticketPool, ticketsPerCustomer);
            customerThreads[i] = new Thread(customer, "Customer-" + (i + 1));
            customerThreads[i].start();
        }

        // Wait for all vendor threads to complete
        for (Thread thread : vendorThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wait for all customer threads to complete
        for (Thread thread : customerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All vendors and customers have finished their operations. Total available tickets: " + ticketPool.getAvailableTickets());
    }
}
