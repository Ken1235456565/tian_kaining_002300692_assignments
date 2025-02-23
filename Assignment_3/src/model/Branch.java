/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String branchID;
    private String name;
    private Library library;
    private String managerName;
    private List<RentalRequest> rentalRequests;
    private double totalRevenue;

    public Branch(String branchID, String name, Library library, String managerName) {
        this.branchID = branchID;
        this.name = name;
        this.library = library;
        this.managerName = managerName;
        this.rentalRequests = new ArrayList<>();
        this.totalRevenue = 0.0;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    
    public void addRentalRequest(RentalRequest request) {
        rentalRequests.add(request);
    }
    
    public List<RentalRequest> getRentalRequests() {
        return rentalRequests;
    }
    
    public double getTotalRevenue() {
        calculateTotalRevenue();
        return totalRevenue;
    }
    
    private void calculateTotalRevenue() {
        totalRevenue = 0;
        for (RentalRequest request : rentalRequests) {
            if (request.getStatus().equals("APPROVED") || request.getStatus().equals("RETURNED")) {
                totalRevenue += request.getPrice();
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
