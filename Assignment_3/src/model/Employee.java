/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * author tiankaining
 */
public class Employee extends User {
    private String employeeID;  // Unique identifier for the employee
    private int experience;     // Years of experience

    // Constructor to initialize Employee details
    public Employee(Profile profile, String username, String password, String employeeID, int experience) {
        super(profile, username, password);
        this.employeeID = employeeID;
        this.experience = experience;
    }
    
    public String getEmployeeID() {
        return employeeID;
    }
    
    public int getExperience() {
        return experience;
    }
}

