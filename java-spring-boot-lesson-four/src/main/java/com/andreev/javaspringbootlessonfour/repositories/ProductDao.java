package com.andreev.javaspringbootlessonfour.repositories;

import com.andreev.javaspringbootlessonfour.entities.Product;
import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct();
    void addProduct();
    Product getProductById(Long id);
    void updateProduct(Product product);
    void deleteProduct(Long id);
}
