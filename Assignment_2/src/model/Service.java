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
    private int serviceID;
    private String serviceType;
    private double cost;
    private String mechanicName;
    private int serviceDuration; // 服务时长（单位：分钟）

    // 无参构造函数
    public Service() {
        this.serviceID = 0;
        this.serviceType = "Unknown";
        this.cost = 0.0;
        this.mechanicName = "Unknown";
        this.serviceDuration = 0;
    }

    // 带参数的构造函数
    public Service(int serviceID, String serviceType, double cost, String mechanicName, int serviceDuration) {
        this.serviceID = serviceID;
        this.serviceType = serviceType;
        this.cost = cost;
        this.mechanicName = mechanicName;
        this.serviceDuration = serviceDuration;
    }

    // Getters & Setters
    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
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

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public int getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(int serviceDuration) {
        this.serviceDuration = serviceDuration;
    }
}


