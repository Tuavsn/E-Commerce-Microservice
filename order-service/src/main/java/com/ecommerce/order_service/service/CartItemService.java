package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.order.CartItemDTO;
import com.ecommerce.order_service.entity.CartItem;
import com.microservice.shared_library.service.BaseService;

import java.util.UUID;

public interface CartItemService extends BaseService<CartItem, CartItemDTO, UUID> {
}
