package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.BrandDTO;
import com.ecommerce.product_service.entity.Brand;
import com.microservice.shared_library.service.BaseService;

import java.util.UUID;

public interface BrandService extends BaseService<Brand, BrandDTO, UUID> {
}
