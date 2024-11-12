package org.example;

// Data class to hold the ticket information
public class TicketInfo {
    private int totalNumberOfTickets;
    private double releaseRate;
    private double customerRate;
    private double maximumTicketCapacity;

    public TicketInfo(int totalNumberOfTickets, double releaseRate, double customerRate, double maximumTicketCapacity) {
        this.totalNumberOfTickets = totalNumberOfTickets;
        this.releaseRate = releaseRate;
        this.customerRate = customerRate;
        this.maximumTicketCapacity = maximumTicketCapacity;
    }

    // Getters and setters (if needed)
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
}
