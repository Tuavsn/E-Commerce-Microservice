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
public class OrderLineDTO extends BaseDTO {
    @NotNull(message = "Order is mandatory")
    private OrderDTO order;

    @NotNull(message = "Product is mandatory")
    private ProductDTO product;

    @NotNull(message = "Product price is mandatory")
    @Min(value = 0, message = "Product price must be greater or equal than 0")
    private double price;

    @NotNull(message = "Product quantity is mandatory")
    @Min(value = 0, message = "Product quantity must be greater or equal than 0")
    private int quantity;
}
