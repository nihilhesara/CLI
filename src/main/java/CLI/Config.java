package CLI;

//import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class Config implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int totalNumberOfTickets;
    private double releaseRate;
    private double customerRate;
    private double maximumTicketCapacity;

    public Config(int totalNumberOfTickets, double releaseRate, double customerRate, double maximumTicketCapacity) {
        this.totalNumberOfTickets = totalNumberOfTickets;
        this.releaseRate = releaseRate;
        this.customerRate = customerRate;
        this.maximumTicketCapacity = maximumTicketCapacity;
    }

    // Getters and setters
    public int getTotalNumberOfTickets() {
        return totalNumberOfTickets;
    }

    public void setTotalNumberOfTickets(int totalNumberOfTickets) {
        this.totalNumberOfTickets = totalNumberOfTickets;
    }

    public double getReleaseRate() {
        return releaseRate;
    }

    public void setReleaseRate(double releaseRate) {
        this.releaseRate = releaseRate;
    }

    public double getCustomerRate() {
        return customerRate;
    }

    public void setCustomerRate(double customerRate) {
        this.customerRate = customerRate;
    }

    public double getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setMaximumTicketCapacity(double maximumTicketCapacity) {
        this.maximumTicketCapacity = maximumTicketCapacity;
    }

    @Override
    public String toString() {
        return "Config{" +
                "totalNumberOfTickets=" + totalNumberOfTickets +
                ", releaseRate=" + releaseRate +
                ", customerRate=" + customerRate +
                ", maximumTicketCapacity=" + maximumTicketCapacity +
                '}';
    }

    /* Save configuration to a JSON file
    public void saveConfigToJson(String filePath) {
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(this, writer);
            System.out.println("Configuration saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

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
    public static Config loadConfigFromSerialized(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Config config = (Config) ois.readObject();
            System.out.println("Configuration loaded from " + filePath);
            return config;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
