package com.ecommerce.order_service.dto.user;

import com.microservice.shared_library.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO extends BaseDTO {

    private String email;

    private String fullname;

    private String phone;

    private String address;

}
