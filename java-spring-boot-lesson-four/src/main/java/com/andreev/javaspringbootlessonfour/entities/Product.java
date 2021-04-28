package com.andreev.javaspringbootlessonfour.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "products")
@Component
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

//	@Column(name = "description")
//	private String description;

	@Column(name = "price")
	private int price;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "purchases",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "customers_id")
	)
	private List<Customer> customers;


//	public Product(Long id, String name, String description, int price) {
//		this.id = id;
//		this.name = name;
////		this.description = description;
//		this.price = price;
//	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
