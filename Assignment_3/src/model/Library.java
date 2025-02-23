/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String libraryName;
    private String buildingNo;
    private List<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.buildingNo = "BLD" + Math.round(Math.random() * 1000);
        this.books = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
    
    public String getBuildingNo() {
        return buildingNo;
    }
    
    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }
    
    public void addBook(Book book) {
        books.add(book);
        book.setLibrary(this);
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    public Book findBookBySerialNumber(String serialNumber) {
        for (Book book : books) {
            if (book.getSerialNumber().equals(serialNumber)) {
                return book;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return libraryName;
    }
}



