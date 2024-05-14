package com.flybank.products.mapper;

import com.flybank.products.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    Product productToProductDto(com.flybank.products.api.model.Product product);
    com.flybank.products.api.model.Product productDtoToProduct(Product product);

    List<com.flybank.products.service.api.model.Product> map(List<Product> products);
}
