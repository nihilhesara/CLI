package CLI;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private int availableTickets;
    private final Lock lock = new ReentrantLock();

    public TicketPool(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public void addTickets(int tickets) {
        lock.lock();
        try {
            availableTickets += tickets;
            System.out.println(Thread.currentThread().getName() + " added " + tickets + " tickets. Total available: " + availableTickets);
        } finally {
            lock.unlock();
        }
    }

    public boolean removeTicket() {
        lock.lock();
        try {
            if (availableTickets > 0) {
                availableTickets--;
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
}
