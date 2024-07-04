package com.ecommerce.product_service.dto;

import com.microservice.shared_library.dto.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO extends BaseDTO {
    @NotBlank(message = "Title is mandatory")
    @Size(max = 200, message = "Title must be less than 200 characters")
    private String categoryTitle;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Image is mandatory")
    private String imageUrl;

    private CategoryDTO parentCategory;

}
