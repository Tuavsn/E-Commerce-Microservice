package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.CategoryDTO;
import com.ecommerce.product_service.entity.Category;
import com.microservice.shared_library.service.BaseService;

import java.util.UUID;

public interface CategoryService extends BaseService<Category, CategoryDTO, UUID> {
}
