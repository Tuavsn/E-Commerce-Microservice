package com.ecommerce.order_service.repository;

import com.ecommerce.order_service.entity.Cart;
import com.ecommerce.order_service.entity.CartItem;
import com.microservice.shared_library.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartItemRepository extends BaseRepository<CartItem, UUID> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false and (cast(BIN_TO_UUID(x.id) as string) like :search)"
    )
    Page<CartItem> findContaining(Pageable pageable, String search);
    List<CartItem> findByCart(Cart cart);
}
