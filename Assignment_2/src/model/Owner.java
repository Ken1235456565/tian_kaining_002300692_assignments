/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.time.LocalDate;
import javax.swing.ImageIcon;

/**
 *
 * @author Rushabh
 */
public class Owner {
    private int ownerID;
    private String ownerFirstName;
    private String ownerLastName;
    private VehicleCatalog vehicleCatalog;
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
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public VehicleCatalog getVehicleCatalog() {
        return vehicleCatalog;
    }

    public void setVehicleCatalog(VehicleCatalog vehicleCatalog) {
        this.vehicleCatalog = vehicleCatalog;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }
    
    public Owner() {
        this.vehicleCatalog = new VehicleCatalog(); //each Owner have VehicleCatalog!
    }
    
    //constructor
    public Owner(int ownerID, String ownerFirstName, String ownerLastName, LocalDate serviceDate) {
        this.ownerID = ownerID;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.serviceDate = serviceDate;
        this.vehicleCatalog = new VehicleCatalog(); // 初始化 VehicleCatalog
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
