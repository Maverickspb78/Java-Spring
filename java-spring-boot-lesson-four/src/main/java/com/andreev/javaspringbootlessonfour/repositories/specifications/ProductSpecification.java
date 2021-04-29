package com.andreev.javaspringbootlessonfour.repositories.specifications;

import com.andreev.javaspringbootlessonfour.entities.Product;
import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;

public class ProductSpecification {
	public static Specification<Product> trueLiteral() {
		return (root, query, builder) -> builder.isTrue(builder.literal(true));
	}

	public static Specification<Product> titleLike(String titleFilter) {
		return (root, query, builder) -> builder.like(root.get("title"), "%" + titleFilter + "%");
	}

	// TODO: 23.04.2021 Добавить спецификации согласно ДЗ

	public static Specification<Product> grater(BigDecimal minPrice) {
		return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice);
	}

	public static Specification<Product> less(BigDecimal maxPrice) {
		return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice);
	}
}
