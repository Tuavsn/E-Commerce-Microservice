package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductDTO;
import com.ecommerce.product_service.entity.Product;
import com.microservice.shared_library.service.BaseService;

import java.util.UUID;

public interface ProductService extends BaseService<Product, ProductDTO, UUID> {

}
