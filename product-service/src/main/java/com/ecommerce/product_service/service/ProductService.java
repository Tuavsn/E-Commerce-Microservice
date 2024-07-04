package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductDTO;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    List<ProductDTO> findByIdPublic(Set<UUID> ids);
}
