package com.e_commerce.user_service.dto;

import com.microservice.shared_library.dto.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO extends BaseDTO {
    @NotBlank(message = "Authority is mandatory")
    private String authority;
}
