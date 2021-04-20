package com.andreev.javaspringbootlessonfour.repositories;

import com.andreev.javaspringbootlessonfour.entities.Product;
import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct();
    void addProduct();
    Product getProduct(long id);
    void updateProduct(Product product);
    void deleteProduct(long id);
}
