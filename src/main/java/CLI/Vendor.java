package CLI;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsToRelease;
    private final int releaseRate;

    public Vendor(TicketPool ticketPool, int ticketsToRelease, int releaseRate) {
        this.ticketPool = ticketPool;
        this.ticketsToRelease = ticketsToRelease;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        for (int i = 0; i < ticketsToRelease; i++) {
            ticketPool.addTickets(releaseRate);
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
