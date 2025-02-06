package model;


public class Service {
    private String serviceID;        // 服务ID
    private String serviceName;      // 服务名称
    private double cost;            // 服务费用
    private String mechanic1;       // 技师1
    private String mechanic2;       // 技师2
    private int serviceDuration;    // 服务时长（分钟）

    // 无参构造函数
    public Service() {
        this.serviceID = "Unknown";
        this.serviceName = "Unknown";
        this.cost = 0.0;
        this.mechanic1 = "Unknown";
        this.mechanic2 = "Unknown";
        this.serviceDuration = 0;
    }

    // 带参数的构造函数
    public Service(String serviceID, String serviceName, double cost, 
                  String mechanic1, String mechanic2, int serviceDuration) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.cost = cost;
        this.mechanic1 = mechanic1;
        this.mechanic2 = mechanic2;
        this.serviceDuration = serviceDuration;
    }

    // Getter和Setter方法
    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
    
    

    @Override
    public String toString() {
        return serviceName; 
    }
}