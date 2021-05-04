package com.andreev.javaspringbootlessonfour.services;

import com.andreev.javaspringbootlessonfour.entities.Customer;
import com.andreev.javaspringbootlessonfour.entities.Product;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter

@Component
public class FactoryUtil {
    private SessionFactory factory;

    @PostConstruct
    public void init(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    @PreDestroy
    public void close() {
        factory.close();
    }

    public SessionFactory getFactory() {
        return factory;
    }
}
