package org.example;

import com.google.gson.Gson;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class Main {
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

        // Create a data class to hold the input values
        TicketInfo ticketInfo = new TicketInfo(noOfTickets, releaseRate, customerRate, maxTicketCapacity);

        // Convert the TicketInfo object to JSON
        Gson gson = new Gson();
        String json = gson.toJson(ticketInfo);

        // Print the JSON object to console
        System.out.println(json);

        // Write the JSON object to a file
        try {
            Files.write(Paths.get("info.json"), json.getBytes(), StandardOpenOption.CREATE);
            System.out.println("JSON data written to info.json file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
