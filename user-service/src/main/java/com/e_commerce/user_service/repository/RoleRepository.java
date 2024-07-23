package com.e_commerce.user_service.repository;

import com.e_commerce.user_service.entity.Role;
import com.microservice.shared_library.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends BaseRepository<Role, UUID> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false and (cast(BIN_TO_UUID(x.id) as string) like :search or x.authority like :search)"
    )
    Page<Role> findContaining(Pageable pageable, String search);
}
