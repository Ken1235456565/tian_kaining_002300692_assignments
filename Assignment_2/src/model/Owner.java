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

    
    @Override
    public String toString() {
        return ownerFirstName + " " + ownerLastName;
    }
}
