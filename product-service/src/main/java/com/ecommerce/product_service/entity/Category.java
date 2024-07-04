package com.ecommerce.product_service.entity;

import com.microservice.shared_library.model.BaseEntityAudit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Category extends BaseEntityAudit {

    @Column(nullable = false, unique = true)
    private String categoryTitle;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subCategories = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "parent_category_id", nullable = true)
    private Category parentCategory;

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        return "Category [categoryName=" + categoryTitle
                + ", imageUrl=" + imageUrl
                + ", description=" + description
                + ", subCategories=" + subCategories
                + ", parentCategory=" + parentCategory
                + ", products=" + products
                + super.toString() + "]";
    }
}
