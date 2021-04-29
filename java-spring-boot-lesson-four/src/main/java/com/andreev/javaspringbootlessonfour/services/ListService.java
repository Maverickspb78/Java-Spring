package com.andreev.javaspringbootlessonfour.services;

import com.andreev.javaspringbootlessonfour.entities.Customer;
import com.andreev.javaspringbootlessonfour.entities.Product;
import com.andreev.javaspringbootlessonfour.repositories.CustomerDaoImpl;
import com.andreev.javaspringbootlessonfour.repositories.ProductDaoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListService {


    private CustomerDaoImpl customerDao;
    private ProductDaoImpl productDao;

//   public List<Customer> getCustomersProduct(Long id){
//       return productDao.getCustomersProduct(id);
//   }

   public Product getProductById(Long id){
       return productDao.getProductById(id);
   }

   public List<Product> getProductsCustomer(Long id){
       return customerDao.getProductsCustomer(id);
   }

   public Customer getCustomersById(Long id){
       return customerDao.getCustomersById(id);
   }
}
