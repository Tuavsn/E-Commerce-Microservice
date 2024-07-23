package com.ecommerce.order_service.dto.order;

import com.ecommerce.order_service.dto.user.UserDTO;
import com.microservice.shared_library.dto.BaseDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDTO extends BaseDTO {
    @NotNull(message = "User is mandatory")
    private UserDTO user;

    private Set<CartItemDTO> cartItems;
}
