package org.example;

import org.json.JSONObject;
import java.util.Scanner;

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

        // Create a JSON object and populate it with the entered data
        JSONObject json = new JSONObject();
        json.put("total_number_of_tickets", noOfTickets);
        json.put("release_rate", releaseRate);
        json.put("customer_rate", customerRate);
        json.put("maximum_ticket_capacity", maxTicketCapacity);

        // Print the JSON object
        System.out.println(json.toString(4)); // 4 is the number of spaces for indentation
    }
}
