package com.ecommerce.order_service.service.impl;

import com.ecommerce.order_service.client.ProductClient;
import com.ecommerce.order_service.dto.order.CartItemDTO;
import com.ecommerce.order_service.dto.product.ProductDTO;
import com.ecommerce.order_service.entity.CartItem;
import com.ecommerce.order_service.mapper.CartItemMapper;
import com.ecommerce.order_service.repository.CartItemRepository;
import com.ecommerce.order_service.service.CartItemService;
import com.microservice.shared_library.service.Impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartItemServiceImpl extends BaseServiceImpl<CartItem, CartItemDTO, UUID> implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;
    private final ProductClient productClient;

    public CartItemServiceImpl(
            CartItemRepository cartItemRepository,
            CartItemMapper cartItemMapper,
            ProductClient productClient
    ) {
        super(cartItemRepository, cartItemMapper);
        this.cartItemRepository = cartItemRepository;
        this.cartItemMapper = cartItemMapper;
        this.productClient = productClient;
    }

    @Override
    public List<CartItemDTO> findAll() {
        return ((List<CartItem>)cartItemRepository.findAll()).stream().map(cartItem -> {
            CartItemDTO cartItemDTO = cartItemMapper.toDTO(cartItem);
            ProductDTO productDTO = productClient.getProduct(cartItem.getProductId()).get(0);
            cartItemDTO.setProduct(productDTO);
            return cartItemDTO;
        }).toList();
    }

    @Override
    public Page<CartItemDTO> findAll(Pageable pageable, String search) {
        Page<CartItem> cartItemPages = cartItemRepository.findContaining(pageable,"%" + search + "%");
        return new PageImpl<>(
                cartItemPages.stream().map(cartItemPage -> {
                    CartItemDTO cartItemDTO = cartItemMapper.toDTO(cartItemPage);
                    ProductDTO productDTO = productClient.getProduct(cartItemPage.getProductId()).get(0);
                    cartItemDTO.setProduct(productDTO);
                    return cartItemDTO;
                }).toList(),
                pageable,
                cartItemPages.getTotalElements()
        );
    }
}
