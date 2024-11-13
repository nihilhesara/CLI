package CLI;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsToPurchase;

    public Customer(TicketPool ticketPool, int ticketsToPurchase) {
        this.ticketPool = ticketPool;
        this.ticketsToPurchase = ticketsToPurchase;
    }

    @Override
    public void run() {
        for (int i = 0; i < ticketsToPurchase; i++) {
            ticketPool.removeTicket();
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
