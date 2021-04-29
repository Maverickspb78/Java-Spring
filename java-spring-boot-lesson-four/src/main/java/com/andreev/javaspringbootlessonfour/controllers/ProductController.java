package com.andreev.javaspringbootlessonfour.controllers;

import com.andreev.javaspringbootlessonfour.entities.Product;
import com.andreev.javaspringbootlessonfour.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public String indexPage(Model model,
							@RequestParam(name = "titleFilter", required = false) Optional<String> titleFilter,
							@RequestParam(name = "minPrice", required = false) Optional<BigDecimal> minPrice,
							@RequestParam(name = "maxPrice", required = false) Optional<BigDecimal> maxPrice) {
		// TODO: 23.04.2021 Добавить обработку параметров формы

		model.addAttribute("products",productService.getByParams(titleFilter,minPrice,maxPrice));
		return "product_views/index";
	}

	@GetMapping("/{id}")
	public String editProduct(@PathVariable(value = "id") Long id,
	                          Model model) {
		model.addAttribute("product", productService.getById(id));
		return "product_views/product_form";
	}

	@PostMapping("/product_update")
	public String updateProduct(Product product) {
		productService.addOrUpdate(product);
		return "redirect:/product";
	}

	@GetMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute(new Product());
		return "product_views/product_form";
	}

	@GetMapping("/delete/{id}")
	public String removeProduct(@PathVariable(value = "id") Long id) {
		productService.remove(id);
		return "redirect:/product";
	}
}
