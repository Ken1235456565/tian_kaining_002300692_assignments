/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tiankaining
 */
public class Role {
    private String sysadmins;
    private String branchManagers;
    private String customers;

    // Constructor to initialize the Role object with different user roles
    public Role(String sysadmins, String branchManagers, String customers) {
        this.sysadmins = sysadmins;
        this.branchManagers = branchManagers;
        this.customers = customers;
    }
}
