package com.andreev.javaspringbootlessonfour.rest;

import com.andreev.javaspringbootlessonfour.entities.Product;
import com.andreev.javaspringbootlessonfour.services.ProductService;
import com.andreev.javaspringbootlessonfour.services.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product API" , description = "API to manipulate product resources")
@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {

    private ProductService service;

    @Autowired
    public void getService(ProductService service) {
        this.service=service;
    }

    @GetMapping(path = "/{id}/id", produces = "application/json")
    public Product findById(@PathVariable("id") Long id){
        return service.getById(id).orElseThrow(NotFoundException::new);
    }

    @GetMapping(path = "/list", produces = "application/json")
    public List<Product> findAll(){
        return service.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Product createProduct(@RequestBody Product product){
        service.addOrUpdate(product);
        return product;
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public Product updateProduct(@RequestBody Product product){
        service.addOrUpdate(product);
        return product;
    }

    @DeleteMapping("/{id}/id")
    public void deleteById(@PathVariable("id") Long id){
        service.remove(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> notFoundExceptionHandler(NotFoundException e){
        return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
    }
}
