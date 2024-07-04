package com.ecommerce.product_service.entity;

import com.microservice.shared_library.model.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Product extends BaseEntityAudit {

    @Column(nullable = false)
    private String productTitle;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private double priceUnit;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    private Category category;

    @Override
    public String toString() {
        return "Product [productTitle=" + productTitle
                + ", sku=" + sku
                + ", description="
                + description
                + ", imageUrl=" + imageUrl
                + ", priceUnit=" + priceUnit
                + ", quantity=" + quantity
                + super.toString() + "]";
    }
}
