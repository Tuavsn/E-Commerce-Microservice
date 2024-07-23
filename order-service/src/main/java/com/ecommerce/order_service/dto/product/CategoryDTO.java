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
public class CategoryDTO extends BaseDTO {

    private String categoryTitle;

    private String description;

    private String imageUrl;
}
