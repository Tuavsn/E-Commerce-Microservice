package com.ecommerce.product_service.service.impl;

import com.ecommerce.product_service.dto.ProductDTO;
import com.ecommerce.product_service.entity.Product;
import com.ecommerce.product_service.mapper.ProductMapper;
import com.ecommerce.product_service.repository.ProductRepository;
import com.ecommerce.product_service.service.ProductService;
import com.microservice.shared_library.service.BaseService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ProductServiceImpl extends BaseService<Product, ProductDTO, UUID> implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(
            ProductRepository productRepository,
            ProductMapper productMapper
    ) {
        super(productRepository, productMapper);
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public ProductDTO save(ProductDTO productDTO) { return super.save(productDTO); }

    @Override
    @Transactional
    public ProductDTO update(ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productDTO.getId())
                .orElseThrow(() -> new NotFoundException("Product not found"));
        if(productDTO.getProductTitle() != null) {
            existingProduct.setProductTitle(productDTO.getProductTitle());
        }
        if(productDTO.getDescription() != null) {
            existingProduct.setDescription(productDTO.getDescription());
        }
        if(productDTO.getSku() != null) {
            existingProduct.setSku(productDTO.getSku());
        }
        if(productDTO.getImageUrl() != null) {
            existingProduct.setImageUrl(productDTO.getImageUrl());
        }
        if(productDTO.getPriceUnit() != null) {
            existingProduct.setPriceUnit(productDTO.getPriceUnit());
        }
        if(productDTO.getQuantity() != null) {
            existingProduct.setQuantity(productDTO.getQuantity());
        }

        return productMapper.toDTO(productRepository.save(existingProduct));
    }

    @Override
    public List<ProductDTO> findByIdPublic(Set<UUID> ids) {
        List<Product> products = (List<Product>)productRepository.findAllById(ids);
        if(products.isEmpty()) {
            throw new NotFoundException("Product not found");
        }
        return productMapper.toDTO(products);
    }
}
