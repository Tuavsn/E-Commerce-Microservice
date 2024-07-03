package com.e_commerce.user_service.dto;

import com.microservice.shared_library.dto.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO extends BaseDTO {
    @NotBlank(message = "Authority is mandatory")
    private String authority;
}
