package com.ecommerce.order_service.mapper;

import com.ecommerce.order_service.dto.order.CartItemDTO;
import com.ecommerce.order_service.entity.CartItem;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CartItemMapper extends BaseMapper<CartItem, CartItemDTO, UUID> {
    @Named("cartItemToCartItemDTO")
    @Mapping(source = "productId", target = "product.id")
    @Override
    CartItemDTO toDTO(CartItem cartItem);

    @Named("cartItemDTOToCartItem")
    @Mapping(source = "product.id", target = "productId")
    @Override
    CartItem toModel(CartItemDTO cartItemDTO);
}
