package CLI;

import com.google.gson.Gson;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Config implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int totalNumberOfTickets;
    private int releaseRate;
    private int customerRate;
    private int maximumTicketCapacity;
    private int numberOfVendors;
    private int numberOfCustomers;
    private int ticketsPerVendor;
    private int ticketsPerCustomer;

    public Config(int totalNumberOfTickets, int releaseRate, int customerRate, int maximumTicketCapacity, int numberOfVendors, int numberOfCustomers, int ticketsPerVendor, int ticketsPerCustomer) {
        this.totalNumberOfTickets = totalNumberOfTickets;
        this.releaseRate = releaseRate;
        this.customerRate = customerRate;
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.numberOfVendors = numberOfVendors;
        this.numberOfCustomers = numberOfCustomers;
        this.ticketsPerVendor = ticketsPerVendor;
        this.ticketsPerCustomer = ticketsPerCustomer;
    }

    // Getters and setters
    public int getTotalNumberOfTickets() {
        return totalNumberOfTickets;
    }

    public void setTotalNumberOfTickets(int totalNumberOfTickets) {
        this.totalNumberOfTickets = totalNumberOfTickets;
    }

    public int getReleaseRate() {
        return releaseRate;
    }

    public void setReleaseRate(int releaseRate) {
        this.releaseRate = releaseRate;
    }

    public int getCustomerRate() {
        return customerRate;
    }

    public void setCustomerRate(int customerRate) {
        this.customerRate = customerRate;
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setMaximumTicketCapacity(int maximumTicketCapacity) {
        this.maximumTicketCapacity = maximumTicketCapacity;
    }

    public int getNumberOfVendors() {
        return numberOfVendors;
    }

    public void setNumberOfVendors(int numberOfVendors) {
        this.numberOfVendors = numberOfVendors;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public int getTicketsPerVendor() {
        return ticketsPerVendor;
    }

    public void setTicketsPerVendor(int ticketsPerVendor) {
        this.ticketsPerVendor = ticketsPerVendor;
    }

    public int getTicketsPerCustomer() {
        return ticketsPerCustomer;
    }

    public void setTicketsPerCustomer(int ticketsPerCustomer) {
        this.ticketsPerCustomer = ticketsPerCustomer;
    }

    @Override
    public String toString() {
        return "Config{" +
                "totalNumberOfTickets=" + totalNumberOfTickets +
                ", releaseRate=" + releaseRate +
                ", customerRate=" + customerRate +
                ", maximumTicketCapacity=" + maximumTicketCapacity +
                ", numberOfVendors=" + numberOfVendors +
                ", numberOfCustomers=" + numberOfCustomers +
                ", ticketsPerVendor=" + ticketsPerVendor +
                ", ticketsPerCustomer=" + ticketsPerCustomer +
                '}';
    }

    // Save configuration to a JSON file
    public void saveConfigToJson(String filePath) {
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(this, writer);
            System.out.println("Configuration saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save configuration to a plain text file
    public void saveConfigToText(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(this.toString());
            System.out.println("Configuration saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save configuration to a serialized file
    public void saveConfigToSerialized(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
            System.out.println("Configuration saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load configuration from a serialized file
    public static @Nullable Config loadConfigFromSerialized(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Config config = (Config) ois.readObject();
            System.out.println("Configuration loaded from " + filePath);
            return config;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getValidInput(Scanner input, String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                value = input.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next(); // Clear the invalid input
            }
        }
        return value;
    }
}
