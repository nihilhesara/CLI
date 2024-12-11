package CLI;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private int availableTickets;
    private final int maximumTicketCapacity;
    private final Lock lock = new ReentrantLock();
    private final int[] vendorTicketsSold;
    private final int[] customerTicketsBought;

    // Ticket pool constructor to get vales from the object
    public TicketPool(int initialTickets, int maximumTicketCapacity, int numberOfVendors, int numberOfCustomers) {
        this.availableTickets = initialTickets;
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.vendorTicketsSold = new int[numberOfVendors];
        this.customerTicketsBought = new int[numberOfCustomers];
    }

    // Adding tickets to the ticket pool array
    public void addTickets(int tickets, int vendorId) {
        /* Use thread lock to use one thread at a time and check the maximum capacity exclude or not
           Vendors can add tickets to the system*/
        lock.lock();
        try {
            int newTotal = availableTickets + tickets;
            if (newTotal <= maximumTicketCapacity) {
                availableTickets = newTotal;
                vendorTicketsSold[vendorId] += tickets;
                System.out.println(Thread.currentThread().getName() + " added " + tickets + " tickets. Total available: " + availableTickets);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to add " + tickets + " tickets but exceeded capacity. Total available: " + availableTickets);
            }
        } finally {
            lock.unlock();
        }
    }

    // remove tickets from the ticket pool
    public boolean removeTicket(int customerId) {
        /* Use thread lock to use one thread at a time and check weather each customer buy their own tickets */
        lock.lock();
        try {
            if (availableTickets > 0) {
                availableTickets--;
                customerTicketsBought[customerId]++;
                System.out.println(Thread.currentThread().getName() + " purchased a ticket. Tickets left: " + availableTickets);
                return true;
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to purchase a ticket but none are available.");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public int[] getVendorTicketsSold() {
        return vendorTicketsSold;
    }

    public int[] getCustomerTicketsBought() {
        return customerTicketsBought;
    }
}
