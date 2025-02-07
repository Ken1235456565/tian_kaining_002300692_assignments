/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Rushabh
 */
public class Vehicle {
    
    private String vehicleID; // 车辆 ID
    private String make; // 制造商（如 Toyota, Honda）
    private String model; // 车型（如 Camry）
    private int year; // 生产年份
    private String registrationNumber; // 车牌号
    private Set<Service> servicesOpted;; // 选择的服务

    // 无参构造函数（自动分配 vehicleID）
    public Vehicle() {
        this.servicesOpted = new HashSet<>();
    }

    // 带参数的构造函数
    public Vehicle(String vehicleID, String make, String model, int year, String registrationNumber) {
        if (vehicleID == null || make == null || model == null || registrationNumber == null ||
            vehicleID.trim().isEmpty() || make.trim().isEmpty() || 
            model.trim().isEmpty() || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("All fields must be non-null and non-empty");
        }
        
        this.vehicleID = vehicleID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.registrationNumber = registrationNumber;
        this.servicesOpted = new HashSet<>();
    }

    // Getters & Setters
    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    // Get Services - No copy returned, so UI can modify directly
    public Set<Service> getServicesOpted() {
        return servicesOpted;
    }

    // Add a service (Ensures no duplicate services)
    public void addService(Service service) {
        if (service == null) {
            throw new IllegalArgumentException("Service cannot be null");
        }
        this.servicesOpted.add(service); // HashSet prevents duplicates
    }

    // Remove a service by ID (Ensures correct removal)
    public boolean removeService(String serviceID) {
        return servicesOpted.removeIf(service -> service.getServiceID().equals(serviceID));
    }

    // Update Services by replacing the entire list (Clears & Adds New)
    public void setServicesOpted(Set<Service> newServices) {
        this.servicesOpted.clear();
        this.servicesOpted.addAll(newServices);
    }

    // Improved toString() to display services correctly
    @Override
    public String toString() {
        if (servicesOpted.isEmpty()) {
            return "Vehicle ID: " + vehicleID + " | " + make + " " + model + " (" + year + ") - No services opted.";
        }

        StringBuilder result = new StringBuilder();
        result.append("Vehicle ID: ").append(vehicleID).append(" | ")
              .append(make).append(" ").append(model)
              .append(" (").append(year).append(") - Services: ");

        int count = 0;
        for (Service service : servicesOpted) {
            result.append(service.getServiceName());
            if (count < servicesOpted.size() - 1) {
                result.append(", ");
            }
            count++;
        }
        return result.toString();
    }
    
}
