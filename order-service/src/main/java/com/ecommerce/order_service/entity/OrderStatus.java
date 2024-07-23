package com.ecommerce.order_service.entity;

public enum OrderStatus {
    PROCESSING("Processing"),
    UNPAID("Unpaid"),
    RETURNED("Returned"),
    DELIVERED("Delivered"),
    CANCELED("Canceled"),
    SHIP("Ship");

    private String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
