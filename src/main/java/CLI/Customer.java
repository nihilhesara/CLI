package CLI;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsToPurchase;
    private final int customerId;

    // Customer constructor to get values through an object
    public Customer(TicketPool ticketPool, int ticketsToPurchase, int customerId) {
        this.ticketPool = ticketPool;
        this.ticketsToPurchase = ticketsToPurchase;
        this.customerId = customerId;
    }

    // run() method to run tickets calls remove ticket method in ticket pool
    @Override
    public void run() {
        for (int i = 0; i < ticketsToPurchase; i++) {
            if (!ticketPool.removeTicket(customerId)) {
                break; // Stop if no tickets are available
            }
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
