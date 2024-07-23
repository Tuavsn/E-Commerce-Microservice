package com.ecommerce.order_service.dto.order;

import com.ecommerce.order_service.dto.product.ProductDTO;
import com.microservice.shared_library.dto.BaseDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItemDTO extends BaseDTO {
    @NotNull(message = "Product is mandatory")
    private ProductDTO product;

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 1, message = "Minimum quantity must be greater or equal than 1")
    private int quantity;
}
