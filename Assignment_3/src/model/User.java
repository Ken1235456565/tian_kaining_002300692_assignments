/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tiankaining
 */
class User {
    private Profile profile;
    private String username;
    private String password;
    
    public User(Profile profile, String username, String password) {
        this.profile = profile;
        this.username = username;
        this.password = password;
    }
}

