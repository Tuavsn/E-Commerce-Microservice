package com.ecommerce.product_service.entity;

import com.microservice.shared_library.model.BaseEntityAudit;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Category extends BaseEntityAudit {
    private String categoryName;
    private String imageUrl;
    private String description;
    private Set<Category> subCategories;
    private Category parentCategory;
    private Set<Product> products;
}
