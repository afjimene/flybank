package com.flybank.products.mapper;

import com.flybank.products.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    Product productToProductDto(com.flybank.products.api.model.Product product);
    com.flybank.products.api.model.Product productDtoToProduct(Product product);

}
