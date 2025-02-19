/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tiankaining
 */
public class APP {
    private Branch branch;                 
    private UserDirectory userDirectory;   
    private CustomerDirectory customerDirectory; 

    // Constructor to initialize the APP with required directories
    public APP(Branch branch, UserDirectory userDirectory, CustomerDirectory customerDirectory) {
        this.branch = branch;
        this.userDirectory = userDirectory;
        this.customerDirectory = customerDirectory;
    }
}
