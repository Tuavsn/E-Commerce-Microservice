package com.ecommerce.order_service.service.impl;

import com.ecommerce.order_service.client.ProductClient;
import com.ecommerce.order_service.dto.order.OrderLineDTO;
import com.ecommerce.order_service.dto.product.ProductDTO;
import com.ecommerce.order_service.entity.OrderLine;
import com.ecommerce.order_service.mapper.OrderLineMapper;
import com.ecommerce.order_service.repository.OrderLineRepository;
import com.ecommerce.order_service.service.OrderLineService;
import com.microservice.shared_library.service.Impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderLineServiceImpl extends BaseServiceImpl<OrderLine, OrderLineDTO, UUID> implements OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;
    private final ProductClient productClient;

    public OrderLineServiceImpl(
            OrderLineRepository orderLineRepository,
            OrderLineMapper orderLineMapper,
            ProductClient productClient
    ) {
        super(orderLineRepository, orderLineMapper);
        this.orderLineRepository = orderLineRepository;
        this.orderLineMapper = orderLineMapper;
        this.productClient = productClient;
    }

    @Override
    public List<OrderLineDTO> findAll() {
        return ((List<OrderLine>)orderLineRepository.findAll()).stream().map(orderLine -> {
            OrderLineDTO orderLineDTO = orderLineMapper.toDTO(orderLine);
            ProductDTO productDTO = productClient.getProduct(orderLine.getProductId()).get(0);
            orderLineDTO.setProduct(productDTO);
            return orderLineDTO;
        }).toList();
    }

    @Override
    public Page<OrderLineDTO> findAll(Pageable pageable, String search) {
        Page<OrderLine> orderLinePages = orderLineRepository.findContaining(pageable,"%" + search + "%");
        return new PageImpl<>(
                orderLinePages.stream().map(orderLinePage -> {
                    OrderLineDTO orderLineDTO = orderLineMapper.toDTO(orderLinePage);
                    ProductDTO productDTO = productClient.getProduct(orderLinePage.getProductId()).get(0);
                    orderLineDTO.setProduct(productDTO);
                    return orderLineDTO;
                }).toList(),
                pageable,
                orderLinePages.getTotalElements()
        );
    }
}
