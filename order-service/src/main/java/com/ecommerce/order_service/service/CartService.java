package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.order.CartDTO;
import com.ecommerce.order_service.entity.Cart;
import com.microservice.shared_library.service.BaseService;

import java.util.UUID;

public interface CartService extends BaseService<Cart, CartDTO, UUID> {
    public CartDTO getCartByUserId(String userId);
    public CartDTO addItemToCart(String userId, String productId, int quantity);
    public CartDTO changeItemQuantity(String userId, String cartItemId, int quantity);
    public CartDTO removeItemToCart(String userId, String cartItemId);
    public CartDTO clearCart(String userId);
}
