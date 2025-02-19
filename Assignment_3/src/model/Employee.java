/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tiankaining
 */
public class Employee {
    private String employeeID;  // Unique identifier for the employee
    private int experience;     // Years of experience

    // Constructor to initialize Employee details
    public Employee(Profile profile, String username, String password, String email, String employeeID, int experience) {
        this.employeeID = employeeID;
        this.experience = experience;
    }
    
}
