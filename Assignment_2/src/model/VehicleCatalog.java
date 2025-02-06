/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/**
 *
 * @author Rushabh
 */

public class VehicleCatalog {
    
    private ArrayList<Vehicle> vehicleCatalog;
    
    // constru
    public VehicleCatalog() {
        this.vehicleCatalog = new ArrayList<>();
    }
    public VehicleCatalog(ArrayList<Vehicle> vehicleCatalog) {
        this.vehicleCatalog = (vehicleCatalog != null) ? vehicleCatalog : new ArrayList<>();
    }

    // 获取所有车辆
    public ArrayList<Vehicle> getVehicleCatalog() {
        return vehicleCatalog;
    }

    // 添加新车辆（无参，自动创建）
    public Vehicle addVehicle() {
        Vehicle v = new Vehicle();
//        vehicleCatalog.add(v);
//        return v;
        // 自动生成唯一VehicleID
        String newID = UUID.randomUUID().toString();
        while (vehicleCatalog.contains(newID)) {  //ID不重复
            newID = UUID.randomUUID().toString();
        }
        v.setVehicleID(newID);
        
        vehicleCatalog.add(v);
//        vehicleCatalog.add(newID);
        return v;
    }

    // 添加已存在的车辆
    public void addVehicle(Vehicle v) {
        vehicleCatalog.add(v);
    }

//    // 删除车辆
//    public void removeVehicle(String v) {
//        vehicleCatalog.remove(v);
//    }

    // 通过 ID, make+model搜索车辆
    public ArrayList<Vehicle> searchVehicles(String searchInput) {
    ArrayList<Vehicle> results = new ArrayList<>();
    if (searchInput == null || searchInput.trim().isEmpty()) {
        return results;
    }
    
    searchInput = searchInput.toLowerCase().trim();
    
    for (Vehicle v : vehicleCatalog) {
        // 检查 vehicleID 或 make+model 是否匹配
        if (v.getVehicleID().toLowerCase().contains(searchInput) ||
            v.getMake().toLowerCase().contains(searchInput) ||
            v.getModel().toLowerCase().contains(searchInput) ||
            (v.getMake() + " " + v.getModel()).toLowerCase().contains(searchInput) ||
            (v.getModel() + " " + v.getMake()).toLowerCase().contains(searchInput)) {
            results.add(v);
        }
    }
    return results;
    }

    // 通过 Name (Make + Model) 搜索车辆
    public ArrayList<Vehicle> searchVehicleByName(String name) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicleCatalog) {
            if ((v.getMake() + " " + v.getModel()).equalsIgnoreCase(name)) {
                result.add(v);
            }
        }
        return result;
    }
    
    public boolean removeVehicle(String vehicleID) {
    Iterator<Vehicle> iterator = vehicleCatalog.iterator();
    while (iterator.hasNext()) {
        Vehicle v = iterator.next();
        if (v.getVehicleID().equals(vehicleID)) {
            iterator.remove(); // 删除
            return true; // 删除成功，返回 true
        }
    }
    return false; // 车辆未找到，返回 false
}
    
    public Vehicle findVehicle(String vehicleID) {
    for (Vehicle vehicle : vehicleCatalog) {
        if (vehicle.getVehicleID().equals(vehicleID)) {
            return vehicle;
        }
    }
    return null;
}

    // 获取车辆总数
    public int getVehicleCount() {
        return vehicleCatalog.size();
    }
}
