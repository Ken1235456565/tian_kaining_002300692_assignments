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
    public Vehicle searchVehicle(String id) {
        for (Vehicle v : vehicleCatalog) {
            if (v.getVehicleID() == id) { // getId() 改为 getVehicleID()
                return v;
            }
        }
        return null;
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
