/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

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
    public Vehicle(String make, String model, int year, String registrationNumber) {
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

    public void addService(Service service) {
        this.servicesOpted.add(service);
    }

    public void removeService(Service service) {
        this.servicesOpted.remove(service);
    }
}
