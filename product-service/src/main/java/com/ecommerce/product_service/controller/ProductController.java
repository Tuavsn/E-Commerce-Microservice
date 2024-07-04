package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.ProductDTO;
import com.ecommerce.product_service.entity.Product;
import com.ecommerce.product_service.service.impl.ProductServiceImpl;
import com.microservice.shared_library.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController<Product, ProductDTO, UUID> {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        super(productService);
        this.productService = productService;
    }
}
