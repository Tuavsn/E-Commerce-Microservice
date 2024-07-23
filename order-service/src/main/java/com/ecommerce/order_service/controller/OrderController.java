package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.dto.order.OrderDTO;
import com.ecommerce.order_service.entity.Orders;
import com.ecommerce.order_service.service.OrderService;
import com.microservice.shared_library.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<Orders, OrderDTO, UUID> {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        super(orderService);
        this.orderService = orderService;
    }
}
