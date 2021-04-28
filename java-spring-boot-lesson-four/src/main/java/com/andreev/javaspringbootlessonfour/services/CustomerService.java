package com.andreev.javaspringbootlessonfour.services;

import com.andreev.javaspringbootlessonfour.entities.Customer;
import com.andreev.javaspringbootlessonfour.repositories.CustomerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerDaoImpl customerDaoImpl;
    @Autowired
    public void setCustomerDaoImpl(CustomerDaoImpl customerDaoImpl) {
        this.customerDaoImpl = customerDaoImpl;
    }
    public List<Customer> getAllCustomers() {
        return customerDaoImpl.getAllCustomers();
    }

    public Customer getById(Long id) {
        return customerDaoImpl.getCustomersById(id);
    }

    public void remove(Long id) {
        customerDaoImpl.deleteCustomers(id);
    }

    public void add() {
        customerDaoImpl.addCustomers();
    }

    public void update(Customer customer) {
        customerDaoImpl.updateCustomers(customer);
    }
}
