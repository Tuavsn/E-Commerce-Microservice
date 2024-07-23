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
public class ProductDTO extends BaseDTO {

    private String productTitle;

    private String sku;

    private String description;

    private String imageUrl;

    private Double priceUnit;

    private String unit;

    private CategoryDTO category;

    private BrandDTO brand;
}
