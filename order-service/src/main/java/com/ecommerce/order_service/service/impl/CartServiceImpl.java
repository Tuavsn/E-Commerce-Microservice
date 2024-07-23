package com.ecommerce.order_service.service.impl;

import com.ecommerce.order_service.client.ProductClient;
import com.ecommerce.order_service.client.UserClient;
import com.ecommerce.order_service.dto.order.CartDTO;
import com.ecommerce.order_service.dto.order.CartItemDTO;
import com.ecommerce.order_service.dto.product.ProductDTO;
import com.ecommerce.order_service.dto.user.UserDTO;
import com.ecommerce.order_service.entity.Cart;
import com.ecommerce.order_service.entity.CartItem;
import com.ecommerce.order_service.mapper.CartItemMapper;
import com.ecommerce.order_service.mapper.CartMapper;
import com.ecommerce.order_service.repository.CartRepository;
import com.ecommerce.order_service.service.CartService;
import com.microservice.shared_library.exception.NotFoundException;
import com.microservice.shared_library.service.Impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl extends BaseServiceImpl<Cart, CartDTO, UUID> implements CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final CartItemMapper cartItemMapper;
    private final UserClient userClient;
    private final ProductClient productClient;

    public CartServiceImpl(
            CartRepository cartRepository,
            CartMapper cartMapper,
            CartItemMapper cartItemMapper,
            UserClient userClient,
            ProductClient productClient
    ) {
        super(cartRepository, cartMapper);
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.cartItemMapper = cartItemMapper;
        this.userClient = userClient;
        this.productClient = productClient;
    }

    @Override
    public CartDTO getCartByUserId(String userId) {
        return cartMapper.toDTO(cartRepository.getByUserId(userId));
    }

    @Override
    public CartDTO addItemToCart(String userId, String productId, int quantity) {
        Cart cart = cartRepository.getByUserId(userId);

        // if cart not exist, create new one
        if(cart == null) {
            cart = new Cart();
            cart.setUserId(UUID.fromString(userId));
        }

        // check if item already exist in cart
        Optional<CartItem> existingCartItem = cart.getCartItems().stream().filter(
                item -> item.getProductId().toString().equals(productId)
        ).findFirst();

        if(existingCartItem.isPresent()) {
            existingCartItem.get().setQuantity(
                    existingCartItem.get().getQuantity() + quantity
            );
        } else {
            cart.getCartItems().add( new CartItem(
                cart, UUID.fromString(productId), quantity
            ));
        }

        return cartMapper.toDTO(cartRepository.save(cart));
    }

    @Override
    public CartDTO changeItemQuantity(String userId, String cartItemId, int quantity) {
        Cart cart = cartRepository.getByUserId(userId);

        if(cart == null) {
            throw new NotFoundException("No cart found by user: " + userId);
        }

        // check if item already exist in cart
        Optional<CartItem> existingCartItem = cart.getCartItems().stream().filter(
                item -> item.getId().toString().equals(cartItemId)
        ).findFirst();

        if(existingCartItem.isPresent()) {
            existingCartItem.get().setQuantity(quantity);
        } else {
            throw new NotFoundException("No CartItem found!");
        }

        return cartMapper.toDTO(cartRepository.save(cart));
    }

    @Override
    public CartDTO removeItemToCart(String userId, String cartItemId) {
        Cart cart = cartRepository.getByUserId(userId);

        if(cart == null) {
            throw new NotFoundException("Cart not found for user: " + userId);
        }

        // check if item already exist in cart
        CartItem existingCartItem = cart.getCartItems().stream().filter(
                item -> item.getId().toString().equals(cartItemId)
        ).findFirst().orElseThrow(
                () -> new NotFoundException("No CartItem found in your Cart")
        );

        cart.removeCartItem(existingCartItem);

        return cartMapper.toDTO(cartRepository.save(cart));
    }

    @Override
    public CartDTO clearCart(String userId) {
        Cart cart = cartRepository.getByUserId(userId);
        if(cart != null) {
            cart.clearCartItems();
            return cartMapper.toDTO(cartRepository.save(cart));
        } else {
            throw new NotFoundException("Cart not found for user: " + userId);
        }
    }

    @Override
    public List<CartDTO> findAll() {
        return ((List<Cart>)cartRepository.findAll()).stream().map(cart -> {
            CartDTO cartDTO = cartMapper.toDTO(cart);
            cartDTO.setCartItems(
                    cart.getCartItems().stream().map(cartItem -> {
                        CartItemDTO cartItemDTO = cartItemMapper.toDTO(cartItem);
                        ProductDTO productDTO = productClient.getProduct(cartItem.getProductId()).get(0);
                        cartItemDTO.setProduct(productDTO);
                        return cartItemDTO;
                    }).collect(Collectors.toSet())
            );
            UserDTO userDTO = userClient.getUser(cart.getUserId()).get(0);
            cartDTO.setUser(userDTO);
            return cartDTO;
        }).toList();
    }

    @Override
    public Page<CartDTO> findAll(Pageable pageable, String search) {
        Page<Cart> cartPages = cartRepository.findContaining(pageable,"%" + search + "%");
        return new PageImpl<>(
                cartPages.stream().map(cartPage -> {
                    CartDTO cartDTO = cartMapper.toDTO(cartPage);
                    UserDTO userDTO = userClient.getUser(cartPage.getUserId()).get(0);
                    cartDTO.setUser(userDTO);
                    return cartDTO;
                }).toList(),
                pageable,
                cartPages.getTotalElements()
        );
    }

}
