package com.polozov.javaspringbootlessonfour.mappers;

import com.polozov.javaspringbootlessonfour.dto.ProductDTO;
import com.polozov.javaspringbootlessonfour.entities.Product;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    Product toProduct(ProductDTO productDTO);

    @InheritConfiguration
    ProductDTO fromProduct(Product product);
    List<Product> toProductList(List<ProductDTO> productDTOS);
    List<ProductDTO> fromProductList(List<Product> products);
}
