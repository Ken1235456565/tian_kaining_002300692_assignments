/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tiankaining
 */
public class ServiceCatalog {
    private ArrayList<Service> serviceList;

    // **构造函数，初始化 `serviceList`**
    public ServiceCatalog() {
        this.serviceList = new ArrayList<>();
    }

    public void addService(Service service) {
        if (service != null) {
            serviceList.add(service);
            System.out.println("Service added: " + service.getServiceType());
        }
    }

    // 获取所有 `Service` 列表
    public ArrayList<Service> getServiceList() {
        return serviceList;
    }
}

