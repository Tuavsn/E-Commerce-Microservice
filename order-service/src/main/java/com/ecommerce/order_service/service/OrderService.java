package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.order.OrderDTO;
import com.ecommerce.order_service.entity.Orders;
import com.microservice.shared_library.service.BaseService;

import java.util.UUID;

public interface OrderService extends BaseService<Orders, OrderDTO, UUID> {
//    public OrderDTO placeOrder(OrderDTO orderDTO);
}
