package com.ecommerce.order_service.client;

import com.ecommerce.order_service.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient("user-service")
public interface UserClient {
    @GetMapping("/user/{id}")
    List<UserDTO> getUser(@PathVariable UUID id);
}
