package com.ecommerce.order_service.dto.product;

import com.microservice.shared_library.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandDTO extends BaseDTO {

    private String brandTitle;

    private String description;

    private String imageUrl;
}
