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
        vehicleCatalog.add(v);
        return v;
    }

    // 添加已存在的车辆
    public void addVehicle(Vehicle v) {
        vehicleCatalog.add(v);
    }

    // 删除车辆
    public void removeVehicle(Vehicle v) {
        vehicleCatalog.remove(v);
    }

    // 通过 ID 搜索车辆
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

    // 获取车辆总数
    public int getVehicleCount() {
        return vehicleCatalog.size();
    }
}
