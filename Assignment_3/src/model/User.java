/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class User {
    private Profile profile;
    private String username;
    private String password;
    
    public User(Profile profile, String username, String password) {
        this.profile = profile;
        this.username = username;
        this.password = password;
    }
    
    public Profile getProfile() {
        return profile;
    }
    
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    // 可能需要添加的方法：确保用于显示的字符串清晰
    @Override
    public String toString() {
        return username;
    }
}
