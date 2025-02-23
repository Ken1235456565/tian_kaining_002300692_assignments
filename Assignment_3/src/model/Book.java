/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 * @author tiankaining
 */
public class Book {
    private static int bookCounter = 0;
    private String serialNumber;
    private String name;
    private Date registeredDate;
    private boolean isAvailable;
    private int numberOfPages;
    private String language;
    private Author author;
    private Library library;
    private double rentalPricePerDay;

    public Book(String serialNumber, String name, Date registeredDate, int numberOfPages, String language, Author author) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.registeredDate = registeredDate;
        this.isAvailable = true;  // By default, the book is available when registered
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.author = author;
        this.rentalPricePerDay = 2.0; // Default rental price
        
        // Add this book to author's list of books
        author.addBook(this);
    }
    
    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }
    
    public boolean checkAvailability() {
        return isAvailable;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
    
    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }
}
