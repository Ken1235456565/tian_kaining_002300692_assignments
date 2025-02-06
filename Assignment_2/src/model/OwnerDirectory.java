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
public class OwnerDirectory {
    
    private ArrayList<Owner> ownerList;   
    //constructor
    public OwnerDirectory(ArrayList<Owner> ownerList) {
        this.ownerList = (ownerList != null) ? ownerList : new ArrayList<>();
    }
    public OwnerDirectory() {
        ownerList = new ArrayList<>();
    }
    
    // 获取所有 Owner 列表
    public ArrayList<Owner> getOwnerList() {
        return ownerList;
    }
    
    // 添加一个 Owner
    public Owner addOwner() {
        Owner newOwner = new Owner();
        ownerList.add(newOwner);
        return newOwner;
    }
    
    public void addOwner(Owner owner) {
        if (owner != null) {
            ownerList.add(owner);
        }
    }
    
    // 删除指定的 Owner
    public void removeOwner(Owner owner) {
        ownerList.remove(owner);
    }
    
    // 根据 ID 或 Name 搜索 Owner
    public Owner searchOwner(String keyWord) {
        for (Owner owner : ownerList) {
            // 允许按 Owner ID 或 First Name 或 Last Name 搜索
            if (String.valueOf(owner.getOwnerID()).equals(keyWord) || 
                owner.getOwnerFirstName().equalsIgnoreCase(keyWord) || 
                owner.getOwnerLastName().equalsIgnoreCase(keyWord)) {
                return owner;
            }
        }
        return null;
    }
}
