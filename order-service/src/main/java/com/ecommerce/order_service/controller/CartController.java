package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.dto.order.CartDTO;
import com.ecommerce.order_service.entity.Cart;
import com.ecommerce.order_service.service.CartService;
import com.microservice.shared_library.controller.BaseController;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController extends BaseController<Cart, CartDTO, UUID> {

    private final CartService cartService;

    public CartController(CartService cartService) {
        super(cartService);
        this.cartService = cartService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<CartDTO> getCartByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(cartService.getCartByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/addItem")
    public ResponseEntity<CartDTO> addNewItem(
            @RequestParam() String userId,
            @RequestParam() String productId,
            @RequestParam(defaultValue = "1") int quantity
    ) {
        return new ResponseEntity<>(cartService.addItemToCart(userId, productId, quantity), HttpStatus.OK);
    }

    @PatchMapping("/changeItemQuantity")
    public ResponseEntity<CartDTO> changeItemQuantity(
            @RequestParam() String userId,
            @RequestParam() String cartItemId,
            @RequestParam(defaultValue = "1") int quantity
    ) {
        return new ResponseEntity<>(cartService.changeItemQuantity(userId, cartItemId, quantity), HttpStatus.OK);
    }

    @PatchMapping("/removeItem")
    public ResponseEntity<CartDTO> changeItemQuantity(
            @RequestParam() String userId,
            @RequestParam() String cartItemId
    ) {
        return new ResponseEntity<>(cartService.removeItemToCart(userId, cartItemId), HttpStatus.OK);
    }

    @PatchMapping("/clearCart/{userId}")
    public ResponseEntity<CartDTO> clearCart(@PathVariable String userId) {
        return new ResponseEntity<>(cartService.clearCart(userId), HttpStatus.OK);
    }
}
