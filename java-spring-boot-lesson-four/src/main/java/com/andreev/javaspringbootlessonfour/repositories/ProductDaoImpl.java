package com.andreev.javaspringbootlessonfour.repositories;

import com.andreev.javaspringbootlessonfour.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {

    List<Product> products;
    Product product = new Product();
    SessionFactory factory;
    Session session = null;

    public ProductDaoImpl() {
        factory = getFactory();
        products = new ArrayList<>();

    }
    public SessionFactory getFactory(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        return factory;
    }

    @Override
    public List<Product> getAllProduct() {
        try {
            session = getFactory().getCurrentSession();
            session.beginTransaction();
            products = session.createQuery("from Product").getResultList();
            System.out.println(products);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
        return products;
    }

    @Override
    public void addProduct() {
        try {
            session = getFactory().getCurrentSession();
            session.beginTransaction();
            product = new Product();
            session.save(product);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

    @Override
    public Product getProduct(long id) {
        try {
        session = getFactory().getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, id);
        System.out.println(product);
        } finally {
            session.close();
            factory.close();
        }
        return product;
    }

    @Override
    public void updateProduct(Product productForm) {
        try{
        session = getFactory().getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, product.getId());
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }

    @Override
    public void deleteProduct(long id) {
        try{
        session = getFactory().getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }
}
