/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;


public class UserDirectory {
    private List<User> users; 

    // Constructor initializes the user list
    public UserDirectory() {
        this.users = new ArrayList<>();
    }
    
    public void addUser(User user) {
        users.add(user);
    }
    
    public List<User> getUsers() {
        return users;
    }
    
    // 修复可能存在的问题：确保正确比较用户名
    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername() != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public void removeUser(User user) {
        users.remove(user);
    }
}

