/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;


public class AuthorDirectory {
    private List<Author> authors;
    
    public AuthorDirectory() {
        this.authors = new ArrayList<>();
    }
    
    public void addAuthor(Author author) {
        authors.add(author);
    }
    
    public List<Author> getAuthors() {
        return authors;
    }
    
    public Author findAuthorById(String authorId) {
        for (Author author : authors) {
            if (author.getAuthorId().equals(authorId)) {
                return author;
            }
        }
        return null;
    }
}

