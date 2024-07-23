package com.ecommerce.order_service.client;

import com.ecommerce.order_service.dto.product.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@FeignClient("product-service")
public interface ProductClient {
    @GetMapping("/product/{id}")
    List<ProductDTO> getProduct(@PathVariable UUID id);

    @GetMapping("/product/{ids}")
    List<ProductDTO> getProducts(@PathVariable Set<UUID> ids);
}
