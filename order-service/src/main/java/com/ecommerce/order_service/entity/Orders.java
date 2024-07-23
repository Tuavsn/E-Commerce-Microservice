package com.ecommerce.order_service.entity;

import com.microservice.shared_library.model.BaseEntityAudit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Orders extends BaseEntityAudit {
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private String orderDesc;

    @Column(nullable = false)
    private double orderFee;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private PaymentType paymentType;

    @Column(nullable = false)
    private ShippingProvider shippingProvider;

    @Column(nullable = false)
    private OrderStatus status;

    @OneToOne(optional = false)
    private Cart cart;

    @OneToMany(mappedBy = "orders")
    private Set<OrderLine> orderLines = new HashSet<>();
}
