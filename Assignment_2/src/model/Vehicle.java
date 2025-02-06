/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Iterator;

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
    private ArrayList<Service> servicesOpted; // 选择的服务

    // 无参构造函数（自动分配 vehicleID）
    public Vehicle() {
        this.vehicleID = vehicleID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.registrationNumber = registrationNumber;
        this.servicesOpted = new ArrayList<>();
    }

    // 带参数的构造函数
    public Vehicle(String vehicleID, String make, String model, int year, String registrationNumber, Owner owner) {
        this.vehicleID = vehicleID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.registrationNumber = registrationNumber;
        this.servicesOpted = new ArrayList<>();
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

    public ArrayList<Service> getServicesOpted() {
        return servicesOpted;
    }
    
    public void setServicesOpted(ArrayList<Service> servicesOpted) {
        this.servicesOpted = servicesOpted;
    }

    public void addService(Service service) {
        this.servicesOpted.add(service);
    }

    public void removeService(Service service) {
        this.servicesOpted.remove(service);
    }
    
    
    public String toString() {
    if (servicesOpted.isEmpty()) {
        return "Vehicle: " + make + " " + model + " (" + year + ") - No services opted.";
    }

    StringBuilder result = new StringBuilder();
    result.append("Vehicle: ").append(make).append(" ").append(model).append(" (").append(year).append(") - Services: ");

    for (int i = 0; i < servicesOpted.size(); i++) {
        result.append(servicesOpted.get(i).getServiceName()); //只显示服务名称
        if (i < servicesOpted.size() - 1) {
            result.append(", "); // 添加逗号分隔，最后一个不加
        }
    }
    return result.toString();
}
    
}
