package com.ecommerce.product_service.entity;

import com.microservice.shared_library.model.BaseEntityAudit;
import jakarta.persistence.Entity;
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
    private String productTitle;
    private String sku;
    private String description;
    private String imageUrl;
    private double priceUnit;
    private int quantity;
}
