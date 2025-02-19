/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiankaining
 */
public class BookCatalog {
    private List<Book> books;
    
    public BookCatalog() {
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }

    void setAvailable(boolean b) {
        return Book.isAvailable();
    }

    boolean isAvailable() {
        return Book.isAvailable();
    }
}
