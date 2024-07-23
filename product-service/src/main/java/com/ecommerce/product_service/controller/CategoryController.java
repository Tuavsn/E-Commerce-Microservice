package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.CategoryDTO;
import com.ecommerce.product_service.entity.Category;
import com.ecommerce.product_service.service.CategoryService;
import com.microservice.shared_library.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<Category, CategoryDTO, UUID> {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }
}
