package com.ecommerce.product_service.entity;

import com.microservice.shared_library.model.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Brand extends BaseEntityAudit {
    @Column(nullable = false, unique = true)
    private String brandTitle;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        return "Brand [brandTitle=" + brandTitle
                + ", description=" + description
                + ", imageUrl=" + imageUrl
                + ", products=" + products
                + super.toString() +"]";
    }
}
