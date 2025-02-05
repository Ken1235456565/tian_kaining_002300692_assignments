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
    
    private String name;
    private int price;
    private int id;
    private ArrayList<Service> features = new ArrayList<>();

    //this is a counter
    private static int count = 0;
    
    public Vehicle() {
        count++;
        id = count;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    @Override
    public String toString() {
        return name;
    }
    
        public ArrayList<Service> getFeatures() {
    return features;
    }

    public void addFeature(Service feature) {
        features.add(feature);
    }

    public void removeFeature(Service feature) {
        features.remove(feature);
    }
}
