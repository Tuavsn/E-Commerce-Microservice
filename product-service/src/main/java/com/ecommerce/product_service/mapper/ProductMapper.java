package com.ecommerce.product_service.mapper;

import com.ecommerce.product_service.dto.ProductDTO;
import com.ecommerce.product_service.entity.Product;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductDTO, UUID> {
    @Named("productToProductDTO")
    @Override
    ProductDTO toDTO(Product product);

    @Named("productDTOToProduct")
    @Override
    Product toModel(ProductDTO productDTO);

    @Named("productListToProductDTOList")
    @Override
    List<ProductDTO> toDTO(List<Product> productList);

    @Named("productDTOListToProductList")
    @Override
    List<Product> toModel(List<ProductDTO> productDTOList);
}
