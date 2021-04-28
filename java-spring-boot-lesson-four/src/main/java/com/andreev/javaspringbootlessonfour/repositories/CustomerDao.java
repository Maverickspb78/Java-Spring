package com.andreev.javaspringbootlessonfour.repositories;

import com.andreev.javaspringbootlessonfour.entities.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomers();
    void addCustomers();
    Customer getCustomersById(long id);
    void updateCustomers(Customer customer);
    void deleteCustomers(Long id);
}
