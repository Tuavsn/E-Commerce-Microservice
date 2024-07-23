package com.ecommerce.order_service.entity;

import com.microservice.shared_library.model.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class OrderLine extends BaseEntityAudit {
    @ManyToOne(optional = false)
    private Orders orders;

    @Column(nullable = false)
    private UUID productId;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;
}
