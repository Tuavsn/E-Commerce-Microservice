package com.ecommerce.product_service.mapper;

import com.ecommerce.product_service.dto.BrandDTO;
import com.ecommerce.product_service.entity.Brand;
import com.microservice.shared_library.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface BrandMapper extends BaseMapper<Brand, BrandDTO, UUID> {
    @Named("brandToBrandDTO")
    @Override
    BrandDTO toDTO(Brand brand);

    @Named("brandDTOToBrand")
    @Override
    Brand toModel(BrandDTO brandDTO);

    @Named("brandListToBrandDTOList")
    @Override
    List<BrandDTO> toDTO(List<Brand> brandList);

    @Named("brandDTOListToBrandList")
    @Override
    List<Brand> toModel(List<BrandDTO> brandDTOList);
}
