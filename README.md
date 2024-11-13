# Ticket Management CLI

This project simulates a multi-threaded environment for ticket management where multiple vendors release tickets and multiple customers purchase tickets concurrently.

## Features

- **Ticket Pool**: Manages a pool of tickets with thread-safe methods for adding and removing tickets.
- **Vendors**: Simulate vendors releasing tickets to the pool concurrently.
- **Customers**: Simulate customers purchasing tickets from the pool concurrently.
- **Thread-Safe**: Ensures safe concurrent access to the ticket pool using locks.

## Classes

### TicketPool

- Manages the pool of tickets.
- Uses `ReentrantLock` for thread-safe operations.
- Methods:
  - `addTickets(int tickets)`: Adds the specified number of tickets to the pool.
  - `removeTicket()`: Removes a ticket from the pool if available.
  - `getAvailableTickets()`: Returns the number of available tickets.

### Vendor

- Implements `Runnable` interface.
- Releases tickets to the pool at a specified rate.
- Constructor parameters:
  - `TicketPool ticketPool`: The shared ticket pool.
  - `int ticketsToRelease`: Number of tickets to release.
  - `int releaseRate`: Rate at which tickets are released.

### Customer

- Implements `Runnable` interface.
- Purchases tickets from the pool.
- Constructor parameters:
  - `TicketPool ticketPool`: The shared ticket pool.
  - `int ticketsToPurchase`: Number of tickets to purchase.

### Main

- Takes user input for the number of tickets, vendors, release rate, customers, and purchase rate.
- Creates and starts vendor and customer threads.
- Waits for all threads to complete using `thread.join()`.

## How to Run

1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd <repository-directory>
