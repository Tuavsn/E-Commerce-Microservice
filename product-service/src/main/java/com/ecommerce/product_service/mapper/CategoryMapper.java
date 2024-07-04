package com.ecommerce.product_service.mapper;

import com.ecommerce.product_service.dto.CategoryDTO;
import com.ecommerce.product_service.entity.Category;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO, UUID> {
    @Named("categoryToCategoryDTO")
    @Override
    CategoryDTO toDTO(Category category);

    @Named("categoryDTOToCategory")
    @Override
    Category toModel(CategoryDTO categoryDTO);

    @Named("categoryListToCategoryDTOList")
    @Override
    List<CategoryDTO> toDTO(List<Category> categoryList);

    @Named("categoryDTOListToCategoryList")
    @Override
    List<Category> toModel(List<CategoryDTO> categoryDTOList);
}
