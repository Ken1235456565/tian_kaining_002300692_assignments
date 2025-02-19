/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author tiankaining
 */
public class Book {
    private String serialNumber;  // Unique identifier for the book
    private String name;          // Title of the book
    private Date registeredDate;  // Date when the book was registered in the system
    private boolean isAvailable;  // Availability flag (true if available, false if rented)
    private int numberOfPages;    // Total number of pages in the book
    private String language;      // Language of the book (e.g., English, French)
    private Author author;        // The author of the book

    public Book(String serialNumber, String name, Date registeredDate, int numberOfPages, String language, Author author) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.registeredDate = registeredDate;
        this.isAvailable = true;  // By default, the book is available when registered
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.author = author;
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

    public boolean isIsAvailable() {
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
    
    
    
}
