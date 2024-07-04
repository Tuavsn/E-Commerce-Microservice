package com.ecommerce.product_service.repository;

import com.ecommerce.product_service.entity.Category;
import com.microservice.shared_library.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends BaseRepository<Category, UUID> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false and (cast(x.id as string) like :search or x.categoryTitle like :search)"
    )
    Page<Category> findContaining(Pageable pageable, String search);
}
