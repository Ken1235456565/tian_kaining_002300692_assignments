/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tiankaining
 */
public class Author {
    private static int authorCounter = 0;
    private String authorId;
    private String name;
    private Date birthDate;
    private String nationality;
    private List<Book> books;  // List of books written by this author

    public Author(String authorId, String name, Date birthDate, String nationality) {
        this.authorId = authorId;
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.books = new ArrayList<>();
    }
    
    // Methods
    public void addBook(Book book) {
        books.add(book);
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    public String getAuthorId() {
        return authorId;
    }
    
    public String getName() {
        return name;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
