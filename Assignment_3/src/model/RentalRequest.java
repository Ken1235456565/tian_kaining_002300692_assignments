/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class RentalRequest {
    private static int requestCounter = 0;
    private String requestId;
    private double price;
    private String status;  // Enum values as String: PENDING, APPROVED, REJECTED, RETURNED
    private int rentDuration;  // in days
    private Date requestDate;
    private Date returnDate;
    private Customer customer;
    private Book book;
    private Library library;

    // Constructor
    public RentalRequest(Customer customer, Book book, Library library, int rentDuration, double price) {
        this.requestId = generateRequestId();
        this.status = "PENDING";
        this.requestDate = new Date(); // Default to current date
        this.rentDuration = rentDuration;
        this.returnDate = calculateReturnDate();
        this.customer = customer;
        this.book = book;
        this.library = library;
        this.price = price;
        
        // Mark the book as unavailable
        book.setAvailability(false);
    }

    private String generateRequestId() {
        return "REQ-" + (++requestCounter);
    }

    private Date calculateReturnDate() {
        long returnTime = requestDate.getTime() + (long) rentDuration * 24 * 60 * 60 * 1000;
        return new Date(returnTime);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        
        // If the status is RETURNED, make the book available again
        if (newStatus.equals("RETURNED")) {
            book.setAvailability(true);
        }
    }

    public void calculatePrice() {
        // Price is calculated based on rent duration
        this.price = rentDuration * book.getRentalPricePerDay();
    }

    public boolean isOverdue() {
        Date currentDate = new Date();
        return currentDate.after(returnDate) && !status.equals("RETURNED");
    }

    // Getters and Setters
    public String getRequestId() {
        return requestId;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public int getRentDuration() {
        return rentDuration;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public Library getLibrary() {
        return library;
    }
}

