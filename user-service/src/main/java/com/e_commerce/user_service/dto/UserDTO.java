package com.e_commerce.user_service.dto;

import com.microservice.shared_library.dto.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO extends BaseDTO {
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Full Name is mandatory")
    @Size(max = 40, message = "Full Name must be less than 40 characters")
    private String fullname;

    @Size(max = 12, message = "Phone number must be less than 12 numbers")
    private String phone;

    private String address;

    public @NotBlank(message = "Email is mandatory") String getEmail() {
        return email;
    }
}
