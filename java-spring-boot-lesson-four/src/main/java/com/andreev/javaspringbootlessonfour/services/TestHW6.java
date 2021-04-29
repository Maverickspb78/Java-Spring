package com.andreev.javaspringbootlessonfour.services;

import com.andreev.javaspringbootlessonfour.configuration.AppConfig;
import com.andreev.javaspringbootlessonfour.entities.Customer;
import com.andreev.javaspringbootlessonfour.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


import org.springframework.context.ApplicationContext;



public class TestHW6 {

    public static void main(String[] args) {

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        ListService listService = context.getBean(ListService.class);

//        prepareData();
//        work();
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("\n"+"\n"+"\n"+"\n"+listService.getCustomersProduct(1L));
//        System.out.println("\n"+"\n"+"\n"+"\n"+listService.getCustomersProduct(2L));
//        System.out.println("\n"+"\n"+"\n"+"\n"+listService.getCustomersProduct(3L));
//        System.out.println("\n"+"\n"+"\n"+"\n"+listService.getCustomersProduct(4L));
//        System.out.println("\n"+"\n"+"\n"+"\n"+listService.getProductsCustomer(1L));
//        System.out.println("\n"+"\n"+"\n"+"\n"+listService.getProductsCustomer(2L));
//        System.out.println("\n"+"\n"+"\n"+"\n"+listService.getProductsCustomer(3L));
//        System.out.println("\n"+"\n"+"\n"+"\n"+listService.getProductsCustomer(4L));




    }


    private static void prepareData() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try {
            String sql = Files.lines(Paths.get("java-spring-boot-lesson-four/create-and-fill.sql"))
                    .collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session !=null){
                session.close();
            }
        }
    }

    private static void work() {
        Session session = null;

//        HibernateSessionFactoryUtil requestFactory = new HibernateSessionFactoryUtil();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Customer customer1 = session.get(Customer.class,1L);
            Product product1 = session.get(Product.class,3L);


//            System.out.println("-----------------------------------------"+"\n"+"\n");
//            System.out.println(product1.getCustomers());
//            System.out.println(customer1.getProducts());
//            System.out.println(customer1.getName());
//            System.out.println(product1.getName());
//            System.out.println("\n"+"\n"+"-----------------------------------------");


            session.getTransaction().commit();


        }finally {
            session.close();
            factory.close();
        }

    }
}
