/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author archil
 */

public class Service {
    private String serviceID;
    private String serviceType;
    private double cost;
    private String mechanic1;
    private String mechanic2;
    private int serviceDuration; // 服务时长（单位：分钟）

    // 无参构造函数
    public Service() {
        this.serviceID = "Unknown";
        this.serviceType = "Unknown";
        this.cost = 0.0;
        this.mechanic1 = "Unknown";
        this.mechanic2 = "Unknown";
        this.serviceDuration = 0;
    }

    // 带参数的构造函数
    public Service(String serviceID, String serviceType, double cost, String mechanicName1, String mechanicName2, int serviceDuration) {
        this.serviceID = serviceID;
        this.serviceType = serviceType;
        this.cost = cost;
        this.mechanic1 = mechanicName1;
        this.mechanic2 = mechanicName2;
        this.serviceDuration = serviceDuration;
    }

    // Getters & Setters
    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMechanic1() {
        return mechanic1;
    }

    public void setMechanic1(String mechanic1) {
        this.mechanic1 = mechanic1;
    }

    public String getMechanic2() {
        return mechanic2;
    }

    public void setMechanic2(String mechanic2) {
        this.mechanic2 = mechanic2;
    }

    
    public int getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(int serviceDuration) {
        this.serviceDuration = serviceDuration;
    }
}


