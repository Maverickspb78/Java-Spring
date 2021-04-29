package com.andreev.javaspringbootlessonfour.services;

import com.andreev.javaspringbootlessonfour.entities.Product;
import com.andreev.javaspringbootlessonfour.repositories.ProductRepository;
import com.andreev.javaspringbootlessonfour.repositories.specifications.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	@Transactional
	public Product getById(Long id) {
		return productRepository.findById(id).get();
	}

	@Transactional
	public void remove(Long id) {
		productRepository.deleteById(id);
	}

	@Transactional
	public void addOrUpdate(Product product) {
		productRepository.save(product);
	}

	@Transactional
	public List<Product> getByParams(Optional<String> nameFilter, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice) {
//		if (!nameFilter.contains("%")) {
//			nameFilter = String.join("", "%", nameFilter, "%");
//		}
//		return productRepository.findProductByTitleLike(nameFilter);

		// select * from Product p where 1 = 1 and p.title like nameFilter;

		Specification<Product> specification = Specification.where(null);
		if (nameFilter.isPresent()) {
			specification = specification.and(ProductSpecification.titleLike(nameFilter.get()));
		}

		if (minPrice.isPresent()) {
			specification = specification.and(ProductSpecification.grater(minPrice.get()));
		}

		if (maxPrice.isPresent()) {
			specification = specification.and(ProductSpecification.less(maxPrice.get()));
		}

		return productRepository.findAll(specification);
	}
}
