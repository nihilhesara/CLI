# Ticket Booking System

This project simulates a ticket booking system with multiple vendors and customers. Vendors release tickets at a specified rate, and customers purchase tickets until there are no tickets left.

## Features

- Multiple vendors can release tickets concurrently.
- Multiple customers can purchase tickets concurrently.
- The system ensures that all vendors finish releasing tickets before customers start purchasing.
- The program saves the configuration details in JSON, text, and serialized formats.
- The program displays the number of tickets sold by each vendor and the number of tickets bought by each customer.

## Prerequisites

- Java 21 or later
- Maven

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/nihilhesara/CLI.git
    ```
2. Navigate to the project directory:
    ```sh
    cd ticket-booking-system
    ```
3. Build the project using Maven:
    ```sh
    mvn clean install
    ```

## Usage

1. Run the main program:
    ```sh
    mvn exec:java -Dexec.mainClass="CLI.Main"
    ```
2. Follow the prompts to enter the configuration details:
    ```
    Enter total number of tickets: 
    Enter maximum ticket capacity: 
    Enter number of vendors: 
    Enter tickets each vendor will release: 
    Enter ticket release rate: 
    Enter number of customers: 
    Enter tickets each customer will purchase: 
    ```


## Configuration Files

The program saves configuration details in three formats:
- `info.json`: JSON format
- `config.txt`: Plain text format
- `config.ser`: Serialized format

## Code Structure

- `Main.java`: The main entry point of the program. Handles user input and coordinates vendor and customer threads.
- `Vendor.java`: Represents a vendor that releases tickets.
- `Customer.java`: Represents a customer that purchases tickets.
- `TicketPool.java`: Manages the ticket pool and synchronizes access to tickets.
- `Config.java`: Handles configuration details and saves them in different formats.
