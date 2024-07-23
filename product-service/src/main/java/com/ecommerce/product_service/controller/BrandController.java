package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.BrandDTO;
import com.ecommerce.product_service.entity.Brand;
import com.ecommerce.product_service.service.BrandService;
import com.microservice.shared_library.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController<Brand, BrandDTO, UUID> {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        super(brandService);
        this.brandService = brandService;
    }
}
