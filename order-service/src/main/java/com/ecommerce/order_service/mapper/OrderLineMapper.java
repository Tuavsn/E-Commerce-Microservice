package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.order.OrderLineDTO;
import com.ecommerce.order_service.entity.OrderLine;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OrderLineMapper extends BaseMapper<OrderLine, OrderLineDTO, UUID> {
    @Named("orderLineToOrderLineDTO")
    @Mapping(source = "productId", target = "product.id")
    @Override
    OrderLineDTO toDTO(OrderLine orderLine);

    @Named("orderLineDTOToOrderLine")
    @Mapping(source = "product.id", target = "productId")
    @Override
    OrderLine toModel(OrderLineDTO orderLineDTO);
}
