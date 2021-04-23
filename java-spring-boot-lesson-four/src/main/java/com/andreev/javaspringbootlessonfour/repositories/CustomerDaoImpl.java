package com.andreev.javaspringbootlessonfour.repositories;

import com.andreev.javaspringbootlessonfour.entities.Customer;
import com.andreev.javaspringbootlessonfour.entities.Product;
import com.andreev.javaspringbootlessonfour.services.FactoryUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    List<Customer> customers;
    @Autowired
    Customer customer;

    private FactoryUtil factoryUtil;
    Session session = null;

    @Autowired
    public void setFactory(FactoryUtil factoryUtil){
        this.factoryUtil = factoryUtil;
    }



    @Override
    public List<Customer> getAllCustomers() {
        try {
            session = factoryUtil.getFactory().getCurrentSession();
            session.beginTransaction();
            customers = session.createQuery("from Customer").getResultList();
            System.out.println(customers);
            session.getTransaction().commit();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return customers;
    }

    @Override
    public void addCustomers() {
        try {
            session = factoryUtil.getFactory().getCurrentSession();
            session.beginTransaction();
            customer = new Customer();
            session.save(customer);
            session.getTransaction().commit();
        } finally {
            if (session != null){
                session.close();
            }
        }

    }

    @Override
    public Customer getCustomersById(long id) {
        try {
            session = factoryUtil.getFactory().getCurrentSession();
            session.beginTransaction();
            customer = session.get(Customer.class, id);
            System.out.println(customer);
        } finally {
            if (session != null){
                session.close();
            }
        }

        return customer;
    }

    @Override
    public void updateCustomers(Customer customer) {
        try{
            session = factoryUtil.getFactory().getCurrentSession();
            session.beginTransaction();
            customer = session.get(Customer.class, customer.getId());
//            customer.setName(customerForm.getName());
            session.getTransaction().commit();
        } finally {
            if (session != null){
                session.close();
            }
        }

    }

    @Override
    public void deleteCustomers(Long id) {
        try{
            session = factoryUtil.getFactory().getCurrentSession();
            session.beginTransaction();
            customer = session.get(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
        } finally {
            if (session != null){
                session.close();
            }
        }

    }

    public List<Product> getProductsCustomer(Long id){
        List<Product> products;
        try {
            session = factoryUtil.getFactory().getCurrentSession();
            session.beginTransaction();
            customer = session.get(Customer.class, id);
            products = customer.getProducts();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }
}
