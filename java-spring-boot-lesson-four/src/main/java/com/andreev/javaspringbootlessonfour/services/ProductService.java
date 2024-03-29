package com.andreev.javaspringbootlessonfour.services;

import com.andreev.javaspringbootlessonfour.entities.Product;
import com.andreev.javaspringbootlessonfour.repositories.ProductRepository;
import com.andreev.javaspringbootlessonfour.repositories.specifications.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
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
	public Optional<Product> getById(Long id) {
		return productRepository.findById(id);
	}

	@Transactional
	public List<Product> findAll(){
		return productRepository.findAll();
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
	public Page<Product> getByParams(Optional<String> nameFilter,
	                                 Optional<BigDecimal> min,
	                                 Optional<BigDecimal> max,
	                                 Optional<Integer> page,
	                                 Optional<Integer> size,
									 Optional<String> sort,
									 Optional<Boolean> direction) {

		Specification<Product> specification = Specification.where(null);
		if (nameFilter.isPresent()) {
			specification = specification.and(ProductSpecification.titleLike(nameFilter.get()));
		}


		if (min.isPresent()) {
			specification = specification.and(ProductSpecification.ge(min.get()));
		}

		if (max.isPresent()) {
			specification = specification.and(ProductSpecification.le(max.get()));
		}
		String column = "id";
		if (sort.isPresent()){
			column = sort.orElse("id");
		}

		if (direction.isPresent() && !direction.get()){
			return productRepository.findAll(specification,
					PageRequest.of(page.orElse(1) -1, size.orElse(4), Sort.Direction.DESC, (column)));
		}
		return productRepository.findAll(specification,
				PageRequest.of(page.orElse(1) - 1, size.orElse(4), Sort.Direction.ASC, (column)));


	}
}
