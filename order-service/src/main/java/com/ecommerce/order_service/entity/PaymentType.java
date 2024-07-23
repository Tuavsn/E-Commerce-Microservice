package com.ecommerce.order_service.entity;

public enum PaymentType {
    COD("COD"),
    CREDIT("Credit card"),
    MOMO("Momo");

    private String displayName;

    PaymentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
