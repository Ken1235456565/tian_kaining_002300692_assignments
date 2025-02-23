/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;


public class CustomerDirectory {
    private List<Customer> customers;
    
    public CustomerDirectory() {
        this.customers = new ArrayList<>();
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    public List<Customer> getCustomers() {
        return customers;
    }
    
    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    public Customer findCustomerByUsername(String username) {
    for (Customer c : customers) {
        if (c.getUser().getUsername().equals(username)) {
            return c;
        }
    }
    return null;
}
}
