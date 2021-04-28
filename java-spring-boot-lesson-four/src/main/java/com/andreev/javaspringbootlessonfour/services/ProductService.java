package com.andreev.javaspringbootlessonfour.services;

import com.andreev.javaspringbootlessonfour.entities.Product;
import com.andreev.javaspringbootlessonfour.repositories.ProductDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	private ProductDaoImpl productDaoImpl;

	@Autowired
	public void setProductDaoImpl(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	public List<Product> getAllProduct() {
		return productDaoImpl.getAllProduct();
	}

	public Product getById(Long id) {
		return productDaoImpl.getProductById(id);
	}

	public void remove(Long id) {
		productDaoImpl.deleteProduct(id);
	}

	public void add() {
		productDaoImpl.addProduct();
	}

	public void update(Product product) {
		productDaoImpl.updateProduct(product);
	}
}
