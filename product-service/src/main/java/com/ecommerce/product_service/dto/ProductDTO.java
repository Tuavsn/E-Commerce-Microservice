package com.ecommerce.product_service.dto;

import com.microservice.shared_library.dto.BaseDTO;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO extends BaseDTO {
    @NotBlank(message = "Title is mandatory")
    @Size(max = 200, message = "Title must be less than 200 characters")
    private String productTitle;

    @NotBlank(message = "Sku is mandatory")
    private String sku;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Image is mandatory")
    private String imageUrl;

    @NotNull(message = "Price is mandatory")
    @Min(value = 1, message = "Minimum price must be greater or equal than 1")
    private Double priceUnit;

    @NotNull(message = "Unit is mandatory")
    @Size(max = 20, message = "Unit must be less than 20 characters")
    private String unit;

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 1, message = "Minimum quantity must be greater or equal than 1")
    private Integer quantity;

    @NotNull(message = "Category is mandatory")
    private CategoryDTO category;

    @NotNull(message = "Brand is mandatory")
    private BrandDTO brand;
}
