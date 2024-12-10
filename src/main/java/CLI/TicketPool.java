package CLI;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private int availableTickets;
    private final int maximumTicketCapacity;
    private final Lock lock = new ReentrantLock();
    private final int[] vendorTicketsSold;
    private final int[] customerTicketsBought;

    public TicketPool(int initialTickets, int maximumTicketCapacity, int numberOfVendors, int numberOfCustomers) {
        this.availableTickets = initialTickets;
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.vendorTicketsSold = new int[numberOfVendors];
        this.customerTicketsBought = new int[numberOfCustomers];
    }

    public void addTickets(int tickets, int vendorId) {
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

    public boolean removeTicket(int customerId) {
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
