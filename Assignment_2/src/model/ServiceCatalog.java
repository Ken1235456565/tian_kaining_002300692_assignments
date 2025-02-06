/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import model.Service;

/**
 *
 * @author tiankaining
 */
public class ServiceCatalog {
    private ArrayList<Service> serviceList;    // 存储所有服务的列表

    // 构造函数
    public ServiceCatalog() {
        this.serviceList = new ArrayList<>();
    }

    // 添加新服务
    public void addService(Service service) {
        if (service != null) {
            serviceList.add(service);
            System.out.println("已添加服务: " + service.getServiceName());
        }
    }

    // 根据服务ID查找服务
    public Service findServiceById(String serviceID) {
        for (Service service : serviceList) {
            if (service.getServiceID().equals(serviceID)) {
                return service;
            }
        }
        return null;
    }

    // 根据服务名称查找服务
    public Service findServiceByName(String serviceName) {
        for (Service service : serviceList) {
            if (service.getServiceName().equals(serviceName)) {
                return service;
            }
        }
        return null;
    }

    // 获取所有服务列表
    public ArrayList<Service> getServiceList() {
        return serviceList;
    }

    // 删除服务
    public boolean removeService(String serviceID) {
        Service serviceToRemove = findServiceById(serviceID);
        if (serviceToRemove != null) {
            serviceList.remove(serviceToRemove);
            return true;
        }
        return false;
    }
    
    // 新增方法：检查服务是否已存在
    public boolean isServiceIdExists(String serviceID) {
    for (Service service : serviceList) {
        if (service.getServiceID().equals(serviceID)) {
            return true;
        }
    }
    return false;
}
}

