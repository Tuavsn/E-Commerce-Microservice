package com.ecommerce.product_service.service.impl;

import com.ecommerce.product_service.dto.BrandDTO;
import com.ecommerce.product_service.entity.Brand;
import com.ecommerce.product_service.mapper.BrandMapper;
import com.ecommerce.product_service.repository.BrandRepository;
import com.ecommerce.product_service.service.BrandService;
import com.microservice.shared_library.service.BaseService;
import com.microservice.shared_library.service.Impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BrandServiceImpl extends BaseServiceImpl<Brand, BrandDTO, UUID> implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        super(brandRepository, brandMapper);
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }
}
