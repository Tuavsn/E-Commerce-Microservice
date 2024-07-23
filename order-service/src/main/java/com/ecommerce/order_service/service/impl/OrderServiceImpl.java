package com.ecommerce.order_service.service.impl;

import com.ecommerce.order_service.client.ProductClient;
import com.ecommerce.order_service.dto.order.CartDTO;
import com.ecommerce.order_service.dto.order.OrderDTO;
import com.ecommerce.order_service.entity.Cart;
import com.ecommerce.order_service.entity.Orders;
import com.ecommerce.order_service.mapper.OrderMapper;
import com.ecommerce.order_service.repository.CartRepository;
import com.ecommerce.order_service.repository.OrderRepository;
import com.ecommerce.order_service.service.OrderService;
import com.microservice.shared_library.service.Impl.BaseServiceImpl;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Orders, OrderDTO, UUID> implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;
    private final CartRepository cartRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            OrderMapper orderMapper,
            ProductClient productClient,
            CartRepository cartRepository
    ) {
        super(orderRepository, orderMapper);
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productClient = productClient;
        this.cartRepository = cartRepository;
    }

//    @Override
//    public OrderDTO placeOrder(String userId) {
//        Cart cart = cartRepository.getByUserId(userId);
//        if( cart == null || cart.getCartItems().isEmpty() ) {
//            throw new IllegalStateException("Cart is empty");
//        }
//
//        double totalAmount = calculateTotal(cart);
//
//        return orderMapper.toDTO(new Orders());
//    }
//
//    public double calculateTotal(Cart cart) {
//        return cart.getCartItems()
//                .stream().mapToDouble(item ->
//                        item.getQuantity() * item.getProductId()).sum();
//    }
}
