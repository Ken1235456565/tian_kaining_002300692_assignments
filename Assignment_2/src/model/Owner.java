/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.time.LocalDate;

/**
 *
 * @author Rushabh
 */
public class Owner {
    private int ownerID;
    private String ownerFirstName;
    private String ownerLastName;
    private Vehicle vehicle;
    private LocalDate serviceDate;

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        if (ownerFirstName == null || ownerFirstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        if (ownerLastName == null || ownerLastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        this.ownerLastName = ownerLastName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        this.vehicle = vehicle;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }
    
    public Owner() {
        
    }
    
    //constructor
    public Owner(int ownerID, String ownerFirstName, String ownerLastName, LocalDate serviceDate) {
        this.ownerID = ownerID;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.serviceDate = serviceDate;
    }
    
    public String getOwnerName() {
        return ownerFirstName + " " + ownerLastName;
    }
    
    //setOwnerName() 方法（不允许为空）
    public void setOwnerName(String fullName) {
        if (fullName != null && fullName.contains(" ")) {
            String[] parts = fullName.split(" ", 2); // 以第一个空格拆分
            this.ownerFirstName = parts[0];
            this.ownerLastName = parts[1];
        } else {
            this.ownerFirstName = fullName; // 只有一个名字
            this.ownerLastName = ""; // 姓氏为空
        }
    }
    
    
    
    @Override
    public String toString() {
        return ownerFirstName + " " + ownerLastName;
    }
}
