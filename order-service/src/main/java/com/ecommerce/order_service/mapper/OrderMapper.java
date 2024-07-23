package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.order.OrderDTO;
import com.ecommerce.order_service.entity.Orders;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Orders, OrderDTO, UUID> {
    @Named("orderToOrderDTO")
    @Override
    OrderDTO toDTO(Orders order);

    @Named("orderDTOToOrder")
    @Override
    Orders toModel(OrderDTO orderDTO);
}
