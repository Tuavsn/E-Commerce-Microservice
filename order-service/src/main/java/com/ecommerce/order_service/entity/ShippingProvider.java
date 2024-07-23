package com.ecommerce.order_service.entity;

public enum ShippingProvider {
    GHN("GHN"),
    VNEXPESS("VN Express"),
    GHTK("GHTK");

    private String displayName;

    ShippingProvider(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
