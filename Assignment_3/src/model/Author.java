/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author tiankaining
 */
public class Author {
    private String authorID;   // Unique identifier for the author
    private String name;       // Author's name
    private Date birthDate;    // Author's date of birth
    private String nationality; // Author's nationality
    private List<Book> books;  // List of books written by this author

    public Author(String authorID, String name, Date birthDate, String nationality) {
        this.authorID = authorID;
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.books = new ArrayList<>();
    }

    
}
