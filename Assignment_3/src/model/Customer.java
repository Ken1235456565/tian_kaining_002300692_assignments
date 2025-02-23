/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;


public class Customer {
    private static int customerCounter = 0;
    private String customerId;
    private User user;
    private List<RentalRequest> rentalHistory;
    
    public Customer(String customerId, User user) {
        this.customerId = customerId;
        this.user = user;
        this.rentalHistory = new ArrayList<>();
    }
    
    // Methods
    public RentalRequest placeRentalRequest(Book book, Library library, int rentDuration, double price) {
        if (!book.isAvailable()) {
            return null; // Book is not available
        }
        
        RentalRequest request = new RentalRequest(this, book, library, rentDuration, price);
        rentalHistory.add(request);
        return request;
    }
    
    public List<RentalRequest> viewRentalHistory() {
        return rentalHistory;
    }
    
    public List<Book> viewAvailableBooks(Library library) {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    
    public String getCustomerId() {
        return customerId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void addRentalRequest(RentalRequest request) {
        rentalHistory.add(request);
    }
    
    @Override
    public String toString() {
        return user.getUsername();
    }
}

