package CLI;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsToRelease;
    private final int releaseRate;
    private final int vendorId;

    // Vendor constructor to get values through an object
    public Vendor(TicketPool ticketPool, int ticketsToRelease, int releaseRate, int vendorId) {
        this.ticketPool = ticketPool;
        this.ticketsToRelease = ticketsToRelease;
        this.releaseRate = releaseRate;
        this.vendorId = vendorId;
    }

    // run() method to run tickets calls add ticket method in ticket pool
    @Override
    public void run() {
        for (int i = 0; i < ticketsToRelease; i++) {
            ticketPool.addTickets(releaseRate, vendorId);
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
