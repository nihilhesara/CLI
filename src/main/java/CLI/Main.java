package CLI;

import java.util.Scanner;

public class Main {
    // Main method for testing
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter total number of tickets: ");
        int noOfTickets = input.nextInt();

        System.out.print("Enter ticket release rate: ");
        double releaseRate = input.nextDouble();

        System.out.print("Enter customer retrieval rate: ");
        double customerRate = input.nextDouble();

        System.out.print("Enter maximum ticket capacity: ");
        double maxTicketCapacity = input.nextDouble();

        // Create a Config object with the input values
        Config config = new Config(noOfTickets, releaseRate, customerRate, maxTicketCapacity);

        // File paths
        String jsonFilePath = "config.json";
        String textFilePath = "config.txt";
        String serializedFilePath = "config.ser";

        // Save the configuration to different files
        //config.saveConfigToJson(jsonFilePath);
        config.saveConfigToText(textFilePath);
        config.saveConfigToSerialized(serializedFilePath);

        // Load the configuration from the serialized file
        Config loadedConfig = Config.loadConfigFromSerialized(serializedFilePath);

        // Print the loaded configuration
        if (loadedConfig != null) {
            System.out.println("Loaded configuration: " + loadedConfig);
        }
    }
}
