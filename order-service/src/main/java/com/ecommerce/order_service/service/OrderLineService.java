package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.order.OrderLineDTO;
import com.ecommerce.order_service.entity.OrderLine;
import com.microservice.shared_library.service.BaseService;

import java.util.UUID;

public interface OrderLineService extends BaseService<OrderLine, OrderLineDTO, UUID> {
}
