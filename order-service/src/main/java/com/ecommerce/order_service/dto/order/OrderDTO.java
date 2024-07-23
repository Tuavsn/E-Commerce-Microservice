package com.ecommerce.order_service.dto.order;

import com.ecommerce.order_service.entity.OrderStatus;
import com.ecommerce.order_service.entity.PaymentType;
import com.ecommerce.order_service.entity.ShippingProvider;
import com.microservice.shared_library.dto.BaseDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO extends BaseDTO {
    @NotNull(message = "Order date is mandatory")
    private LocalDateTime orderDate;

    private String orderDesc;

    @NotNull(message = "Order fee is mandatory")
    @Min(value = 0, message = "Order fee must be greater or equal than 0")
    private double orderFee = 0;

    @NotNull(message = "Total is mandatory")
    @Min(value = 0, message = "Total must be greater or equal than 0")
    private double total = 0;

    @NotNull(message = "Payment type is mandatory")
    private PaymentType paymentType;

    @NotNull(message = "Shipping provider is mandatory")
    private ShippingProvider shippingProvider;

    @NotNull(message = "Order status is mandatory")
    private OrderStatus orderStatus;

    @NotNull(message = "Cart is mandatory")
    private CartDTO cart;

    private Set<OrderLineDTO> orderLines;
}
