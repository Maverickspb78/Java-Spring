package com.andreev.javaspringbootlessonfour.repositories;

import com.andreev.javaspringbootlessonfour.entities.Customer;
import com.andreev.javaspringbootlessonfour.entities.Product;
import com.andreev.javaspringbootlessonfour.services.FactoryUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {


    private List<Product> products;

    private Product product;
@Autowired
    private FactoryUtil factoryUtil;
    Session session = null;

    @Autowired
    public void setFactory(FactoryUtil factoryUtil){
        this.factoryUtil = factoryUtil;
    }

    @Override
    public List<Product> getAllProduct() {
        try {
            session = factoryUtil.getFactory().getCurrentSession();
            session.beginTransaction();
            products = session.createQuery("from Product").getResultList();
            System.out.println(products);
            session.getTransaction().commit();
        } finally {
            session.close();
            factoryUtil.getFactory().close();
        }
        return products;
    }

    @Override
    public void addProduct() {
        try {
            session = factoryUtil.getFactory().getCurrentSession();
            session.beginTransaction();
            product = new Product();
            session.save(product);
            session.getTransaction().commit();
        } finally {
            session.close();
            factoryUtil.getFactory().close();
        }
    }

    @Override
    public Product getProductById(Long id) {

        try {
        session = factoryUtil.getFactory().getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, id);
        session.getTransaction().commit();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product productForm) {
        try{
        session = factoryUtil.getFactory().getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, product.getId());

//        product.setName(productForm.getName());
//        product.setDescription(productForm.getDescription());

        product.setPrice(productForm.getPrice());
        session.getTransaction().commit();
        } finally {
            if (session != null){
                session.close();
            }
        }

    }

    @Override
    public void deleteProduct(Long id) {
        try{
        session = factoryUtil.getFactory().getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        } finally {
            if (session != null){
                session.close();
            }
        }

    }

//    public List<Customer> getCustomersProduct(Long id){
//        List<Customer> customers;
//
//        try {
//            session = factoryUtil.getFactory().getCurrentSession();
//            session.beginTransaction();
//            product = session.get(Product.class, id);
//            customers = product.getCustomers();
//            session.getTransaction().commit();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return customers;
//    }
}
