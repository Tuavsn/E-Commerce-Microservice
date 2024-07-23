package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.order.CartDTO;
import com.ecommerce.order_service.entity.Cart;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CartMapper extends BaseMapper<Cart, CartDTO, UUID> {
    @Named("cartToCartDTO")
    @Mapping(source = "userId", target = "user.id")
    @Override
    CartDTO toDTO(Cart cart);

    @Named("cartDTOToCart")
    @Mapping(source = "user.id", target = "userId")
    @Override
    Cart toModel(CartDTO cartDTO);
}
